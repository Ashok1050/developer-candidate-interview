package com.upperhand.spring.schedule.dao;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Schedule")
public class ScheduleEntity {
     
	 @Id
	 private int RequestId;
     private String Name;
     private String TrainingType;
     private Date StartDate;
     private Time StartTime;
     private Date EndDate;
     private Time EndTime;
     private String With;
     private int count;
     
     public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ScheduleEntity(){
    	 
     }
     
     public ScheduleEntity(int requestId, String name, String trainingType, Date startDate, Time startTime,
    		 Date endDate, Time endTime, String with, int count) {
 		
 		this.RequestId = requestId;
 		this.Name = name;
 		this.TrainingType = trainingType;
 		this.StartDate = startDate;
 		this.StartTime = startTime;
 		this.EndDate = endDate;
 		this.EndTime = endTime;
 		this.With = with;
 		this.count = count;
 	}

	public int getRequestId() {
		return RequestId;
	}

	public void setRequestId(int requestId) {
		RequestId = requestId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTrainingType() {
		return TrainingType;
	}

	public void setTrainingType(String trainingType) {
		TrainingType = trainingType;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Time getStartTime() {
		return StartTime;
	}

	public void setStartTime(Time startTime) {
		StartTime = startTime;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public Time getEndTime() {
		return EndTime;
	}

	public void setEndTime(Time endTime) {
		EndTime = endTime;
	}

	public String getWith() {
		return With;
	}

	public void setWith(String with) {
		With = with;
	}
    
     
}
