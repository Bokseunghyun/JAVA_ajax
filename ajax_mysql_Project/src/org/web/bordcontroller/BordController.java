package org.web.bordcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.bordcommend.BordCommend;
import org.web.bordcommend.BordDelete;
import org.web.bordcommend.BordList;
import org.web.bordcommend.BordMbord;
import org.web.bordcommend.BordUpdateOk;
import org.web.bordcommend.BordView;
import org.web.bordcommend.BordWrite;
import org.web.bordcommend.Bordreply;
import org.web.bordcommend.BordreplyView;

@WebServlet ("*.bo")
public class BordController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAction(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAction(request,response);
	}
	
private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	String uri = request.getRequestURI();
	String path = request.getContextPath();
	String basicURL = uri.substring(path.length());
	String url = "";
	
	BordCommend action = null;
	if(basicURL.equals("/BordWrite.bo"))
	{
		action = new BordWrite();
		action.excuteCommend(request, response);
		return;
	}
	
	else if(basicURL.equals("/BordList.bo"))
	{
		action = new BordList();
		action.excuteCommend(request, response);
		return;
	}
	else if(basicURL.equals("/BordView.bo"))
	{
		action = new BordView();
		action.excuteCommend(request, response);
		return;
	}
	else if(basicURL.equals("/BordUpdateOk.bo"))
	{
		action = new BordUpdateOk();
		action.excuteCommend(request, response);
		return;
	}
	else if(basicURL.equals("/BordDeleteOk.bo"))
	{
		action = new BordDelete();
		action.excuteCommend(request, response);
		return;
	}
	else if(basicURL.equals("/ajaxMbordList.bo"))
	{
		action = new BordMbord();
		action.excuteCommend(request, response);
		return;
	}
	else if(basicURL.equals("/replyView.bo"))
	{
		action = new BordreplyView();
		action.excuteCommend(request, response);
		url=(String)request.getAttribute("url");
	}
	else if(basicURL.equals("/Bordreply.bo"))
	{
		action = new Bordreply();
		action.excuteCommend(request, response);
		url=(String)request.getAttribute("url");
	}

	
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
}

}
