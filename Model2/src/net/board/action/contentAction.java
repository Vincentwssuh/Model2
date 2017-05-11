package net.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.board.db.BoardBean;
import net.board.db.BoardDAO;


public class contentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("contentAction execute()");
		request.setCharacterEncoding("UTF-8");
//-----------------------------------------------
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO bdao = new BoardDAO();
		bdao.updateReadcount(num);
		BoardBean bb = bdao.getBoard(num);
		
		request.setAttribute("bb", bb);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);

//-----------------------------------------------
		ActionForward forward = new ActionForward();
		forward.setPath("./contentAction.bo");
		forward.setRedirect(false);

		return forward;
	}	
}
