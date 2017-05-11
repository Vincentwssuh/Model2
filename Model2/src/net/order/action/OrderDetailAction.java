package net.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.order.db.OrderDAO;

public class OrderDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션 가져오기
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//세션 없으면 ./MemberLogin.me
		ActionForward forward=new ActionForward();
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		// trade_num 주문번호 파라미터 가져오기
		String trade_num=request.getParameter("trade_num");
		// OrderDAO orderdao 객체 생성
		OrderDAO orderdao=new OrderDAO();
// List orderDetailList  = 메서드호출 orderDetail(trade_num)
		List orderDetailList=orderdao.orderDetail(trade_num);
		// 저장 orderDetailList
		request.setAttribute("orderDetailList", orderDetailList);
		// 이동  ./goods_order/order_detail.jsp 
		forward.setRedirect(false);
		forward.setPath("./goods_order/order_detail.jsp");
		return forward;
	}
}
