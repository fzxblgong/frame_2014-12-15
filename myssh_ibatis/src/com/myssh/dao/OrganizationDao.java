package com.myssh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myssh.model.Organization;
import com.ssh.basedao.BaseDao;

@Repository
public class OrganizationDao extends BaseDao<Organization,Integer> {
	/**
	 * hql²éÑ¯Êý¾Ý
	 * @return
	 */
	public List<Organization> getOrgTree(){
		String hql = "from Organization";
		Object[] objects  = null;
		List<Organization> orgList = this.getListByHQL(hql,objects);
		return orgList;
	}
}
