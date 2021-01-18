/*package com.epam.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;
@WebFilter(urlPatterns = { "/*" })
public class filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration<String> str =servletRequest.getParameterNames();
        String param;
        while (str.hasMoreElements()){
            String element = str.nextElement();
            param = servletRequest.getParameter(element);
            param.replaceAll("<","&lt;").replaceAll(">","&gt;");
            servletRequest.setAttribute(element,param);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}*/
