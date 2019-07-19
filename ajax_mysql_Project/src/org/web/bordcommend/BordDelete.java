package org.web.bordcommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.borddao.BordDao;

public class BordDelete implements BordCommend{

	@Override
	public void excuteCommend(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String mId = request.getParameter("mId");
		String userId2 = request.getParameter("userId");
		String mPw2 = request.getParameter("mPw");
		BordDao dao = BordDao.getInstance();
		
		int rs = dao.BordDelete(mId, userId2, mPw2);
		PrintWriter out = response.getWriter();
		out.write(rs+"");
		out.flush();
		System.out.println(mId+"        "+userId2+"         "+mPw2);
	}

}
