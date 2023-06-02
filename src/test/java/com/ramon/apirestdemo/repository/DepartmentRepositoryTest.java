package com.ramon.apirestdemo.repository;

import com.ramon.apirestdemo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        //No se asigna un id, por que este es generado en automatico por la bd
        Department department = Department.builder()
                .departmentName("English")
                .departmentAddress("Building D")
                .departmentCode("E01")
                .build();

        //Crea una tabla con un registro, pero es temporal, solo para pruebas
        entityManager.persist(department);
    }

    @Test
    @DisplayName("Get Department by Id")
    public void whenFindById_thenReturnDepartment(){
        //Se busca con el id 1 por que solo persistimos un registro
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "English");
    }

}