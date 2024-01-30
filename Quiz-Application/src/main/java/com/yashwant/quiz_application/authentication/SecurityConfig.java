package com.yashwant.quiz_application.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


	@Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;
    
  
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
            
                .requestMatchers("/auth/login")
                .permitAll()
           
                .requestMatchers(HttpMethod.POST ,"/auth/register")
                .permitAll()
                
                .requestMatchers(HttpMethod.PUT, "/users/updateUser/{userId}")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/getReport/")
                .permitAll()
        
                .requestMatchers(HttpMethod.DELETE ,"/users/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.GET ,"/users/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST ,"/quiz/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.DELETE ,"/quiz/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.GET ,"/quiz/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT ,"/quiz/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.POST ,"/question/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.DELETE ,"/question/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.GET ,"/question/**").hasAuthority("Admin")
                .requestMatchers(HttpMethod.PUT ,"/question/**").hasAuthority("Admin")
               
                .requestMatchers(HttpMethod.GET ,"/getQuiz/**").hasAuthority("Normal_User")
                .requestMatchers(HttpMethod.POST ,"/submitResponse/**").hasAuthority("Normal_User")
             
                
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    	
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    
    }
    
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

    



}