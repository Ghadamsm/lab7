package com.example.lab7.Controller;


import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {


    private final TeacherService teacherService ;



    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }



    @PostMapping("/add")
    public ResponseEntity addTeacher (@RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("added");


    }




    @PutMapping("/update/{Id}")
    private ResponseEntity updateTeacher(@PathVariable int Id , @RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = teacherService.updateTeacher(Id , teacher);

        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Id not found");
    }



    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteStudent(@PathVariable int Id ){


        if (teacherService.deleteTeacher(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }

}
