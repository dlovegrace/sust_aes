package com.great.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.cms.entity.TestRegistration;


public interface TestRegistrationDao extends
GenericDao<TestRegistration, Long> {

}
