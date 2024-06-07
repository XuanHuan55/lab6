/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1_lab6;

import java.util.ArrayList;

/**
 *
 * @author tai.tran
 */
public class Studentmanager {
     private ArrayList<Student> arrs = new ArrayList<>();

    public ArrayList<Student> getArrs() {
        return arrs;
    }

    public void setArrs(ArrayList<Student> arrs) {
        this.arrs = arrs;
    }

    public Studentmanager() {
    }
    public Student FindStudentById(String studentId)
    {
        return null;
    }
    
    public boolean AddStudent(Student stu)
    {
        for(Student s:arrs)
            if(s.getStudentID().equals(stu.getStudentID()))
                return false;
        arrs.add(stu);
        return true;
    }
}
