package net.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class OrderFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가상주소 가져오기
		//  http://localhost:8080/Model2/OrderStar.or
		//  /Model2/OrderStar.or
		String requestURI=request.getRequestURI();
		//  /Model2
		String contextPath=request.getContextPath();
		//  /OrderStar.or
		String command=requestURI.substring(contextPath.length());
		//비교하기
		Action action=null;
		ActionForward forward=null;
		if(command.equals("/OrderStar.or")){
			// OrderStarAction
			action=new OrderStarAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OrderAdd.or")){
			// OrderAddAction 
			action=new OrderAddAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OrderList.or")){
			// OrderListAction
			action=new OrderListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/OrderDetail.or")){
			//  OrderDetailAction
			action=new OrderDetailAction();
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
