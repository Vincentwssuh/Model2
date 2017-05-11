package net.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.order.db.OrderDAO;

public class OrderListAction implements Action{
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
		//OrderDAO orderdao 객체 생성
		OrderDAO orderdao=new OrderDAO();
		//List orderList=메서드호출 getOrderList(id)
		List orderList=orderdao.getOrderList(id);
		//저장 orderList
		request.setAttribute("orderList", orderList);
		//이동 ./goods_order/order_list.jsp
		forward.setRedirect(false);
		forward.setPath("./goods_order/order_list.jsp");
		return forward;
	}
}
