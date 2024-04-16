package com.ingress.mytransactional.services;

import com.ingress.mytransactional.aspects.TransactionalUncheckedRollback;
import com.ingress.mytransactional.dto.StudentRequestDTO;
import com.ingress.mytransactional.models.StudentEntity;
import com.ingress.mytransactional.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentTransactional {

    private final ModelMapper mapper;
    private final StudentRepository studentRepository;

//    public void callInsertMethod() throws Exception {
//        insertFirstAndSecondStudent();
//    }



    @SneakyThrows
    @TransactionalUncheckedRollback
    public void rollbackOnlyUnchecked() {

        StudentRequestDTO firstStudentDTO = StudentRequestDTO.builder()
                .firstName("Amin")
                .lastName("Sh")
                .studentNumber("123456")
                .age(26)
                .fatherName("...")
                .occupation("Engineer")
                .school("ABC High School")
                .build();

        StudentEntity firstStudent = mapper.map(firstStudentDTO, StudentEntity.class);
        studentRepository.save(firstStudent);


        if (true)
            throw new RuntimeException("Something went wrong on Runtime");


        StudentRequestDTO secondStudentDTO = StudentRequestDTO.builder()
                .firstName("Amin2")
                .lastName("Sh2")
                .studentNumber("123456")
                .age(26)
                .fatherName("...")
                .occupation("Engineer")
                .school("ABC High School")
                .build();

        StudentEntity secondStudent = mapper.map(secondStudentDTO, StudentEntity.class);
        studentRepository.save(secondStudent);


    }


    @TransactionalUncheckedRollback
    public void rollbackChecked() throws Exception{

        StudentRequestDTO firstStudentDTO = StudentRequestDTO.builder()
                .firstName("Amin3")
                .lastName("Sh3")
                .studentNumber("123456")
                .age(26)
                .fatherName("...")
                .occupation("Engineer")
                .school("ABC High School")
                .build();

        StudentEntity firstStudent = mapper.map(firstStudentDTO, StudentEntity.class);
        studentRepository.save(firstStudent);


        if (true)
            throw new Exception("Something went wrong on Runtime");


        StudentRequestDTO secondStudentDTO = StudentRequestDTO.builder()
                .firstName("Amin4")
                .lastName("Sh4")
                .studentNumber("123456")
                .age(26)
                .fatherName("...")
                .occupation("Engineer")
                .school("ABC High School")
                .build();

        StudentEntity secondStudent = mapper.map(secondStudentDTO, StudentEntity.class);
        studentRepository.save(secondStudent);


    }
}
