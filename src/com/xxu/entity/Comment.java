package com.xxu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 评论类
 * @author Administrator
 *
 */
public class Comment {
	private Integer id;
	private Integer sd;
	private Integer pid;
	private String content;
	private Date releaseTime;
	private String dateStr;
	public Comment() {
		super();
	}
	public Comment(Integer id, Integer sid, Integer pid, String content, Date releaseTime) {
		super();
		this.id = id;
		this.sd = sid;
		this.pid = pid;
		this.content = content;
		this.releaseTime = releaseTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dateStr = sdf.format(releaseTime);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSd() {
		return sd;
	}
	public void setSd(Integer sid) {
		this.sd = sid;
	}
	public Integer getPId() {
		return pid;
	}
	public void setPId(Integer pid) {
		this.pid = pid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReleaseTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String format = f.format(releaseTime);
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public void setDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			this.dateStr = sdf.format(date);
		}
	}
	
	public String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (this.releaseTime != null) {
			return sdf.format(this.releaseTime);
		}
		return "2020-02-21";
	}
	
	
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", sd=" + sd + ", pid=" + pid + ", content=" + content + ", releaseTime="
				+ releaseTime + ", dateStr=" + dateStr + "]";
	}
	
	
}
