package com.xxu.vo;

import java.util.ArrayList;
import java.util.List;

// 存储和分页相关的数据
public class PageBean<T> {

	private Integer currentPage;// 当前页
	private Integer start = 1; //首页
	private Integer totalPage; // 总页数/尾页
	private Integer totalCount; //总记录数
	private Integer pageSize = 8;// 每页显示记录个数
	private Integer startIndex; //开始的下标
	private List<T> pageInfos = new ArrayList<>();// 每页显示的数据列表
    
	
	public PageBean() {
		super();
	}

	/**
	 * 构造方法
	 * @param currentPage 当前页
	 * @param pageCount	每页显示记录数
	 * @param totalCount 总记录数
	 */
	public PageBean(int currentPage,int pageCount,int totalCount){
        this.currentPage=currentPage;
        this.pageSize=pageCount;
        this.totalCount=totalCount;
        
        if(totalCount % pageCount==0){ //取余，计算总页数
            this.totalPage = totalCount/ pageCount;
        }else{
            this.totalPage= totalCount/pageCount+1;
        }
        
        this.startIndex = (currentPage-1)*pageCount; //得到sql从第几条数据开始查询
    }
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageInfos() {
		return pageInfos;
	}
	public void setPageInfos(List<T> pageInfos) {
		this.pageInfos = pageInfos;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
}
