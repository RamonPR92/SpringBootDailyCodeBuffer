package com.ramon.apirestdemo.repository;

import com.ramon.apirestdemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findDepartmentByDepartmentName(String departmentName);

    //@Query(value = "select DEPARTMENT_NAME from DEPARTMENT  WHERE DEPARTMENT_ID IN(1,2)", nativeQuery = true)
    @Query(value = "select d.departmentName from Department d WHERE d.departmentId IN(1,2)")
    List<String> findDepartmentNamesByIds();

}
