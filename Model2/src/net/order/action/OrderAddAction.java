package net.order.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;
import net.goods.db.GoodsDAO;
import net.order.db.OrderBean;
import net.order.db.OrderDAO;

public class OrderAddAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션값 가져오기
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//세션값 없으면 ./MemberLogin.me
		ActionForward forward=new ActionForward();
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		//자바빈 OrderBean 객체 생성 orderbean
		OrderBean orderbean=new OrderBean();
		//한글처리
		request.setCharacterEncoding("utf-8");
		// 폼 => 자바빈 저장
		// o_m_id, o_receive_name   o_receive_addr1
//		  o_receive_addr2   o_receive_phone
//		  o_receive_mobile   o_memo		  o_trade_payer
		orderbean.setO_m_id(id);
		orderbean.setO_memo(request.getParameter("o_memo"));
		orderbean.setO_trade_payer(request.getParameter("o_trade_payer"));
		orderbean.setO_receive_addr1(request.getParameter("o_receive_addr1"));
		orderbean.setO_receive_addr2(request.getParameter("o_receive_addr2"));
		orderbean.setO_receive_mobile(request.getParameter("o_receive_mobile"));
		orderbean.setO_receive_name(request.getParameter("o_receive_name"));
		orderbean.setO_receive_phone(request.getParameter("o_receive_phone"));
		orderbean.setO_trade_type("온라인입금");
		//장바구니 디비작업 객체 생성 basketdao
		BasketDAO basketdao=new BasketDAO();
		//Vector vector = 메서드호출 getBasketList(id)
		Vector vector=basketdao.getBasketList(id);
		//List basketList=vector.get(0)
		List basketList=(List)vector.get(0);
		//List goodsList=vector.get(1)
		List goodsList=(List)vector.get(1);
		
		//결제 연결  U+전자결제 유플러스결제 http://ecredit.uplus.co.kr/
		
		// net.order.db OrderDAO 객체생성 orderdao
		OrderDAO orderdao=new OrderDAO();
		//메서드 호출  => 주문정보저장
		// 메서드호출 addOrder(orderbean,basketList,goodsList)
		orderdao.addOrder(orderbean,basketList,goodsList);
		
		//메일,문자 전송
		
		//상품전체개수 수정goodsdao    updateAmount(basketList)
		GoodsDAO goodsdao=new GoodsDAO();
		//goodsdao.updateAmount(basketList);
		
		//장바구니 정보 삭제 basketdao//  deleteBasket(id)
		basketdao.deleteBasket(id);
		
		//이동 ./OrderList.or
		forward.setRedirect(true);
		forward.setPath("./OrderList.or");
		return forward;
	}
}
