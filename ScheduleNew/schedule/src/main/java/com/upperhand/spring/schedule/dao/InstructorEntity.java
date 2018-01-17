package com.upperhand.spring.schedule.dao;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor_availability")
public class InstructorEntity {
	
	private String Name;
	private String TrainingType;
	private String MaxParticipants;
	private Date StartDate;
	private Date EndDate;
	private Time StartTime;
	private Time EndTime;
	private String Duration;
	private int participantsCount;
	
	public int getParticipantsCount() {
		return participantsCount;
	}

	public void setParticipantsCount(int participantsCount) {
		this.participantsCount = participantsCount;
	}

	public String getName() {
		return Name;
	}

	public String getTrainingType() {
		return TrainingType;
	}

	public String getMaxParticipants() {
		return MaxParticipants;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public Time getStartTime() {
		return StartTime;
	}
	
	public Time getEndTime() {
		return EndTime;
	}
	
	public String getDuration() {
		return Duration;
	}
	

}
