/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliobe.aitabe.Security;

import com.portfoliobe.aitabe.Security.Service.UserDetailsImpl;
import com.portfoliobe.aitabe.Security.jwt.JwtEntryPoint;
import com.portfoliobe.aitabe.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter{
    @Autowired
    public UserDetailsImpl userDetailsServicesImpl;
    public JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.cors().csrf().disable()
              .authorizeReques()
              .antMatchers("/auth/**").permitAll()
              .anyRequest().authenticated()
              .and()
              .exceptionHandling.authenticationEntryPoint(jwtEntryPoint)
              .and()
              .sessionManagement().sesionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.addFilterBefore(jwtTokenFilter(), UserPasswordAuthenticationFilter.class);       
    }
*/    
    @Override
    public AuthenticationManager authenticationManager() {
        return super.authenticationManager(); 
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean(); 
    }    

}
