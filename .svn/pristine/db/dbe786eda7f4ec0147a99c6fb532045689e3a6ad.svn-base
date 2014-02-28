package com.lenovo.newThink.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		//StringBuffer url = req.getRequestURL();
		String parameter = req.getQueryString();
		//url = url.append("?");
		//url = url.append(parameter);
		if (parameter.equals("m=login")) {
			chain.doFilter(request, response);
		} else if (session.getAttribute("userid") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("********Request Filter********");
	}

}
