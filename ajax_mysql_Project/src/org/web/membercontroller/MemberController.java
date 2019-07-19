package org.web.membercontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.membercommend.MemberCommend;
import org.web.membercommend.ajaxJoinMo;
import org.web.membercommend.ajaxMemberDeleteMo;
import org.web.membercommend.ajaxMemberListMo;
import org.web.membercommend.ajaxMemberUpdateMo;
import org.web.membercommend.ajaxMemberViewMo;
import org.web.membercommend.ajaxSearchMo;
import org.web.membercommend.ajaxidCheckedMo;
import org.web.membercommend.ajaxloginMo;
import org.web.membercommend.logOutOkMo;


@WebServlet("*.mo")

public class MemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAction(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAction(request,response);
	}
private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	response.setContentType("text/html;charset=UTF-8");
	
	String uri = request.getRequestURI();
	String path = request.getContextPath();
	String basicURL = uri.substring(path.length());
	String url = "";
	
	MemberCommend action = null;
	
	if(basicURL.equals("/ajaxidChecked.mo"))
	{
		action = new ajaxidCheckedMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxJoin.mo"))
	{
		action = new ajaxJoinMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxlogin.mo"))
	{
		action = new ajaxloginMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/logOutOk.mo"))
	{
		action = new logOutOkMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxMemberView.mo"))
	{
		action = new ajaxMemberViewMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxMemberUpdate.mo"))
	{
		action = new ajaxMemberUpdateMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxMemberDelete.mo"))
	{
		action = new ajaxMemberDeleteMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	if(basicURL.equals("/ajaxMemberList.mo"))
	{
		action = new ajaxMemberListMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	
	if(basicURL.equals("/ajaxSearch.mo"))
	{
		action = new ajaxSearchMo();
		action.excuteCommend(request, response);
		//url=(String)request.getAttribute("url");
		return;
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
}


}
