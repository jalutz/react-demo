package com;

//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    //@Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/"
////                        , "/index.html"
////                        , "/*.js"
////                        , "/data.json"
////                        , "/dist/bundle.js"
////                        , "/doorImages/*"
////                        , "/user"
////                        , "/getproducts"
////                        , "/addcartitem"
////                        , "/addcustomer"
////                        , "/login?error"
////                        , "/findcustomerbyusername"
////                        , "/findcustomerbyemail"
////                        , "/customers"
////                        , "/logout").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
////                .formLogin()
////                .loginPage("/customers/login.html")
////                .permitAll()
////                .and()
////                .httpBasic()
////                .and()
////                .csrf().csrfTokenRepository(csrfTokenRepository())
////                .and()
////                .logout()
////                .permitAll();
////    }
//
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName("X-XSRF-TOKEN");
//        return repository;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//}