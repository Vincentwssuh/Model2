package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;

		System.out.println("MemberDeleteAction execute()");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pass = (String)request.getParameter("pass");
		
		MemberDAO mdao = new MemberDAO();
		int check = mdao.deleteMember(id,pass);


		if (check == 1) {
			// 삭제 성공
						
			//세션값 생성
			
			session.invalidate();
			
			forward = new ActionForward();
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;

		} else if (check == 0) {
			// 비밀번호 오류. 뒤로 이동.

			// 서버에 내용 타입을 지정해서 보내준다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호 오류');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		} else {
			// check == -1 아이디없음.

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 없음');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		}
		
	}
}
