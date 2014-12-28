package com.myssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organization {
	private Integer id;
	
	@Column
	private Integer p_id;
	@Column
	private String name;
	@Column
	private String desc;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
