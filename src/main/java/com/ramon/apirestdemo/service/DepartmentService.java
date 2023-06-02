package com.ramon.apirestdemo.service;

import com.ramon.apirestdemo.entity.Department;
import com.ramon.apirestdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fectchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

    List<String> fetchDepartmentNamesByIds();
}
