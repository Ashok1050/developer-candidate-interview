package com.upperhand.spring.schedule.repository;

import com.upperhand.spring.schedule.dao.ScheduleEntity;

public interface ScheduleRepository {

	void addToStudentList(ScheduleEntity scheduleEntity);

}
