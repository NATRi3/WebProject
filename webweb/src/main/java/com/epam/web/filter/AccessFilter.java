/*package com.epam.web.filter;

import com.epam.web.util.PagePath;
import com.epam.web.util.SessionParam;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = { "/jsp/user/*" })
public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String access = session.getAttribute(SessionParam.SESSION_PARAM_USER_ACCESS).toString();
        RequestDispatcher dispatcher = null;
        switch (access){
            case "BLOCKED":
                dispatcher = request.getRequestDispatcher(PagePath.LOGIN_PAGE);
            case "ACTIVE":
                dispatcher = request.getRequestDispatcher(PagePath.LOGIN_PAGE);
            case "ADMIN":
                ;
            default:
                dispatcher = request.getRequestDispatcher(PagePath.LOGIN_PAGE);
        }
        if(dispatcher!=null) {
            dispatcher.forward(request, response);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}*/