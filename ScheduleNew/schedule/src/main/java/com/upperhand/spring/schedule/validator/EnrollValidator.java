package com.upperhand.spring.schedule.validator;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.upperhand.spring.schedule.dao.InstructorEntity;
import com.upperhand.spring.schedule.dao.ScheduleEntity;


public class EnrollValidator implements Validator{

	@Autowired
	ScheduleEntity scheduleEntity;
	
	public boolean supports(Class<?> clazz) {
		return ScheduleEntity.class.isAssignableFrom(clazz);
	}
	
	// Validate if the lesson the student is trying to enroll is available or not
	public boolean validate(ScheduleEntity scheduleEntity, InstructorEntity ie, BindingResult result) {
		// TODO Auto-generated method stub
		ScheduleEntity scheduleStudent = (ScheduleEntity) scheduleEntity;
		
		InstructorEntity instructorEntity = (InstructorEntity) ie;
		
		ValidationUtils.rejectIfEmpty(result, "RequestId", "notEmpty.RequestId");
		ValidationUtils.rejectIfEmpty(result, "Name", "notEmpty.Name");
		ValidationUtils.rejectIfEmpty(result, "TrainingType", "notEmpty.TrainingType");
		ValidationUtils.rejectIfEmpty(result, "StartDate", "notEmpty.StartDate");
		ValidationUtils.rejectIfEmpty(result, "StartTime", "notEmpty.StartTime");
		ValidationUtils.rejectIfEmpty(result, "EndDate", "notEmpty.EndDate");
		ValidationUtils.rejectIfEmpty(result, "EndTime", "notEmpty.EndTime");
		ValidationUtils.rejectIfEmpty(result, "With", "notEmpty.With");
		
		//Check for the instructor Name then Lesson type then check whether the count of class 
		//and time selected by the student is valid in range
		if (instructorEntity.getName().equals("Joe Schmoe")) {
			if (instructorEntity.getTrainingType().equals("Private Lesson")) {
				if (instructorEntity.getParticipantsCount() > 1) {
					return false;
				} else {
					@SuppressWarnings("deprecation")
					int timeDiff =  (scheduleStudent.getEndTime().getMinutes() - scheduleStudent.getStartTime().getMinutes());
					if ((timeDiff == 60)) {
						return true;
					}
				}
			} else if (instructorEntity.getTrainingType().equals("Group Lesson")){
				if (instructorEntity.getParticipantsCount() > 10) {
					return false;
				} else {
					@SuppressWarnings("deprecation")
					int timeDiff =  (scheduleStudent.getEndTime().getMinutes() - scheduleStudent.getStartTime().getMinutes());
					if ((timeDiff == 60)) {
						return true;
				}
			}
		  }	
		} else if (instructorEntity.getName().equals("Jane Doe")) {
			if (instructorEntity.getTrainingType().equals("Private Lesson")) {
				if (instructorEntity.getParticipantsCount() > 1) {
					return false;
				} else {
					@SuppressWarnings("deprecation")
					int timeDiff =  (scheduleStudent.getEndTime().getMinutes() - scheduleStudent.getStartTime().getMinutes());
					if ((timeDiff == 30)) {
						return true;
					}
				}
			} else if (instructorEntity.getTrainingType().equals("Group Lesson")){
				if (instructorEntity.getParticipantsCount() > 3) {
					return false;
				} else {
					@SuppressWarnings("deprecation")
					int timeDiff =  (scheduleStudent.getEndTime().getMinutes() - scheduleStudent.getStartTime().getMinutes());
					if ((timeDiff == 60)) {
						return true;
				}
			}
		  }	
		}
		return false;

		
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
