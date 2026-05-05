/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.EventBean;
import com.db.EventDB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author user
 */
@WebServlet(name = "ListEventServlet", urlPatterns = "/searchEventServlet")
public class ListEventServlet extends HttpServlet {
    private EventDB eventDB;

    public void init() {
        eventDB = new EventDB("jdbc:mysql://localhost:3306/EVENTSDB", "root", "");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 取得前端表單傳來的參數 (Parameter)
        // 注意：這裡的 "venue" 必須與 searchEvents.jsp 表單中的 name 屬性完全一致！
        String venue = request.getParameter("venue");

        // 2. 基本的安全檢查（雖然題目說可以忽略例外，但加個判斷總是好的）
        if (venue != null && !venue.isEmpty()) {

            // 3. 呼叫 EventDB 去資料庫查詢符合該 venue 的資料
            ArrayList<EventBean> events = eventDB.getEvents(venue);

            // 4. 將查到的 ArrayList 存入 "request" scope 中
            // 第一個參數 "events" 是屬性名稱，JSP 端會用這個名字來拿資料
            request.setAttribute("events", events);

            // 5. 轉交 (Forward) 給 list.jsp 來顯示結果
            RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
            rd.forward(request, response);

        } else {
            // 如果沒抓到參數，可以印出錯誤訊息 (非強制，但符合常理)
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h3>Error: Venue is missing!</h3>");
        }
    }
}
