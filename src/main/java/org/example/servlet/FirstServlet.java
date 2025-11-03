package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Servlet - Interface <- Servlet의 생명주기를 적어놓은 인터페이스
// HttpServlet - Abstract Class <- HTTP 요청에 대해서 어느정도 대응이 되어 있는 추상 클래스
@WebServlet // @WebServlet("/")
public class FirstServlet extends HttpServlet {
    // 3가지 생명주기

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
