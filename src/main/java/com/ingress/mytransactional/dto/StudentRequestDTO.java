package com.ingress.mytransactional.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {


    private String firstName;

    private String lastName;

    private String studentNumber;

    private Integer age;

    private String fatherName;

    private String occupation;

    private String school;
}

