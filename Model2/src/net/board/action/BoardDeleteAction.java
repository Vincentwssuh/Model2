package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDeleteAction execute()");
		request.setCharacterEncoding("UTF-8");
//-----------------------------------------------
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		
		System.out.println("num : "+num);
		System.out.println("pass : "+pass);
		
		BoardDAO bdao = new BoardDAO();
		bdao.deleteBoard(num, pass);
		
		
//-----------------------------------------------
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);

		return forward;
	}	
}