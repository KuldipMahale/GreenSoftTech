package com.greensoft.springboot.config;

public class GreenSoftConfig{

}

/*
@Configuration
@EnableWebSecurity
public class GreenSoftConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated().and().httpBasic();


    }
}
*/
