package com.study.helloworld.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration          // 스프링 설정으로 사용한다는 의미
@EnableWebSecurity      // 스프링 시큐리티 기능 활성화 의미
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**", "/js/**", "/img/**").permitAll()
                .antMatchers("/guest/**").permitAll()
                .antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
/* 시큐리티 커스텀 구현을 위한 메서드 추가 - formLogin(), logout() */
        http.formLogin()
                .loginPage("/loginForm")        // 로그인폼 url 지정, default: /login
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/loginError")  // default: /login?error
                //.defaultSuccessUrl("/"
                .usernameParameter("j_username")    // default: j_username
                .passwordParameter(("j_password"))  // default: j_password
                .permitAll();

        http.logout()
                .logoutUrl("/logout")           // default
                .logoutSuccessUrl("/")
                .permitAll();

        // ssl 사용하지 않을 경우 '잘못된 토크 예외' 발생하기 때문에 disable 처리, http에서 https에 대한 요청 처리 시 발생
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
        // ROLE_ADMIN 에서 ROLE_ 는 자동으로 붙는다.
    }

    // passwordEncoder() 추가
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
