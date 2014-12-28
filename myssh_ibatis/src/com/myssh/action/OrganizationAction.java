package com.myssh.action;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myssh.model.Organization;
import com.myssh.service.OrganizationService;
import com.ssh.baseaction.BaseAction;
import com.util.BeanToMapUtil;
@Component
public class OrganizationAction extends BaseAction{
	@Autowired
	private OrganizationService organizationService;
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	public String toOrganizationTree(){
		return "to_organization_tree";
	}
	public void getTreeDataList() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException{
		List<Organization> organizationList = this.organizationService.getOrgTree();
		List<Map> orgMapList = new ArrayList<Map>();
		for(Organization org : organizationList){
			Map orgMap = BeanToMapUtil.convertBean(org);
			orgMapList.add(orgMap);
			System.out.println(orgMap);
		}
		String json = com.util.JSON.Encode(organizationList);
		System.out.println(json);
		this.setAjax(json);
	}
}
