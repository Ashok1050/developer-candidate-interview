package com.upperhand.spring.schedule.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.upperhand.spring.schedule.dao.ScheduleEntity;
import com.upperhand.spring.schedule.exception.BadRequestException;


@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	public void addToStudentList(ScheduleEntity scheduleEntity) {

		String sql = "update schedule set RequestId=:RequestId, Name=:Name, TrainingType=:TrainingType, StartDate=:StartDate,"
				+ " StartTime=:StartTime, EndDate=:EndDate, EndTime=:EndTime, With=:With,"
				+ " where RequestId = :RequestId";
		
			namedParameterJdbcTemplate.update(sql, getSqlParameterSource(scheduleEntity));
        
	}

	private static final class ScheduleMapper implements RowMapper<ScheduleEntity>{

		public ScheduleEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScheduleEntity schedule = new ScheduleEntity();
			schedule.setRequestId(rs.getRequestId("RequestId"));
			schedule.setName(rs.getName("Name"));
			schedule.setTrainingType(rs.getTrainingType("TrainingTtpe"));
			schedule.setStartDate(rs.getStartDate("StartDate"));
			schedule.setStartTime(rs.getStartTime("StartTime"));
			schedule.setEndDate(rs.getEndDate("EndDate"));
			schedule.setEndTime(rs.getEndTime("EndTime"));
			schedule.setWith(rs.getWith("With"));
			schedule.setWith(rs.getCount("Count"));
			
			return schedule;
		}
		
	}
		
	
	public ScheduleEntity getScheduleById(int RequestId) {
		
		String sql = "select RequestId, Name, TrainingTtpe, StartDate, StartTime, EndDate, EndTime,"
				+ " from schedule where RequestId = :RequestId";
		
		ScheduleEntity scheduleVal = namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(RequestId),new ScheduleMapper());
        
		return scheduleVal;
	}
	
	private SqlParameterSource getSqlParameterSource(int RequestId){
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("RequestId", RequestId);
		
		return parameterSource;
	}

	public void updateSchedule(ScheduleEntity schedule) {
		
		String sql = "update schedule set RequestId=:RequestId, Name=:Name, TrainingType=:TrainingType, StartDate=:StartDate,"
				+ " StartTime=:StartTime, EndDate=:EndDate, EndTime=:EndTime, With=:With,"
				+ " where RequestId = :RequestId";
		
			namedParameterJdbcTemplate.update(sql, getSqlParameterSource(schedule));
        
	}
	
	private SqlParameterSource getSqlParameterSource(ScheduleEntity schedule){
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("RequestId", schedule.getRequestId());
		parameterSource.addValue("Name", schedule.getName());
		parameterSource.addValue("TrainingType", schedule.getTrainingType());
		parameterSource.addValue("StartDate", schedule.getStartDate());
		parameterSource.addValue("StartTime", schedule.getStartTime());
		parameterSource.addValue("EndDate", schedule.getEndDate());
		parameterSource.addValue("EndTime", schedule.getEndTime());
		parameterSource.addValue("With", schedule.getWith());
		
		int a = schedule.getCount();
		if(a <= 10 && schedule.getTrainingType() == "Group Lesson" && schedule.getWith() == "Joe Schmoe"){
			a++;
			schedule.setCount(a);
		}else if(a <= 1 && schedule.getTrainingType() == "Private Lesson" && schedule.getWith() == "Joe Schmoe"){
			a++;
			schedule.setCount(a);
		}else if(a <= 3 && schedule.getTrainingType() == "Group Lesson" && schedule.getWith() == "Jane Doe"){
			a++;
			schedule.setCount(a);
		}else if(a <= 1 && schedule.getTrainingType() == "Private Lesson" && schedule.getWith() == "Jane Doe"){
			a++;
			schedule.setCount(a);
		}else {
			throw new BadRequestException("The class you are trying to enroll is full");
		}
		
		parameterSource.addValue("", schedule.getCount());
		return parameterSource;
	}

}
