package net.order.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;


public class OrderStarAction implements Action{
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
		//장바구니 디비작업 객체 생성 basketdao
		BasketDAO basketdao=new BasketDAO();
		//Vector vector = 메서드호출 getBasketList(id)
		Vector vector=basketdao.getBasketList(id);
		//List basketList=vector.get(0)
		List basketList=(List)vector.get(0);
		//List goodsList=vector.get(1)
		List goodsList=(List)vector.get(1);
		//멤버 디비작업 객체 생성 memberdao
		MemberDAO memberdao=new MemberDAO();
		//MemberBean memberbean =메서드 호출 getMember(id)
		MemberBean memberbean=memberdao.getMember(id);
		//저장 basketList  goodsList memberbean
		request.setAttribute("basketList", basketList);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("memberbean", memberbean);
		//이동 ./goods_order/goods_buy.jsp
		forward.setRedirect(false);
		forward.setPath("./goods_order/goods_buy.jsp");
		return forward;
	}
}


