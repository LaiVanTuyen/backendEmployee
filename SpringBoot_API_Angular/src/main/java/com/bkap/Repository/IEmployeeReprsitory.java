package com.bkap.Repository;

import com.bkap.Entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeReprsitory extends JpaRepository<EmployeeEntity, Long> , PagingAndSortingRepository<EmployeeEntity,Long> {

}

