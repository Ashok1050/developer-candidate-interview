package com.upperhand.spring.schedule.validator;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.upperhand.spring.schedule.dao.ScheduleEntity;


public class EnrollValidator implements Validator{

	@Autowired
	ScheduleEntity scheduleEntity;
	
	public boolean supports(Class<?> clazz) {
		return ScheduleEntity.class.isAssignableFrom(clazz);
	}

	/*
	 RequestId;
     Name;
     TrainingType;
     StartDate;
     StartTime;
     EndDate;
     EndTime;
     With;
     
	 */
	
	
	public void validate(ScheduleEntity scheduleEntity, BindingResult result) {
		// TODO Auto-generated method stub
		ScheduleEntity scheduleStudent = (ScheduleEntity) scheduleEntity;
		
		//InstructorEntity IE = (InstructorEntity) instructorEntity;
		
		ValidationUtils.rejectIfEmpty(result, "RequestId", "notEmpty.RequestId");
		ValidationUtils.rejectIfEmpty(result, "Name", "notEmpty.Name");
		ValidationUtils.rejectIfEmpty(result, "TrainingType", "notEmpty.TrainingType");
		ValidationUtils.rejectIfEmpty(result, "StartDate", "notEmpty.StartDate");
		ValidationUtils.rejectIfEmpty(result, "StartTime", "notEmpty.StartTime");
		ValidationUtils.rejectIfEmpty(result, "EndDate", "notEmpty.EndDate");
		ValidationUtils.rejectIfEmpty(result, "EndTime", "notEmpty.EndTime");
		ValidationUtils.rejectIfEmpty(result, "With", "notEmpty.With");
		
		if(scheduleStudent.getCount() >= 1 && scheduleStudent.getTrainingType() == "Private Lesson" && scheduleStudent.getWith() == "Joe Schmoe"){
			result.rejectValue("Name", "Class Full");
		}
		if(scheduleStudent.getCount() >= 10 && scheduleStudent.getTrainingType() == "Group Lesson" && scheduleStudent.getWith() == "Joe Schmoe"){
			result.rejectValue("Name", "Class Full");
		}
		if(scheduleStudent.getCount() >= 1 && scheduleStudent.getTrainingType() == "Private Lesson" && scheduleStudent.getWith() == "Jane Doe"){
			result.rejectValue("Name", "Class Full");
		}
		if(scheduleStudent.getCount() >= 3 && scheduleStudent.getTrainingType() == "Group Lesson" && scheduleStudent.getWith() == "Jane Doe"){
			result.rejectValue("Name", "Class Full");
		}

		
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
	
	

}
