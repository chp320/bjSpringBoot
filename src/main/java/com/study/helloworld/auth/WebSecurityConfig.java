package com.study.helloworld.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration          // 스프링 설정으로 사용한다는 의미
@EnableWebSecurity      // 스프링 시큐리티 기능 활성화 의미
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    public AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
//    @RequiredArgsConstructor
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
                /* 로그인 실패 시, 로그인페이지로 전달하기 위해 failureUrl 수정. 단, 쿼리스트링 추가 */
//                .failureUrl("/loginError")  // default: /login?error
//                .failureUrl("/loginForm?error")
                // AuthenticationFailureHandler는 인터페이스이기 때문에 그 구현체 CustomAuthenticationFailureHandler 객체를 파라미터로 넘기도록 수정

//                .failureHandler(authenticationFailureHandler)
                .failureHandler(customAuthenticationFailureHandler)
                .defaultSuccessUrl("/member/welcome")   // 로그인 성공시 호출할 url. 미지정 시 root(/)로 이동
                .usernameParameter("j_username")    // default: j_username
                .passwordParameter("j_password")  // default: j_password
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
