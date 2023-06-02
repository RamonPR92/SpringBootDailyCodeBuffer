package com.ramon.apirestdemo.service;

import com.ramon.apirestdemo.entity.Department;
import com.ramon.apirestdemo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        //Creamos la respuesta para el test
        Department department = Department.builder()
                .departmentName("Calculus")
                .departmentAddress("Building C")
                .departmentCode("C01")
                .build();

        //Preparamos la respuesta con el objeto mockeado
        Mockito.when(departmentRepository.findDepartmentByDepartmentName("Calculus"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")//nombra el test para los reportes
    @Disabled//deshabilita el test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "Calculus";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}