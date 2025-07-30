package com.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HomeController {
    @Autowired
    StudentService service;

    @GetMapping("hello-world")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/api/v1/students")
    public ResponseEntity<Boolean> insert(@RequestBody Student s) {
        return ResponseEntity.ok(service.insert(s));
    }

    @PutMapping("/api/v1/students/"+"{id}")
    public ResponseEntity<Boolean> update(@RequestBody Student s) {
        return ResponseEntity.ok(service.update(s));
    }

    @DeleteMapping("/api/v1/students/"+"{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/api/v1/students"+"")
    public ResponseEntity<Iterable<Student>> all() {
        return ResponseEntity.ok(service.all());
    }

    @PostMapping("/api/v1/students/"+"saveall")
    public ResponseEntity<Boolean> saveall(@RequestBody List<Student> s) {
        return ResponseEntity.ok(service.saveAll(s));
    }

    @GetMapping("/api/v1/students/"+"{id}")
    public ResponseEntity<Student> getDetail(@PathVariable int id) {
        return ResponseEntity.ok(service.getDetail(id));
    }
}
