package com.example.lab7.Controller;


import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService ;


    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudent());
    }



    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student1 , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        studentService.addStudent(student1);
        return ResponseEntity.status(200).body("added");

    }




    @PutMapping("/update/{Id}")
    public ResponseEntity updateStudent(@PathVariable int Id , @RequestBody @Valid Student student , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdate = studentService.updateStudent(Id , student);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }




    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteStudent(@PathVariable int Id ){


        if (studentService.deleteStudent(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }


    @GetMapping("/grade/{IdT}/{IdS}/{score}")
    public ResponseEntity grades(@PathVariable int IdT ,@PathVariable int IdS ,@PathVariable int score){

        if (studentService.grades(IdT ,IdS ,score) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }


        return ResponseEntity.status(200).body("grade added");

    }




    @GetMapping("/absence/{IdT}/{IdS}/{totalDay}")
    public ResponseEntity totalAbsence(@PathVariable int IdT ,@PathVariable int IdS ,@PathVariable int totalDay){

        if (studentService.totalAbsence(IdT , IdS , totalDay) == null ){
            return ResponseEntity.status(400).body("Invalid Id");
        } else if (studentService.totalAbsence(IdT ,IdS ,totalDay) == false){
            return ResponseEntity.status(400).body("Sorry , you missed this course");
        }

        return ResponseEntity.status(200).body("absence day is added");
    }



    @GetMapping("/isGrade/{IdT}/{IdS}")
    public ResponseEntity isGrade(@PathVariable int IdT ,@PathVariable int IdS){

        if (studentService.isGrade(IdT , IdS) == false){
            return ResponseEntity.status(400).body("Invalid");
        }

        return ResponseEntity.status(200).body("Congratulation");
    }




}
