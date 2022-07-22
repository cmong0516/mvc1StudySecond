package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebServlet 서블릿 어노테이션.
// name = 서블릿 이름
// urlPatterns = 서블릿 url 매핑
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username);

        //http://localhost:8080/hello?username=mong 입력시

//        HelloServlet.service
//        req = org.apache.catalina.connector.RequestFacade@240fa8ca
//        resp = org.apache.catalina.connector.ResponseFacade@5149d59e
//        username = mong

        // 브라우저 -> hello mong 출력.

        // application.properties 에 logging.level.org.apache.coyote.http11=debug 입력시 http11 로 받은 정보를 아래처럼 출력.

//        2022-07-22 23:08:07.385 DEBUG 17902 --- [nio-8080-exec-1] o.a.coyote.http11.Http11InputBuffer      : Before fill(): parsingHeader: [true], parsingRequestLine: [true], parsingRequestLinePhase: [0], parsingRequestLineStart: [0], byteBuffer.position(): [0], byteBuffer.limit(): [0], end: [0]
//        2022-07-22 23:08:07.385 DEBUG 17902 --- [nio-8080-exec-1] o.a.coyote.http11.Http11InputBuffer      : Received [GET /hello?username=mong HTTP/1.1
//        Host: localhost:8080
//        Connection: keep-alive
//        Cache-Control: max-age=0
//        sec-ch-ua: ".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"
//        sec-ch-ua-mobile: ?0
//        sec-ch-ua-platform: "macOS"
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//        Sec-Fetch-Site: none
//        Sec-Fetch-Mode: navigate
//        Sec-Fetch-User: ?1
//        Sec-Fetch-Dest: document
//        Accept-Encoding: gzip, deflate, br
//        Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//        Cookie: Idea-50b03fab=7576bfd1-f2a2-4a30-ab92-3bfe2df1a771


        //  운영서버에 이렇게 모든 요청 정보를 다 남기면 성능저하가 발생할 수 있다. 개발 단계에서만 적용하자.
    }
}
