package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;

public class BasketAddAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션값 가져오기
		//세션값 없으면  ./MemberLogin.me
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		ActionForward forward=new ActionForward();
		if(id==null){
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//자바빈 파일 만들기 net.basket.db  BasketBean
		//객체생성 BasketBean basketbean 
		BasketBean basketbean =new BasketBean();
		
		//폼 => 자바빈 저장  num  amount size color  id
		basketbean.setB_g_num(Integer.parseInt(request.getParameter("num")));
		basketbean.setB_g_amount(Integer.parseInt(request.getParameter("amount")));
		basketbean.setB_g_color(request.getParameter("color"));
		basketbean.setB_g_size(request.getParameter("size"));
		basketbean.setB_m_id(id);
		
		//디비 파일 만들기 net.basket.db BasketDAO
		//객체 생성 basketdao
		BasketDAO basketdao=new BasketDAO();
		
		//int check=상품 중복체크 중복이면 수량 update <= 1
		//      checkGoods(BasketBean basketbean)
		int check=basketdao.checkGoods(basketbean);
		if(check!=1){
		
			//메서드호출 basketAdd(basketbean)
		basketdao.basketAdd(basketbean);
		}
		
		//이동 ./BasketList.ba
		forward.setRedirect(true);
		forward.setPath("./BasketList.ba");
		return forward;
	}
}



