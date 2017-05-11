package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet {
	// @Override - 상속 받아 부모의 메서드를재정의
	// alt shif s v

	// 가상주소
	// http://localhost:8080/Model2/BoardList.bo

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doProcess() 메서드 호출");
		// 주소 뽑아오기
		// http://localhost:8080 /Model2 /*.bo
		// /Model2 /*.bo
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

			
			
			//list
		if (command.equals("/BoardList.bo")){
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
			//content
		else if (command.equals("/content.bo")){
			action = new contentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/contentAction.bo")){
			forward = new ActionForward();
			forward.setPath("./board/content.jsp");
			forward.setRedirect(false);
		}
		
		
			//wrtie
		else if (command.equals("/BoardWrite.bo")){
			//	./board/writeForm.jsp
			forward = new ActionForward();
			forward.setPath("./board/writeForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/BoardWriteAction.bo")){
			action = new BoardWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
			//delete
		else if (command.equals("/BoardDelete.bo")){
			forward = new ActionForward();
			forward.setPath("./board/delete.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/BoardDeleteAction.bo")){
			action = new BoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
			//update
		else if (command.equals("/BoardUpdate.bo")){
			action = new BoardUpdate();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/BoardUpdateForm.bo")){
			forward = new ActionForward();
			forward.setPath("./board/updateForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/BoardUpdateAction.bo")){
			action = new BoardUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
			//reWrite
		else if (command.equals("/BoardreWriteForm.bo")){
			forward = new ActionForward();
			forward.setPath("./board/reWriteForm.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/BoardreWriteAction.bo")){
			action = new BoardreWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
