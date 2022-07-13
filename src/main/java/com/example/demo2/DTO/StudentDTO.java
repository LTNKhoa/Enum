package com.example.demo2.DTO;

import com.example.demo2.General.Gender;
import com.example.demo2.General.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    private long id;
    private String name;
    private Gender gender;
    private List<Role> role;
}
