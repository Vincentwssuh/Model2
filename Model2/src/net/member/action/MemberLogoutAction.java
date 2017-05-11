package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;

		System.out.println("MemberLogoutAction execute()");
		request.setCharacterEncoding("UTF-8");

		// 세션값 삭제
		HttpSession session = request.getSession();
		session.invalidate();

		// 서버에 내용 타입을 지정해서 보내준다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Logout');");
		out.println("location.href='./Main.me'");
		out.println("</script>");
		out.close();

		return null;
	}
}