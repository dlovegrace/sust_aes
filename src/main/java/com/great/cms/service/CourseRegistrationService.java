package com.great.cms.service;

import java.util.List;

import com.great.cms.entity.CourseRegistration;


public interface CourseRegistrationService {
	
	public void saveOrUpdate(CourseRegistration courseRegistration);
	
	public List<CourseRegistration> getCourseRegistrations();
}
