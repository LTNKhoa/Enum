package com.example.demo2.Service;

import com.example.demo2.DTO.StudentDTO;
import com.example.demo2.Entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    void delete(long[] ids);

    List<StudentDTO> getAll();

    StudentEntity findStudent(Long id);

    List<StudentEntity> pagingStudent(String field, int page, int size);
}
