package sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/setCookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		// Cookie 객체 생성한 후 cookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("Cookie 테스트2입니다", "utf-8"));
		// Cookie cookie = new Cookie("cookieTest", "Cookie 테스트2입니다"); //인코딩 안 하면 오류
		//cookie.setMaxAge(24 * 60 * 60); // 유효기간 설정 : Persistence 쿠키 : 유효 기간 내에 브라우저 종료해도 쿠키 값 유효
		cookie.setMaxAge(-1); // Session 쿠키로 설정 (음수값) : 브라우저 종료되면 쿠키 만료
		response.addCookie(cookie); // 생성한 쿠키를 브라우저로 전송해서 저장
		out.println("현재 시간 : " + d);
		out.println("<br> Cookie에 저장");		
	}

}














