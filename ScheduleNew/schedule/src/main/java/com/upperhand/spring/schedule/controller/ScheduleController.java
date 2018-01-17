package com.upperhand.spring.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upperhand.spring.schedule.dao.ScheduleEntity;
import com.upperhand.spring.schedule.exception.BadRequestException;
import com.upperhand.spring.schedule.service.ScheduleService;
import com.upperhand.spring.schedule.validator.EnrollValidator;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private EnrollValidator enrollValidator;
	
	@Autowired
	private ScheduleService scheduleService;


	@RequestMapping(value = "/enroll", method=RequestMethod.POST)
	public void register(@ModelAttribute("scheduleEntity") ScheduleEntity scheduleEntity, BindingResult result, RedirectAttributes redirectAttributes){
		
		enrollValidator.validate(scheduleEntity,result);
		
		if(result.hasErrors()){
			scheduleService.enroll(scheduleEntity);
		}else{
			//throw new BadRequestException("The time slot you are trying to schedule is full");
			exception();
		}
	}
	
	@RequestMapping(value = "/exception", method=RequestMethod.GET)
	public static void exception(){
		throw new BadRequestException("The subject you are trying to enroll is full");
	}
}
