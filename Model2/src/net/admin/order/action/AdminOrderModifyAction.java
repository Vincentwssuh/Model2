package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.order.db.OrderBean;

public class AdminOrderModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션제어
		HttpSession session = request.getSession();
		//자바빈 객체 생성 OrderBean orderbean
		OrderBean orderbean = new OrderBean();
		// trade_num  status   trans_num
		orderbean.setO_trade_num(request.getParameter("trade_num"));
		orderbean.setO_status(Integer.parseInt(request.getParameter("status")));
		orderbean.setO_trans_num(request.getParameter("trans_num"));
		
		//폼 => 자바빈 멤버변수 저장
		//디비객체 생성 AdminOrderDAO aodao
		AdminOrderDAO aodao=new AdminOrderDAO();
		//메서드호출 updateOrder(orderbean)
		aodao.updateOrder(orderbean);
		//이동 ./AdminOrderList.ao
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./AdminOrderList.ao");
		return forward;
	}
}
