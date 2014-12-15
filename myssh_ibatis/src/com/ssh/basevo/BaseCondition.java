package com.ssh.basevo;



public abstract class BaseCondition {
 
    /**
     * 查询对象结果类型
     */
    private Class<? extends BaseBean> basebean;
    /**
     * 分页对象
     */
    private PageBean pageBean = new PageBean(0l,null,null);//初始化无对象记录
    
    
    
    public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public Class<? extends BaseBean> getBasebean() {
        return basebean;
    }
 
    public void setBasebean(Class<? extends BaseBean> baseBean) {
        this.basebean = baseBean;
    }
    
}