package edu.mum.scm.interceptor;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Principal principal = request.getUserPrincipal();
		if (principal != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", principal.getName());
		}

		return true;
	}
}
