package com.ssh.baseaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 通用基础Action
 * @author Administrator
 *
 */
public abstract class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletRequestAware,ServletResponseAware,ModelDriven,Preparable{
	//map类型web元素
	private Map<String,Object> requestMap;
	private Map<String,Object> sessionMap;
	private Map<String,Object> applicationMap;
	//真实web元素
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private HttpSession httpSession;
	private ServletContext applicationContext;
	//主动获取测试方法
	public void test(){
		requestMap = (Map) ActionContext.getContext().get("request");
		sessionMap = (Map) ActionContext.getContext().getSession();
		applicationMap = (Map) ActionContext.getContext().getApplication();
		 
		httpServletRequest = ServletActionContext.getRequest();
		httpSession = httpServletRequest.getSession();
		applicationContext = httpSession.getServletContext();
	}
	
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
	public void setApplication(Map<String, Object> application) {
		this.applicationMap = application;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
		this.httpSession = this.httpServletRequest.getSession();
		this.applicationContext = this.httpSession.getServletContext();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public Map<String, Object> getApplicationMap() {
		return applicationMap;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public ServletContext getApplicationContext() {
		return applicationContext;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}
	public void setAjax(String content) throws IOException{
		HttpServletResponse response = this.getHttpServletResponse();
		String fullContentType = "text/html;charset=UTF-8";
		response.setContentType(fullContentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		PrintWriter out = response.getWriter();
		out.print(content);
		out.flush();
		out.close();
	}
}
