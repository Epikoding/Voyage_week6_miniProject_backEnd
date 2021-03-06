package com.tenzo.mini_project2.security;


import com.tenzo.mini_project2.security.jwt.JwtTokenProvider;
import com.tenzo.mini_project2.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@RequiredArgsConstructor
public class ReIssueAop {

    private final UserService service;
    private final JwtTokenProvider jwtTokenProvider;
    private final HttpServletResponse response;
    private final HttpServletRequest request;
    @Pointcut("execution(public * com.tenzo.mini_project2.web.controller..*.*(..))&& !@target(com.tenzo.mini_project2.web.controller.PermitAll)")
    public void webPackagePointcut() {
    }

    @Around("webPackagePointcut()")
    public Object reIssueAdaptor(ProceedingJoinPoint joinPoint) throws Throwable {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
            service.reIssuance(userDetails, request, response);
            return joinPoint.proceed();

    }

}
