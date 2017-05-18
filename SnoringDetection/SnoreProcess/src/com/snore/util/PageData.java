package com.snore.util;

//每一次启用检测的鼾声分析
public class PageData {

	//第几次检测
	private int id;
	//睡眠总时长
	private int sleepTime;
	//打鼾时间
	private int snoreTime;
	//较大鼾声时长
	private int snoreBigTime;
	//打鼾声音最大的时刻
	private String snoreMaxMoment;
	//正常打鼾时长
	private int snoreNormalTime;
	//监测时间
	private String startDetectTime;
	
	public PageData(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	public int getSnoreTime() {
		return snoreTime;
	}
	public void setSnoreTime(int snoreTime) {
		this.snoreTime = snoreTime;
	}
	public int getSnoreBigTime() {
		return snoreBigTime;
	}
	public void setSnoreBigTime(int snoreBigTime) {
		this.snoreBigTime = snoreBigTime;
	}
	public String getSnoreMaxMoment() {
		return snoreMaxMoment;
	}
	public void setSnoreMaxMoment(String snoreMaxMoment) {
		this.snoreMaxMoment = snoreMaxMoment;
	}
	public int getSnoreNormalTime() {
		return snoreNormalTime;
	}
	public void setSnoreNormalTime(int snoreNormalTime) {
		this.snoreNormalTime = snoreNormalTime;
	}

	public String getStartDetectTime() {
		return startDetectTime;
	}

	public void setStartDetectTime(String startDetectTime) {
		this.startDetectTime = startDetectTime;
	}
	
}
