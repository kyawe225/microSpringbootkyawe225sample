package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    ISchoolService service;

    @GetMapping("hello-world")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/api/v1/schools")
    public ResponseEntity<Boolean> insert(@RequestBody School s) {
        return ResponseEntity.ok(service.insert(s));
    }

    @PutMapping("/api/v1/schools/"+"{id}")
    public ResponseEntity<Boolean> update(@RequestBody School s) {
        return ResponseEntity.ok(service.update(s));
    }

    @DeleteMapping("/api/v1/schools/"+"{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/api/v1/schools"+"")
    public ResponseEntity<Iterable<School>> all() {
        return ResponseEntity.ok(service.all());
    }

    @PostMapping("/api/v1/schools/"+"saveall")
    public ResponseEntity<Boolean> saveall(@RequestBody List<School> s) {
        return ResponseEntity.ok(service.saveAll(s));
    }

    @GetMapping("/api/v1/schools/"+"{id}")
    public ResponseEntity<School> getDetail(@PathVariable int id) {
        return ResponseEntity.ok(service.getDetail(id));
    }
}
