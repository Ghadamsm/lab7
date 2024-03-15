package com.example.lab7.Service;

import com.example.lab7.Model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();




    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }


    public void addTeacher (Teacher teacher){

        teachers.add(teacher);

    }


    public Boolean updateTeacher(int Id , Teacher teacher){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == Id){
                teachers.set(i , teacher);
                return true ;
            }

        }
        return false ;

    }




    public Boolean deleteTeacher(int Id){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == Id){
                teachers.remove(i);
                return true ;
            }
        }
        return null ;
    }



    public Boolean gradesID(int IdT){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == IdT){
                return true ;
            }
        }

        return false ;
    }



    public Boolean totalAbsence(int IdT ){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == IdT){
                return true ;
            }
        }

        return false ;
    }


    public Boolean isGrade(int IdT ){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == IdT){
                return true;
            }
        }
        return false ;
    }



    public Boolean salary(int Id , int THour){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getID() == Id){
                for (Teacher teacher : teachers){
                    teacher.setSalary(30 * THour);
                    return true ;
                }
            }
        }

        return false ;
    }


}
