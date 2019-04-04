package com.github.robertlocke.web;

import com.github.robertlocke.Configuration;
import com.github.robertlocke.Database;
import com.github.robertlocke.SQLPerformanceSample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "ExportAll", urlPatterns = {"/all"})
public class ExportAll extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Configuration configuration = new Configuration();

        Database db = null;
        ArrayList<SQLPerformanceSample> data = new ArrayList<SQLPerformanceSample>();


        try {


            db = new Database(configuration);
            db.open();
            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select * from sql_performance");

            while (rs.next()) {
                //data.add("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getDate(2) + "</td><td>" + rs.getDate(3) + "</td><td>" + rs.getString(4)+ "</td><td> " + rs.getString(5) + "</td><td>" +  rs.getString(6) + "</td><td>" + rs.getInt(7) + "</td><td>" + rs.getFloat(8) +  "</td><td>" + rs.getFloat(9) + "</td><td>" + rs.getFloat(10) +  "</td><td>" + rs.getString(11) + "</td><td>" + rs.getFloat(12) + "</td><td>" + rs.getFloat(13) + "</td><td>" + rs.getFloat(14) + "</td><td>" + rs.getString(15) + "</td><td>" + rs.getLong(16) + "</td><td>" + rs.getLong(17) + "</td><td>" + rs.getLong(18) + "</td><td>" + rs.getInt(19) +  "</td><td>" + rs.getInt(20) + "</td></tr>");
                SQLPerformanceSample sample = new SQLPerformanceSample();

                sample.setId(rs.getInt("id"));
                sample.setCreateTime(rs.getDate("createtime"));
                sample.setPersistTime(rs.getDate("persisttime"));
                sample.setSite(rs.getString("site"));
                sample.setConfig(rs.getString("config"));
                sample.setQuery(rs.getString("query"));
                sample.setNumrows(rs.getInt("numrows"));
                sample.setFetch(rs.getFloat("fetch"));
                sample.setTotal(rs.getFloat("total"));
                sample.setExecution(rs.getFloat("execution"));
                sample.setInstance(rs.getString("instance"));
                sample.setOpen(rs.getFloat("open"));
                sample.setCommit(rs.getFloat("commit"));
                sample.setClose(rs.getFloat("close"));
                sample.setSupportmode(rs.getString("supportmode"));
                sample.setLocalid(rs.getLong("localid"));
                sample.setServerid(rs.getLong("serverid"));
                sample.setQueueid(rs.getLong("queueid"));
                sample.setAlertlevel(rs.getFloat("alertlevel"));
                sample.setAlertmax(rs.getFloat("alertmax"));

                data.add(sample);

            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            response.sendError(500, e.getMessage());
            return;
        } finally {
            if (db != null) {
                db.close();
            }
        }

        request.setAttribute("data", data);

        request.getRequestDispatcher("/WEB-INF/views/displayQueries.jsp").forward(request, response);
        return;

    }

}


