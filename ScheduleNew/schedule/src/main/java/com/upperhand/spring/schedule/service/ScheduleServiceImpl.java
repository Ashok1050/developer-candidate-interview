package com.upperhand.spring.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upperhand.spring.schedule.dao.ScheduleEntity;
import com.upperhand.spring.schedule.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	ScheduleRepository scheduleRepository; 

	public void enroll(ScheduleEntity scheduleEntity) {
		scheduleRepository.addToStudentList(scheduleEntity);
	}
	
	

}
