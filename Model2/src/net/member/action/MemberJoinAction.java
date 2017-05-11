package net.member.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberJoinAction execute()");
		//회원가입 처리작업
		//	request 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//	자바빈 패키지 net.member.db	파일MemberBean
		//	MemberBean 객체 생성 mb
		//	request 파라미터 정보 가져오기 => 자바빈 저장
		MemberBean mb = new MemberBean();
		mb.setId(request.getParameter("id"));
		mb.setPass(request.getParameter("pass"));
		mb.setName(request.getParameter("name"));
		mb.setEmail(request.getParameter("email"));
		mb.setGender(request.getParameter("gender"));
		mb.setAge(Integer.parseInt(request.getParameter("age")));
		mb.setReg_data(new Timestamp(System.currentTimeMillis()));
		
		//	db연동 lib 		Context.xml		web.xml	설정
		//	db패키지 net.member.db 파일 MemberDAO
		//	메서드 호출 insertMember(mb)
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);
		
		
		//	ActionForward 이동정보를 담아서 로그인 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberLogin.me");
		forward.setRedirect(true);//가상 페이지로 넘어갈때는 true
		
		return forward;
	}	
}