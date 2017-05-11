package net.admin.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가상주소 가져오기
		//  http://localhost:8080/Model2/AdminOrderList.ao
		//  /Model2/AdminOrderList.ao
		String requestURI=request.getRequestURI();
		//  /Model2
		String contextPath=request.getContextPath();
		//  /AdminOrderList.ao
		String command=requestURI.substring(contextPath.length());
		//주소비교
		Action action=null;
		ActionForward forward=null;
		if(command.equals("/AdminOrderList.ao")){
			//  AdminOrderListAction
			action=new AdminOrderListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AdminOrderDetail.ao")){
			//  AdminOrderDetailAction
			action=new AdminOrderDetailAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AdminOrderModify.ao")){
			//  AdminOrderModifyAction
			action=new AdminOrderModifyAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//이동
		if(forward!=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
