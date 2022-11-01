package com.bkap.Service.impl;


import com.bkap.DTO.EmployeeDTO;
import com.bkap.Exception.ResourceNotFoundException;
import com.bkap.Entity.EmployeeEntity;
import com.bkap.Repository.IEmployeeReprsitory;
import com.bkap.Service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static com.bkap.Config.AppConstants.ID;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeReprsitory employeeReprsitory;



    @Override
    public EmployeeEntity save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        return employeeReprsitory.save(employeeEntity);
    }

    @Override
    public EmployeeEntity update(Long id, EmployeeDTO employeeDTO) {
        findById(id).map(p -> {
            BeanUtils.copyProperties(employeeDTO, p);
            return employeeReprsitory.save(p);
        }).orElseThrow(() -> new ResourceNotFoundException("employee",ID , id));
        return null;
    }

    @Override
    public void deleteById(Long id) {
        employeeReprsitory.deleteById(id);
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeReprsitory.findById(id);
    }

    @Override
    public Page<EmployeeEntity> findAll(Pageable pageable) {
        return employeeReprsitory.findAll(pageable);
    }

    @Override
    public List<EmployeeEntity> fillAll() {
        return employeeReprsitory.findAll();
    }


}
