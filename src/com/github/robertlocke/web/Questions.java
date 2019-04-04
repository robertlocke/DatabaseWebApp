package com.github.robertlocke.web;

import com.github.robertlocke.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "Questions", urlPatterns = {"/questions"})
public class Questions extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Configuration configuration = new Configuration();
        Database db = null;

        try {
            db = new Database(configuration);
            db.open();

            SQLPerformanceService svc = new SQLPerformanceService(db);

            request.setAttribute("data1", svc.anwserQuestion1());
            request.setAttribute("data2", svc.anwserQuestion2());
            request.setAttribute("data3", svc.anwserQuestion3());
            request.setAttribute("data4", svc.anwserQuestion4());
            request.setAttribute("data5", svc.anwserQuestion5());
            request.setAttribute("data6", svc.anwserQuestion6());



        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }

  //      javax.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/highchartFormatter");
//        requestDispatcher.forward(request, response);
        request.getRequestDispatcher("/WEB-INF/views/questions.jsp").forward(request, response);

        return;
    }



}


