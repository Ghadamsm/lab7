package com.example.lab7.Service;


import com.example.lab7.Model.Course;
import com.example.lab7.Model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CourseService {


    private final StudentService studentService ;
    private final TeacherService teacherService ;





    public Boolean level(int Id , int level){

        if (studentService.level(Id , level) == true){
           return true ;
        } else if (studentService.level(Id , level) == false) {
            return false ;
        }
        return null ;
    }






    public Boolean salary(int Id , int THour){
        if (teacherService.salary(Id , THour) == true){
            return true ;
        } else if (teacherService.salary(Id , THour) == false) {
            return false ;
        }
        return null ;
    }

}
