package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateAction execute()");

		// 세션가져오기
		// 없으면 ./MemberLogin.me ActionForward 이용 이동

		request.setCharacterEncoding("UTF-8");

		//java에서 세션값 불러오기.
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id==null){
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}

		// MemberDAO mdao 객체 생성
		// 메서드 호출()

		MemberDAO mdao = new MemberDAO();
		MemberBean mb = new MemberBean();
		mb.setId(request.getParameter("id"));
		mb.setPass(request.getParameter("pass"));
		mb.setName(request.getParameter("name"));
		mb.setEmail(request.getParameter("email"));
		mb.setGender(request.getParameter("gender"));
		mb.setAge(Integer.parseInt(request.getParameter("age")));
		
		int check = mdao.updateMember(mb);
		
		if (check == 1) {
			// 수정 성공
			
			forward = new ActionForward();
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;

		} else if (check == 0) {
			// 비밀번호 공란.. 뒤로 이동.

			// 서버에 내용 타입을 지정해서 보내준다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호 미입력');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		} else {
			// check == -1 비밀번호 틀림.

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		}
	}
}
