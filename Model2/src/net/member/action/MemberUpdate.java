package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdate execute()");

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
		MemberBean mb = mdao.getMember(id);

		//데이터저장 mb
		request.setAttribute("mb", mb);
		
		// ActionForward 이동정보를 담아서 로그인 이동
		forward = new ActionForward();
		forward.setPath("./MemberUpdateForm.me");
		forward.setRedirect(false);

		return forward;
	}
}
