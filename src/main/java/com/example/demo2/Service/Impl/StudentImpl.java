package com.example.demo2.Service.Impl;

import com.example.demo2.DTO.StudentDTO;
import com.example.demo2.Entity.StudentEntity;
import com.example.demo2.Repository.StudentRepo;
import com.example.demo2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
        StudentEntity student = studentRepo.save(studentEntity);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        Optional<StudentEntity> optional = studentRepo.findById(studentDTO.getId());
        if (optional.isPresent()) {
            StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
            StudentEntity student = studentRepo.save(studentEntity);
            return modelMapper.map(student, StudentDTO.class);
        }
        return null;
    }

    @Override
    public StudentEntity findStudent(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(long[] ids) {
        for (long students : ids) {
            studentRepo.deleteById(students);
        }
    }

    @Override
    public List<StudentDTO> getAll() {
        List<StudentEntity> students = studentRepo.findAll();
        return students.stream().map(studentsList -> modelMapper.map(studentsList, StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentEntity> pagingStudent(String field, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, field);
        return studentRepo.findAll(pageable).toList();
    }
}
