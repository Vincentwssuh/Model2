package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("contentAction execute()");
		request.setCharacterEncoding("UTF-8");
//-----------------------------------------------
		
		BoardDAO bdao = new BoardDAO();
		BoardBean bb = new BoardBean();
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setIp(request.getRemoteAddr());
		bdao.insertBoard(bb);
		
		
//-----------------------------------------------
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(false);

		return forward;
	}	
}