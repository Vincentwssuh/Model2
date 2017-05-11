package net.admin.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.order.db.AdminOrderDAO;

public class AdminOrderDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// trade_num 가져오기
		String trade_num=request.getParameter("trade_num");
		// 객체 생성 AdminOrderDAO aodao객체 생성
		AdminOrderDAO aodao=new AdminOrderDAO();
		// List adminOrderDetail 
		//   =메서드호출 getAdminOrderDetail(trade_num)
		List adminOrderDetail=aodao.getAdminOrderDetail(trade_num);
		//저장 adminOrderDetail 
		request.setAttribute("adminOrderDetail", adminOrderDetail);
		//이동 ./adminorder/admin_order_modify.jsp
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./adminorder/admin_order_modify.jsp");
		return forward;
	}
}
