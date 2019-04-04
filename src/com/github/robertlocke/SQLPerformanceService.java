package com.github.robertlocke;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPerformanceService {

    private Database db;

    public SQLPerformanceService(Database db) {
        this.db = db;
    }

    public List<SQLPerformanceSample> anwserQuestion1() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select site, avg(total) from SQL_PERFORMANCE where instance = 'read' group by site");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setTotal(rs.getFloat("avg(total)"));

            list.add(sample);
        }

        rs.close();
        stmt.close();

        return list;
    }


    public List<SQLPerformanceSample> anwserQuestion2() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select site, min(total) from SQL_PERFORMANCE where instance = 'create' group by site");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setTotal(rs.getFloat("min(total)"));

            list.add(sample);
        }

        rs.close();
        stmt.close();

        return list;
    }


    public List<SQLPerformanceSample> anwserQuestion3() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select site, max(total) from SQL_PERFORMANCE where instance = 'truncate' group by site");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setTotal(rs.getFloat("max(total)"));

            list.add(sample);
        }

        rs.close();
        stmt.close();

        return list;
    }

    public List<SQLPerformanceSample> anwserQuestion4() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select site, config, avg(total), rank() over(partition by site order by avg(total))\"Rank\" from sql_performance where instance ='read' group by site, config ");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setConfig(rs.getString("config"));
            sample.setTotal(rs.getFloat("avg(total)"));
            sample.setRank(rs.getInt("Rank"));

            list.add(sample);
        }

        rs.close();
        stmt.close();

        return list;
    }

    public List<SQLPerformanceSample> anwserQuestion5() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select e.site, e.createtime, e.total from sql_performance e where total = (select min(total) from sql_performance where e.site = site)");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setCreateTime(rs.getDate("createtime"));
            sample.setTotal(rs.getFloat("total"));



            list.add(sample);
        }



        rs.close();
        stmt.close();

        return list;
    }

    public List<SQLPerformanceSample> anwserQuestion6() throws SQLException {
        List<SQLPerformanceSample> list = new ArrayList<SQLPerformanceSample>();

        Statement stmt = db.getStatement();
        ResultSet rs = stmt.executeQuery("select site, sum(case when total < 0.3 then 1 else 0 end)/(count(*))*100  \"Percentage Times\" from sql_performance where instance = 'read' group by site");

        while (rs.next()) {

            SQLPerformanceSample sample = new SQLPerformanceSample();
            sample.setSite(rs.getString("site"));
            sample.setTotal(rs.getFloat("Percentage Times"));

            list.add(sample);
        }

        rs.close();
        stmt.close();

        return list;
    }
}
