package com.bkap.Service;

import com.bkap.Entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.List;
public interface Service<T,R> {
    T save(R r);

    EmployeeEntity update(Long id, R r);

    void deleteById(Long id);

    Optional<T> findById(Long id);

    Page<T> findAll(Pageable pageable);
    List<T> fillAll();
}
