package com.myssh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myssh.dao.OrganizationDao;
import com.myssh.model.Organization;

@Service
@Transactional
public class OrganizationService {
	@Autowired
	private OrganizationDao organizationDao;
	/**
	 * hql²éÑ¯Êý¾Ý
	 * @return
	 */
	public List<Organization> getOrgTree(){
		return this.organizationDao.getOrgTree();
	}
}
