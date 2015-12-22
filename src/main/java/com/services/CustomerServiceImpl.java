package com.services;

import com.classes.CurrentUser;
import com.classes.Customer;
import com.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by jlutz on 11/20/2015.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer GetCustomerByUsername(String username) {
        return customerRepository.FindCustomerByUsername(username);
    }

    @Override
    public Customer GetCustomerByEmail(String email) {
        return customerRepository.FindCustomerByEmail(email);
    }

    public void AddCustomer(Customer customer)
    {
        String rawPassword = customer.getCustomerPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(rawPassword);
        customer.setCustomerPassword(encryptedPassword);

        customerRepository.saveAndFlush(customer);

        Properties props = new Properties();
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, null); //.getDefaultInstance(props, null);

        String msgBody = "Your username is: " + customer.getCustomerLogin();

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("admin@norgay.com", "Shopping System Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(customer.getCustomerEmail(), customer.getCustomerFirstName() + " " +  customer.getCustomerLastName()));
            msg.setSubject("Your account has been created!");
            msg.setText(msgBody);
            System.out.println(msg.getAllRecipients()[0]);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> GetAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user;

        try
        {
           user = customerRepository.FindCustomerByUsername(username);
            return new CurrentUser(user);
        }
        catch(UsernameNotFoundException e)
        {
            throw new UsernameNotFoundException("User does not exist.");
        }
    }
}
