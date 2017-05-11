package net.member.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("MemberListAction execute()");

		request.setCharacterEncoding("UTF-8");

		MemberDAO mdao = new MemberDAO();
		List memberList = mdao.getMemberList();
		
		request.setAttribute("memberList", memberList);

		
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberListAction.me");
		forward.setRedirect(false);
		
		return forward;
	}	
}
