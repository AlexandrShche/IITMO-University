package com.example.web2.servlets;

import com.example.web2.model.Clock;
import com.example.web2.model.Point;
import com.example.web2.model.Results;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.*;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Point point = getPoint(req, resp);
        if(!point.isValid()) {
            return;
        }
        Results answerList = getResultsAddPoint(point);
        getServletContext().setAttribute("results", answerList);
        if(req.getParameter("Canvas_clicked") == null)
            headToTablePage(req, resp, point);
        else
            sendAJAXResponse(resp, point);
    }

    private Results getResultsAddPoint(Point check) {
        Results answerList = (Results) getServletContext().getAttribute("results");
        if(answerList == null)
            answerList = new Results();
        answerList.add(check);
        return answerList;
    }

    private void sendAJAXResponse(HttpServletResponse resp, Point point) throws IOException {
        JSONObject jo = new JSONObject(point);
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write(jo.toString());
    }

    private void headToTablePage(HttpServletRequest req, HttpServletResponse resp, Point check) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/index.jsp");
        getServletContext().setAttribute("check", check);
        rd.include(req, resp);
    }

    private Point getPoint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Clock clock = new Clock();
        clock.start();
        double x = Double.parseDouble(req.getParameter("X_field"));
        double y = Double.parseDouble(req.getParameter("Y_field"));
        double r = Double.parseDouble(req.getParameter("R_field"));
        Point point = new Point(x, y, r);
        point.setResult(isAreaHit(x, y, r));
        point.setClock(clock);
        if (!isValid(x, y, r)) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            point.setValid(false);
        }
        clock.finish();
        return point;
    }

    public boolean isAreaHit(double x, double y, double r) {
        return ((x >= 0) && (x <= r) && (y >= 0) && (y <= r/2) && (x + y*2 < r)) ||
                ((x >= 0) && (y <= 0) && (x*x + y*y) <= (((r*r)/4))) ||
                ((x >= -r) && (x <= 0) && (y >= -r) && (y <= 0));
    }

    public boolean isValid(double x, double y, double r) {
        return (x >= -2) && (x <= 2) && (y > -3) && (y < 5) && (r >= 1) && (r <= 5);
    }
}