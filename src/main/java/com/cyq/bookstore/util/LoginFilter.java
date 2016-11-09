package com.cyq.bookstore.util;
/**
 * 登录拦截器
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		/*得到session*/
		HttpSession session = request.getSession();
		/*得到url 除了项目名称后面的路径*/
		String url = request.getServletPath();

		System.out.println(request.getServletPath());

		if ( (!request.getServletPath().endsWith("userLogin.jsp"))
				&& (!request.getServletPath().endsWith("goLogin.jsp"))) {
	
			if (session.getAttribute("user") == null) {
				System.out.println("session不存在");
				/* 清空session*/
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/jsp/goLogin.jsp");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}

