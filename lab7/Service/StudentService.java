package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();
    private final TeacherService teacherService ;


    public ArrayList<Student> getStudent(){
        return students ;
    }



    public void addStudent(Student student1){
        students.add(student1);
    }


    public Boolean updateStudent(int Id , Student student){

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == Id){
                students.set(i , student);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteStudent(int Id){

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == Id){
                students.remove(i);
                return true ;
            }
        }
        return null ;
    }





    public Boolean grades(int IdT , int IdS , int score){

            if (teacherService.gradesID(IdT) == true){
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).getID() == IdS){
                        if (score >= 90){
                            students.get(j).setGrades('A');
                            students.get(j).setScore(score);
                            return true ;
                        } else if (score >= 80) {
                            students.get(j).setGrades('B');
                            students.get(j).setScore(score);
                            return true ;
                        } else if (score >= 70 ) {
                            students.get(j).setGrades('C');
                            students.get(j).setScore(score);
                            return true ;
                        } else if (score >= 60) {
                            students.get(j).setGrades('D');
                            students.get(j).setScore(score);
                            return true ;
                        } else {
                            students.get(j).setGrades('F');
                            students.get(j).setScore(score);
                            return true ;
                        }

                    }
                }
            }

        return null ;

    }



    public Boolean totalAbsence(int IdT , int IdS , int totalDay){

        if (teacherService.totalAbsence(IdT) == true){
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getID() == IdS){

                    if (totalDay >= 3){
                        students.get(i).setGrades('F');
                        students.get(i).setScore(0);
                        return false;
                    }else {
                        return true;
                    }

                }
            }
        }
        return null ;

    }



    public Boolean isGrade(int IdT , int IdS){

        if (teacherService.isGrade(IdT)){
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getID() == IdS){
                    if (students.get(i).getStudentForNow() == true){
                        students.get(i).setStudentForNow(false);
                        students.get(i).setDateNow(LocalDate.now());
                        return true;
                    }
                }
            }
        }

        return false ;
    }






    public Boolean level(int Id , int level){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID() == Id){
                students.get(i).setLevel(level);
                return true ;
            }
        }
        return false ;
    }


}
