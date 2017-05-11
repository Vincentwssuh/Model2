package net.basket.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;

public class BasketListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션 가져오기
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		//세션값 없으면  ./MemberLogin.me
		ActionForward forward=new ActionForward();
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		//BasketDAO 객체 생성 basketdao
		BasketDAO basketdao=new BasketDAO();
		//Vector vector= 메서드호출  getBasketList(String id)
		//  => Vector vector=new Vector();
		Vector vector=basketdao.getBasketList(id);
		//List basketList = vector 첫번째데이터
		List basketList=(List)vector.get(0);
		//List goodsList = vector 두번째데이터
		List goodsList=(List)vector.get(1);
		// 저장 basketList goodsList
		request.setAttribute("basketList", basketList);
		request.setAttribute("goodsList", goodsList);
		//이동   ./goods_order/goods_basket.jsp
		forward.setRedirect(false);
		forward.setPath("./goods_order/goods_basket.jsp");
		return forward;
	}
}
