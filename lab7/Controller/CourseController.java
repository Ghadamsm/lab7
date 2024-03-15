package com.example.lab7.Controller;


import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService ;




    @GetMapping("/level/{Id}/{level}")
    public ResponseEntity getLevel (@PathVariable int Id , @PathVariable int level){


        if (courseService.level(Id , level) == false ){
            return ResponseEntity.status(400).body("invalid id");
        }

        return ResponseEntity.status(200).body("level updated");

    }




    @GetMapping("/salary/{Id}/{THour}")
    public ResponseEntity salary(@PathVariable int Id , @PathVariable int THour){


        if (courseService.salary(Id , THour) == false ){
            return ResponseEntity.status(400).body("invalid id");
        }

        return ResponseEntity.status(200).body("salary updated");

    }

}
