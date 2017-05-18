package com.snore.util;

import java.util.Date;

/**
 * 用来存放处理后的数据集
 */
public class Data {

	private int id;
	private Date startTime;
	private Date endTime;
	private double duration;
	private double meanValue;
	private double maximumValue;
	private Date dateTime;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getMeanValue() {
		return meanValue;
	}
	public void setMeanValue(double meanValue) {
		this.meanValue = meanValue;
	}
	public double getMaximumValue() {
		return maximumValue;
	}
	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
