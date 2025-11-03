package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/first")
public class JSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 현재 경로를 유지한채로 파일만 jsp를 불러오게 할 수 있음
        // req <- 뭔가 작업을 해줌...
        // first라고 하는 '경로'로 들어올 땐 해당 작업 반영
        // first.jsp <- 파일로 들어오면 해당 작업 무시.
        // 직접 접근을 허용하는 것이 보안적으로 좋지 X <- jsp 보안적으로 처리하려고 하면 필연적으로 코드가 더러워짐.
        // webapp -> jsp
        req.setAttribute("name", "김자바"); // 값 설정을 가정
        req.getRequestDispatcher("/first.jsp").forward(req, resp);
    }
}
