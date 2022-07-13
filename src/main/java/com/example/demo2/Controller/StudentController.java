package com.example.demo2.Controller;

import com.example.demo2.DTO.StudentDTO;
import com.example.demo2.Entity.StudentEntity;
import com.example.demo2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(studentDTO));
    }

    @DeleteMapping
    public void delete(@RequestBody long[] ids) {
        studentService.delete(ids);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping(value = "/paging")
    public List<StudentEntity> pagingStudent(@RequestParam(defaultValue = "studentName") String field,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "3") int size)
    {
        return studentService.pagingStudent(field, page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<StudentEntity>(studentService.findStudent(id), HttpStatus.OK);
    }
}
