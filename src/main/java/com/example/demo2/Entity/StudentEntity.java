package com.example.demo2.Entity;

import com.example.demo2.Converter.GenderConverter;
import com.example.demo2.Converter.RoleConverter;
import com.example.demo2.General.Gender;
import com.example.demo2.General.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long studentId;

    @Column(name = "name")
    private String studentName;

    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "student_role", joinColumns = {@JoinColumn(name = "student_id")})
    @Column(name = "role")
    @Convert(converter = RoleConverter.class)
    private List<Role> role = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<RegistrationEntity> registrations = new ArrayList<>();
}
