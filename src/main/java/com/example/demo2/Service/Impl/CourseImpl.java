package com.example.demo2.Service.Impl;

import com.example.demo2.DTO.CourseDTO;
import com.example.demo2.Entity.CourseEntity;
import com.example.demo2.Repository.CourseRepo;
import com.example.demo2.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        CourseEntity courseEntity = modelMapper.map(courseDTO, CourseEntity.class);
        CourseEntity course = courseRepo.save(courseEntity);
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        CourseEntity course = courseRepo.findById(courseDTO.getId()).orElseThrow();
        course = modelMapper.map(courseDTO, CourseEntity.class);
        CourseEntity course1 = courseRepo.save(course);
        return modelMapper.map(course1, CourseDTO.class);
    }

    @Override
    public void delete(long[] ids) {
        for (long courses : ids) {
            courseRepo.deleteById(courses);
        }
    }

    @Override
    public List<CourseDTO> getAll() {
        List<CourseEntity> courses = courseRepo.findAll();
        return courses.stream().map(courseList -> modelMapper.map(courseList, CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseEntity findCourse(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public List<CourseEntity> pagingCourse(String field, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, field);
        return courseRepo.findAll(pageable).toList();
    }
}
