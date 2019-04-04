package com.github.robertlocke.web;

import com.github.robertlocke.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


@WebServlet(name = "HighchartSeries", urlPatterns = {"/highchartFormatter"})
public class HighchartFormatter extends HttpServlet {

    protected void doQuestion1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();


        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, avg(total) average from SQL_PERFORMANCE where instance = 'read' group by site");

            String site = null;
            double total = 0d;

           ArrayList<HighchartSeries> series = new ArrayList<>();


            while (rs.next()) {
                site = rs.getString("site");
                total = rs.getDouble("average");

                HighchartSeries highchartSeries = new HighchartSeries(site, new ArrayList<Double>(Arrays.asList(total)));
               series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);


        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, min(total) minimum from SQL_PERFORMANCE where instance = 'create' group by site");

            String site = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();


            while (rs.next()) {
                site = rs.getString("site");
                total = rs.getDouble("minimum");

                HighchartSeries highchartSeries = new HighchartSeries(site, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, max(total) maximum from SQL_PERFORMANCE where instance = 'truncate' group by site");

            String site = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();


            while (rs.next()) {
                site = rs.getString("site");
                total = rs.getDouble("maximum");

                HighchartSeries highchartSeries = new HighchartSeries(site, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion41(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();


        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, config, avg(total) average, rank() over(partition by site order by avg(total)) Rank from sql_performance where instance ='read' and site = 'hcanfllive' group by site, config");


            String config1 = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();

            while (rs.next()) {
                config1 = rs.getString("config");
                total = rs.getDouble("average");

                HighchartSeries highchartSeries = new HighchartSeries(config1, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);


            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }


    protected void doQuestion42(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();


        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, config, avg(total) average, rank() over(partition by site order by avg(total)) Rank from sql_performance where instance ='read' and site = 'hcaefladvclive' group by site, config");


            String config1 = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();

            while (rs.next()) {
                config1 = rs.getString("config");
                total = rs.getDouble("average");

                HighchartSeries highchartSeries = new HighchartSeries(config1, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion43(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();


        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, config, avg(total) average, rank() over(partition by site order by avg(total)) Rank from sql_performance where instance ='read' and site = 'hcatristaradvclive' group by site, config");


            String config1 = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();

            while (rs.next()) {
                config1 = rs.getString("config");
                total = rs.getDouble("average");

                HighchartSeries highchartSeries = new HighchartSeries(config1, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select e.site, e.createtime, e.total from sql_performance e where total = (select min(total) from sql_performance where e.site = site)");

            String site = null;
            String createtime = null;
            double total = 0d;
            ArrayList<HighchartSeries> series = new ArrayList<>();


            while (rs.next()) {
                site = rs.getString("site");
                createtime = rs.getString("createtime");
                total = rs.getDouble("total");

                HighchartSeries highchartSeries = new HighchartSeries(site + " " + createtime, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    protected void doQuestion6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Configuration configuration = new Configuration();
        Database db = null;

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        try {
            db = new Database(configuration);
            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select site, sum(case when total < 0.3 then 1 else 0 end)/(count(*))*100 percentage from sql_performance where instance = 'read' group by site");

            String site = null;
            double total = 0d;

            ArrayList<HighchartSeries> series = new ArrayList<>();


            while (rs.next()) {
                site = rs.getString("site");
                total = rs.getDouble("percentage");

                HighchartSeries highchartSeries = new HighchartSeries(site, new ArrayList<Double>(Arrays.asList(total)));
                series.add(highchartSeries);
            }

            Gson gson = new Gson();
            String json = gson.toJson(series);

            out.print(json);

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forParam = request.getParameter("for");

        if ("question1".equals(forParam)) {
            doQuestion1(request, response);
            return;
        } else if("question2".equals(forParam)) {
            doQuestion2(request, response);
            return;
        }else if("question3".equals(forParam)) {
            doQuestion3(request, response);
            return;
       } else if("question41".equals(forParam)) {
            doQuestion41(request, response);
            return;
        } else if ("question42".equals(forParam)) {
            doQuestion42(request, response);
            return;
        }else if("question43".equals(forParam)) {
            doQuestion43(request, response);
            return;
        }else if ("question5".equals(forParam)) {
            doQuestion5(request, response);
            return;
        }else if ("question6".equals(forParam)) {
            doQuestion6(request, response);
            return;
        }else {
            response.sendError(404);
        }
    }
}