package com.classes;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by jlutz on 11/24/2015.
 */
public class CurrentUser extends User {
    private Customer user;

    public Integer getId()
    {
        return user.getCustomerId();
    }

    public Customer getUser() {
        return user;
    }

    public CurrentUser(Customer user) {
        super(user.getCustomerLogin(), user.getCustomerPassword(),
                AuthorityUtils.createAuthorityList("USER"));
        this.user = user;
    }
}
