package com.gxl;

import com.ssh.baseaction.BaseAction;

public class TestAction extends BaseAction {

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
	public String execute() throws Exception {
		this.getApplicationContext().setAttribute("rootPath", "iss");
		return SUCCESS;
	}

}
