package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;


public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateAction execute()");

		// 세션가져오기
		// 없으면 ./MemberLogin.me ActionForward 이용 이동

		request.setCharacterEncoding("UTF-8");

		String pageNum = (String)request.getParameter("pageNum");
		
		ActionForward forward = new ActionForward();
		if(pageNum==null){
			forward.setPath("./BoardList.me");
			forward.setRedirect(true);
			return forward;
		}

		// MemberDAO mdao 객체 생성
		// 메서드 호출()

		BoardDAO bdao = new BoardDAO();
		BoardBean bb = new BoardBean();
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		
		
		int check = bdao.updateBoard(bb);
		
		if (check == 1) {
			// 수정 성공
			
			forward = new ActionForward();
			forward.setPath("./BoardList.bo");
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