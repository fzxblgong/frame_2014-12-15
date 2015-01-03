package com.ssh.basevo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class PageBean {
	private Long totalCount;//总记录数
	private Long pageLine;//每页查询记录数
	private Long currentPage;//当前页码
	private Long pageNum;//总页数
	private Long start;//查询起始点
	private Long end;//查询结束点
	
	private List list;//查询的结果封装集合
	private List<Long> pageNumerList;//页码集合
	public PageBean(){
	}
	/**
	 * 
	 * @param totalCount --总记录数
	 * @param pageLine --每页记录数
	 * @param currentPage --当前页码
	 */
	public PageBean(Long totalCount,Long pageLine,Long currentPage){
		this.totalCount = totalCount;
		this.pageLine = ((null == pageLine) ? 10 : pageLine);//(默认10条记录)
		this.pageNum = this.countPageNum(this.getTotalCount(),this.getPageLine());
		this.currentPage = ((null == currentPage || currentPage < 1) ? 1 : ((currentPage > this.getPageNum()) ? this.getPageNum() : currentPage));//(默认第1页),如果大于了最大页数，那么就展示末页
		this.initPageNumerList(this.getPageNum(),this.getCurrentPage());
		this.start = this.countStart(this.getCurrentPage(),this.getPageLine());
		this.end = this.countEnd(this.getCurrentPage(),this.getPageLine());
		
	}
	/**
	 * 计算分页总数
	 * @param totalCount --总记录数
	 * @param pageLine --每页记录数
	 * @return
	 */
	public Long countPageNum(Long totalCount,Long pageLine){
		long pageNum;
		if(totalCount%pageLine > 0){
			pageNum = totalCount/pageLine + 1;
		}else{
			pageNum = totalCount/pageLine;
		}
		return pageNum;
	}
	/**
	 * 以当前页为中心点，初始化前后展示的页签个数
	 * @param pageNum
	 */
	public void initPageNumerList(Long pageNum,Long currentPage){
		List<Long> pageNumerList = new ArrayList<Long>();//页码集合
		int number = 3;//默认初始化的页签个数
		int mid = number/2;//前后位差
		
		long first =  (currentPage - mid);//起始页码
		long last =  (currentPage + mid);//结束页码
		if((number % 2 == 0) && mid > 0){
			last = last - 1;
		}
		if(first < 1){
			long range = 1 - first;
			first = 1;
			last = last + range;//尾部补全
		}
		if(last > pageNum){
			long range = last - pageNum;
			last = pageNum;
			first = first - range;
			if(first < 1){
				first = 1;
			}
		}
		for(long i = first;i<=last;i++){
			pageNumerList.add(i);
		}
		this.setPageNumerList(pageNumerList);
	}
	/**
	 * baidu页码html信息
	 * @return
	 */
	public String getPageInfo(){
		String split = "\r\n";
		StringBuffer sb = new StringBuffer();
		List<Long> pageNumberList = this.getPageNumerList();
		Long pageLine = this.getPageLine();
		Long currentPage = this.getCurrentPage();
		Long pageNum = this.getPageNum();
		sb.append("<a href=user/getBaiduPageList.do?pageLine="+pageLine+"&currentPage=1>首页</a>").append(split);
		if(currentPage != 1){
			//上页
			sb.append("<a href=user/getBaiduPageList.do?pageLine="+pageLine+"&currentPage=" + (currentPage - 1) + ">上一页</a>").append(split);
		}
		for(int i = 0;i<pageNumberList.size();i++){
			Long currentPageTemp = pageNumberList.get(i);
			if(currentPageTemp != currentPage){
				sb.append("<a href=user/getBaiduPageList.do?pageLine="+pageLine+"&currentPage=" + currentPageTemp + ">"+currentPageTemp+"</a>").append(split);
			}else{
				sb.append(pageNumberList.get(i)).append(split);
			}
		}
		if(currentPage != pageNum){
			//下页
			sb.append("<a href=user/getBaiduPageList.do?pageLine="+pageLine+"&currentPage=" + (currentPage + 1) + ">下一页</a>").append(split);
		}
		sb.append("<a href=user/getBaiduPageList.do?pageLine="+pageLine+"&currentPage="+pageNum+">尾页</a>").append(split);
		return sb.toString();
	}
	/**
	 * 计算查询起始点
	 * @param currentPage --当前页码
	 * @param pageLine --每页记录数
	 * @return
	 */
	public Long countStart(Long currentPage,Long pageLine){
		//MYSQL start 0 开始
		long start = (currentPage - 1)*pageLine;
		return start;
	}
	/**
	 * 计算查询结束点
	 * @param currentPage --当前页码
	 * @param pageLine --每页记录数
	 * @return
	 */
	public Long countEnd(Long currentPage,Long pageLine){
		//非末页时的结束查询点
		long end = currentPage * pageLine;
		if(currentPage == this.getPageNum()){
			long remainder = this.getTotalCount() % pageLine;
			if(remainder > 0){
				//最后一页剩余的记录数（包括只有1页的情况）
				end = (currentPage - 1) * pageLine + remainder;
			}
		}
		return end;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getPageLine() {
		return pageLine;
	}
	public void setPageLine(Long pageLine) {
		this.pageLine = pageLine;
	}
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getPageNum() {
		return pageNum;
	}
	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = end;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public List<Long> getPageNumerList() {
		return pageNumerList;
	}
	public void setPageNumerList(List<Long> pageNumerList) {
		this.pageNumerList = pageNumerList;
	}
	@Test
	public void test(){
		PageBean pb = new PageBean(100l,5l,22l);
		List<Long> pblist = pb.getPageNumerList();
		for(Long l : pblist){
			System.out.println(l);
		}
		System.out.println(pb);
		String sb = pb.getPageInfo();
		System.out.println(sb);
	}
	
	@Override
	public String toString() {
		String rn = "\r\n";
		String sp = ":";
		String sp1 = " ";
		//打印结果
		String info = "记录如下"+sp+rn;
		if(null == list){
			this.setList(new ArrayList<Object>());
		}
		for(int x = 0;x<list.size();x++){
			info += "记录"+x + sp + list.get(x).toString() + rn;
		}	
		info += "总记录数："+this.getTotalCount()+ sp1;
		info += "总页数："+this.getPageNum()+ rn;
		info += "当前页："+this.getCurrentPage()+ sp1;
		info += "每页数："+this.getPageLine()+ rn;
		info += "start:"+this.getStart()+ sp1;
		info += "end:"+this.getEnd();
		return info;
	}
}
