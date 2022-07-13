package com.example.demo2.Controller;

import com.example.demo2.DTO.CourseDTO;
import com.example.demo2.Entity.CourseEntity;
import com.example.demo2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.update(courseDTO));
    }

    @DeleteMapping
    public void delete(@RequestBody long[] ids) {
        courseService.delete(ids);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping(value = "/paging")
    public List<CourseEntity> pagingCourse(@RequestParam(defaultValue = "courseName") String field,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "3") int size)
    {
        return courseService.pagingCourse(field, page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseEntity> getCourse(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<CourseEntity>(courseService.findCourse(id), HttpStatus.OK);
    }
}
