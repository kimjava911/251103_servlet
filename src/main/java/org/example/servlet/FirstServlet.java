package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
//        resp.getWriter().println("반가워요!");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>제 첫 서블릿입니다!</h1>");
        writer.println("<p>귀엽죠?</p>");
        String textParam = req.getParameter("text");
        System.out.println(textParam);
        if (textParam != null) { // 아예 입력이 안되어 있으면 Null, 빈값이 들어가 있으면 "".
            writer.println("<code>%s</code>".formatted(textParam));
        }
        // GET
        writer.println("<form method='get'>");
        writer.println("<input name='text' placeholder='아무거나 입력해보세요'>");
        writer.println("<button>GET 요청</button>");
        writer.println("</form>");
        // POST
        writer.println("<form method='post'>");
        writer.println("<button>POST 요청</button>");
        writer.println("<input name='text' placeholder='아무거나 입력해보세요'>");
        writer.println("</form>");
        System.out.println("First Servlet이 GET 요청 처리 종료");
        // service로 돌아감
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("First Servlet이 POST 요청 처리 시작");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>POST 요청을 보내셨네요</h1>");
        String textParam = req.getParameter("text");
        System.out.println(textParam);
//        writer.println("<p>왜죠?</p>");
        writer.println("<p>%s</p>".formatted(textParam == null || textParam.isBlank() ? "왜죠? (default)" : textParam));
        System.out.println("First Servlet이 POST 요청 처리 종료");
        // service로 돌아감
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("First Servlet이 소멸됨");
    }
}
