package org.web.bordcommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;
import org.web.borddto.BordDto;


public class BordreplyView implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int mId = Integer.parseInt(request.getParameter("mId"));
		
		BordDao dao = BordDao.getInstance();
		BordDto list = dao.replyView(mId);
		
		request.setAttribute("list", list);
		request.setAttribute("url", "/replyView.jsp");
		
	
		
		
		
	}

}
