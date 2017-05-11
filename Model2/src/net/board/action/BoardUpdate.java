package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;


public class BoardUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdate execute()");

		// 세션가져오기
		// 없으면 ./MemberLogin.me ActionForward 이용 이동

		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		
		ActionForward forward = new ActionForward();
		if(pageNum==null){
			forward.setPath("./BoardList.bo");
			forward.setRedirect(true);
			return forward;
		}

		// MemberDAO mdao 객체 생성
		// 메서드 호출()

		BoardDAO bdao = new BoardDAO();
		BoardBean bb = bdao.getBoard(num);

		//데이터저장 bb
		request.setAttribute("bb", bb);
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		// ActionForward 이동정보를 담아서 로그인 이동
		forward = new ActionForward();
		forward.setPath("./BoardUpdateForm.bo");
		forward.setRedirect(false);

		return forward;
	}
}