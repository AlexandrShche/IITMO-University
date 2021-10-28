package com.example.web2.model;

import javax.servlet.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Results {

    private final Deque<Point> pointDeque;

    public Results() {
        pointDeque = new ArrayDeque<>();
    }

    public void add(Point point) {
        int MAX_SIZE = 10;
        if(pointDeque.size() > MAX_SIZE)
            pointDeque.pollFirst();
        pointDeque.addLast(point);
    }

    public List<Point> getPoints() {
        return pointDeque.stream().sorted(Point::compareTo).collect(Collectors.toList());
    }
}


//public class Results  implements Servlet {
//    private ServletConfig config;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//        ServletContext sc = config.getServletContext();
//        sc.log("init");
////        sc.setAttribute();
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return null;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//
//    }
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//
//}

