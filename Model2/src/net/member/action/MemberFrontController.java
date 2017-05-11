package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {
	// @Override - 상속 받아 부모의 메서드를재정의
	// alt shif s v

	// 가상주소
	// http://localhost:8080/Model2/MemberJoin.me

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess() 메서드 호출");
		// 주소 뽑아오기
		// http://localhost:8080 /Model2 /*.me
		// /Model2 /*.me
		// /Model2
		// /*.me <= 최종 뽑을 목표.

		String requestURI = request.getRequestURI();
		System.out.println("URL 요청 : " + requestURI); // >>/Model2/*.me

		String contextPath = request.getContextPath();
		System.out.println(contextPath); // >>/Model2
		System.out.println("프로젝트 이름 길이 : " + contextPath.length()); // >>7

		String command = requestURI.substring(contextPath.length()); // /Model2
																		// 글자
																		// 다음부터를
																		// 의미.
		System.out.println("뽑아온 가상 주소 : " + command); // >>/*.me

		// 뽑아온 가상주소 /MemberJoin.me 비교해서 같으면
		// /member/insertForm.jsp 이동

		// ActionForward 객체 선언
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/MemberJoin.me")) {
			// 이동방식 가상주소현재 위치.

			// 방식1. response 이동
			// response.sendRedirect("./member/join.jsp");
			// >>http://localhost:8080/Model2/member/join.jsp으로 이동.

			// 방식2. forward 이동 A 정보를 가지고 => B 이동, 주소줄 A페이지보임. 실행화면은 B페이지
			// 주소줄 : http://localhost:8080/Model2/MemberJoin.me
			// 실제화면 : http://localhost:8080/Model2/join.jsp
			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher("./member/join.jsp");
			// dispatcher.forward(request, response);

			// 이동 정보 저장(이동할 페이지 주소, 이동할 방식)
			// 이동정보 저장하는 파일 만들기
			// 패키지 net.member.action 파일 ActionForward
			// path 멤버변수 이동할 페이지 주소
			// isRedirect 멤버변수 이동할 방식

			// ActionForward 객체 생성 기억장소 할당
			forward = new ActionForward();
			// path 이동할 페이지주소 값 저장
			forward.setPath("./member/join.jsp");
			// isRedirect 이동할 방식 저장 forward
			forward.setRedirect(false);

		} else if (command.equals("/MemberJoinAction.me")) {
			// 회원가입 처리 작업 자바파일 객체 생성 메서드 호출()
			// 처리작업할 파일의 틀을 제시 interface 만들고
			// 그 틀에 맞추어서 처리파일 만들기
			// interface 패키지
			// 패키지 net.member.action 파일 Action <= class가 아니라 interface

			// 패키지 net.member.action 파일 MemberJoinAction
			// MemberJoinAction 객체 생성
			action = new MemberJoinAction();

			try {
				// execute 메서드 호출
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MemberLogin.me")) {
			// 이동 ./member/loginForm.jsp
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/MemberLoginAction.me")) {
			// 패키지 net.member.action 파일이름 MemberLoginAction
			// Action 인터페이스 상속 execute() 메서드오버라이딩

			// MemberLoginAction 객체 생성
			// forward = execute 메서드 호출

			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Main.me")) {
			forward = new ActionForward();
			forward.setPath("./member/main.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/MemberLogout.me")) {
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//info
		} else if (command.equals("/MemberInfo.me")) {
			action = new MemberInfo();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Info.me")){
			forward = new ActionForward();
			forward.setPath("./member/info.jsp");
			forward.setRedirect(false);
			
			
			//update
		} else if (command.equals("/MemberUpdate.me")){
			action = new MemberUpdate();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MemberUpdateForm.me")){
			forward = new ActionForward();
			forward.setPath("./member/updateForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/MemberUpdateAction.me")){
			action = new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//delete
		} else if(command.equals("/MemberDelete.me")){
			forward = new ActionForward();
			forward.setPath("./member/deleteForm.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberDeleteAction.me")){
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//list
		} else if (command.equals("/MemberList.me")){
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MemberListAction.me")){
			forward = new ActionForward();
			forward.setPath("./member/list.jsp");
			forward.setRedirect(false);
		}

		// 이동
		if (forward != null) { // 이동할 정보가 있으면
			if (forward.isRedirect()) {
				// 페이지를 보여줘도 상관없다. true

				// sendRedirect는 이동만 하기 때문에 담아가는 정보가 없다.
				// 모든 페이지를 false로 했을 때, 값을 계속 받아가기 때문에, join id와 login id가 겹치는 등
				// 오류가 난다.
				// 이에 따라서 현재 forward를 통해서 받아오고 있는 값을 소실시키고 싶을 때도 사용한다.

				response.sendRedirect(forward.getPath());
			} else {
				// false.
				// forward는 f니까 항상 false로 하자.
				// 제 3의 페이지로 갈때도 request 정보를 가지고 간다.
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}// doProcess()

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() 메서드 호출");
		// doProcess() 메서드 호출
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() 메서드 호출");
		// doProcess() 메서드 호출
		doProcess(request, response);
	}
}
