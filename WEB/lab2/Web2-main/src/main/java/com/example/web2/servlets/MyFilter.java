package com.example.web2.servlets;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter{
    public static long count = 0;

    @Override
    synchronized public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        count++;
        System.out.println(count);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
