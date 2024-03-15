package com.example.lab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
public class Student {


    @NotNull(message = "ID should be not empty")
    @Min(value = 2 , message = "Id must be more than 2")
    @Positive(message = "Positive numbers only")
    private Integer ID ;



    @NotEmpty(message = "name should be not empty")
    @Size(min = 3 , message = "name should be more than 3 char")
    private String name ;



    @NotNull(message = "age should be not empty")
    @Positive(message = "Positive numbers only")
    @Min(value = 18 , message = "please enter a valid age")
    private Integer age ;



    @NotEmpty(message = "major should be not empty")
    @Pattern(regexp = "^(CS|SE|IT|IS)$")
    private String major ;



    @AssertTrue
    private Boolean studentForNow ;



    @DateTimeFormat
    private LocalDate dateNow ;



    private Integer score ;


    private Character grades ;


    private Integer level ;

}
