package com.db;

import com.bean.EventBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger; // 記得 import 剛剛寫好的 Bean

public class EventDB {

    // (i). Define necessary variable and constructor of the class.
    private String url = "";
    private String username = "";
    private String password = "";

    public EventDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // (ii). Define a getConnection() with driver loading and connection return.
    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DriverManager.getConnection(url, username, password);
    }

    // (iii). Implement getEvents(String venue) to query the event (criteria venue)
    // within the database and return an ArrayList of EventBean using Statement.
    public ArrayList<EventBean> getEvents(String venue) {
        Connection cnnct = null;
        Statement stmnt = null;
        ResultSet rs = null;
        ArrayList<EventBean> eventList = new ArrayList<EventBean>(); // 準備好要回傳的 ArrayList

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();

            // 注意：因為 venue 在資料庫是 VARCHAR，所以這裡外面要加上單引號 "'"
            String sql = "SELECT * FROM eventTable WHERE venue = '" + venue + "'";

            // 執行查詢並把結果放入 ResultSet
            rs = stmnt.executeQuery(sql);

            // 將 ResultSet 中的每一筆資料轉換成 EventBean 物件
            while (rs.next()) {
                EventBean event = new EventBean();
                event.setEventID(rs.getInt("eventID"));
                event.setEventName(rs.getString("eventName"));
                event.setEventDate(rs.getString("eventDate"));
                event.setVenue(rs.getString("venue"));
                event.setTicketPrice(rs.getInt("ticketPrice"));
                event.setSeatsAvailable(rs.getInt("seatsAvailable"));

                eventList.add(event); // 將設定好的 bean 加入 list 中
            }

        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 良好的習慣：確保資源被釋放
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmnt != null) stmnt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (cnnct != null) cnnct.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        // 回傳裝滿資料的 ArrayList
        return eventList;
    }
}