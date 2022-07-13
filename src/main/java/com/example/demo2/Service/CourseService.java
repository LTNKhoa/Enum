package com.example.demo2.Service;

import com.example.demo2.DTO.CourseDTO;
import com.example.demo2.Entity.CourseEntity;

import java.util.List;

public interface CourseService {
    CourseDTO save(CourseDTO courseDTO);

    CourseDTO update(CourseDTO courseDTO);

    void delete(long[] ids);

    List<CourseDTO> getAll();

    CourseEntity findCourse(Long id);

    List<CourseEntity> pagingCourse(String field, int page, int size);
}
