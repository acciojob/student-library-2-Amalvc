package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
@RequestMapping("/student")
public class StudentController {

    //Add required annotations
    @Autowired
    StudentService studentService;
    @GetMapping("/get_by_email")
    public ResponseEntity<String> getStudentByEmail(@RequestParam("email") String email){
        String ans=studentService.getDetailsByEmail(email).toString();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    //Add required annotations
    @GetMapping("/get_by_id")
    public ResponseEntity getStudentById(@RequestParam("id") int id){
        String ans=studentService.getDetailsById(id).toString();

        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    //Add required annotations
    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student){
        studentService.createStudent(student);

        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations
    @PostMapping("/update")
    public ResponseEntity updateStudent(@RequestBody Student student){
         studentService.updateStudent(student);

        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);

        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
