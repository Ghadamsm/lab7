package com.example.lab7.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {


    @NotNull(message = "ID should be not empty")
    private Integer ID ;

    @NotEmpty(message = "name should be not empty")
    private String name ;

    @NotEmpty(message = "major should be not empty")
    @Pattern(regexp = "^(CS|SE|IT|IS)$" , message = "major must be CS , SE , IS , IT only ")
    private String major ;


    @Pattern(regexp = "^(software engineering|artificial intelligence|computer systems and networks|database systems" +
            "|human computer interaction|programming languages)$" ,
            message = "subject must be software engineering , artificial intelligence , computer systems and networks ," +
                    " database systems , human computer interaction , programming languages ")
    private String subject ;



    private Integer salary ;






}
