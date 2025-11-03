package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Servlet - Interface <- Servlet의 생명주기를 적어놓은 인터페이스
// HttpServlet - Abstract Class <- HTTP 요청에 대해서 어느정도 대응이 되어 있는 추상 클래스
@WebServlet("/") // 경로 매핑을 '꼭' 해야함 (<-> Spring Web의 Request Mapping 과는 다르다...)
public class FirstServlet extends HttpServlet {
    // 3가지 생명주기

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("First Servlet이 생성됨");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("First Servlet이 실행 시작");
        System.out.println(req.getMethod());
        super.service(req, resp); // -> GET으로 넘김
        System.out.println("First Servlet이 실행 종료");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("First Servlet이 GET 요청 처리 시작");
//        super.doGet(req, resp); // 구현이 안되어있을 경우 405를 처리하는 것
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("반가워요!");
        System.out.println("First Servlet이 GET 요청 처리 종료");
        // service로 돌아감
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("First Servlet이 소멸됨");
    }
}
