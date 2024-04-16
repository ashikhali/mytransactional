package com.ingress.mytransactional.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private Integer age;

    private String fatherName;

    private String occupation;

    private String school;
}
