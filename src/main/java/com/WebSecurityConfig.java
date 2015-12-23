package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    //@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/"
//                        , "/index.html"
//                        , "/*.js"
//                        , "/data.json"
//                        , "/dist/bundle.js"
//                        , "/doorImages/*"
//                        , "/user"
//                        , "/getproducts"
//                        , "/addcartitem"
//                        , "/addcustomer"
//                        , "/login?error"
//                        , "/findcustomerbyusername"
//                        , "/findcustomerbyemail"
//                        , "/customers"
//                        , "/logout").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
//                .formLogin()
//                .loginPage("/customers/login.html")
//                .permitAll()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().csrfTokenRepository(csrfTokenRepository())
//                .and()
//                .logout()
//                .permitAll();
//    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}