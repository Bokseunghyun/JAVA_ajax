package org.web.bordcommend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;
import org.web.borddto.BordDto;

public class Bordreply implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String mId = request.getParameter("mId");
		String nickName = request.getParameter("nickName");
		String userId = request.getParameter("userId");
		String mPw = request.getParameter("mPw");
		String title = request.getParameter("title");
		String memo = request.getParameter("memo");
		String mGroup = request.getParameter("mGroup");
		String step = request.getParameter("step");
		String mIndent = request.getParameter("mIndent");
		
		BordDao dao = BordDao.getInstance();
		dao.reply(mId, nickName, userId, mPw, title, memo, mGroup, step, mIndent);
	
		ArrayList<BordDto> lists = dao.BordList();
		
		request.setAttribute("lists", lists);
		request.setAttribute("url", "/BordList.jsp");

	}

}
