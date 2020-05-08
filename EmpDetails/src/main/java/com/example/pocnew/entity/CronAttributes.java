package com.example.pocnew.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity  
@Table
public class CronAttributes
{
	public CronAttributes()
	{}
	
	

	public int getCronID() {
		return cronID;
	}

	public void setCronID(int cronID) {
		this.cronID = cronID;
	}

	public String getSeconds() {
		return seconds;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public String getMinutes() {
		return Minutes;
	}

	public void setMinutes(String minutes) {
		Minutes = minutes;
	}

	public String getHours() {
		return Hours;
	}

	public void setHours(String hours) {
		Hours = hours;
	}

	public String getDayOfMonth() {
		return DayOfMonth;
	}

	public void setDayOfMonth(String dayOfMonth) {
		DayOfMonth = dayOfMonth;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	@Id  
	@Column  
	private int cronID;
	
	
	@Column
	private String seconds;
	
	@Column
	private String Minutes;
	
	@Column
	private String Hours;
	
	@Column
	private String DayOfMonth;
	
	@Column
	private String month;
	
	@Column
	private String dayOfTheWeek;
	
	

}
