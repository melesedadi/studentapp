/* Create an application that represnts a one to many relationship between class and students
Student class with(name, Student ID, major, class id) and Classroom class with(classname, professor, credit, description)
*/
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;
    @RequestMapping("/")
    public String index (Model model){
        Student student = new Student();

        student.setName("Melese");
        student.setMajor("Science");

        Classroom classroom = new Classroom();
        classroom.setCredit(2);
        classroom.setProfessor("Moore");
        classroom.setDescription("This is the first class");
        classroom.setClassrom("ClassA");

        Set<Classroom> classrooms = new HashSet<Classroom>();
        classrooms.add(classroom);

        classroom = new Classroom();
        classroom.setClassrom("classB");
        classroom.setProfessor("Thom");
        classroom.setDescription("This is the second class");
        classroom.setCredit(3);
        classrooms.add(classroom);

       // classroom.setStudents(student);
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";


    }

}
