package net.basket.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasketFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가상주소 가져오기
		//  http://localhost:8080/Model2/BasketAdd.ba
		//  /Model2/BasketAdd.ba
		String requestURI=request.getRequestURI();
		//  /Model2
		String contextPath=request.getContextPath();
		//  /BasketAdd.ba
		String command=requestURI.substring(contextPath.length());
		//주소비교하기
		Action action=null;
		ActionForward forward=null;
		if(command.equals("/BasketAdd.ba")){
			//  BasketAddAction
			action=new BasketAddAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BasketList.ba")){
			//  BasketListAction
			action=new BasketListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BasketDelete.ba")){
			//  BasketDeleteAction
			action=new BasketDeleteAction();
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
