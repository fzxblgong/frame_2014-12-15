package com.gxl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ssh.baseaction.BaseAction;
@Component
@Scope("prototype")
public class FileUploadPerAction extends BaseAction {

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	@Override
	public String execute(){
		return null;
	}
	public void getPer() throws IOException{
		String perSessionKey = this.getHttpServletRequest().getParameter("perSessionKey");
		this.setAjax(this.getHttpServletRequest().getSession().getAttribute(perSessionKey).toString());
	}
}
