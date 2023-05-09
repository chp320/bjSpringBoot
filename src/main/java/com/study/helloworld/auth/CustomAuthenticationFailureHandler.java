package com.study.helloworld.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 스프링 시큐리티 인증 처리 시, 이 사용자 정의 클래스 지정하면 인증 실패 시 onAuthenticationFailure()를 호출한다.
 */
@Service
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String loginid = request.getParameter("j_username");
        String errormsg = "";

        // Exception에 따른 메시지 설정
        if (exception instanceof BadCredentialsException) {
            loginFailureCount(loginid);
            errormsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            loginFailureCount(loginid);
            errormsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
        } else if (exception instanceof DisabledException) {
            errormsg = "계정이 비활성화되었습니다. 관리자에게 문의하세요.";
        } else if (exception instanceof CredentialsExpiredException) {
            errormsg = "비밀번호 유효기간이 만료되었습니다. 관리자에게 문의하세요.";
        }

        request.setAttribute("username", loginid);
        request.setAttribute("error_message", errormsg);

        request.getRequestDispatcher("/loginForm?error=true").forward(request, response);
    }

    // 비밀번호를 3번 이상 틀릴 시 계정 잠금 처리
    private void loginFailureCount(String username) {
        // 슈도 코드
        /*
        // 틀린 횟수 업데이트
        userDao.countFailure(username);
        // 틀린 횟수 조회
        int cnt = userDao.checkFailureCount(username);
        if (cnt == 3) {
            // 계정 잠금 처리
            userDao.disabledUsername(username);
        }
        */
    }
}
