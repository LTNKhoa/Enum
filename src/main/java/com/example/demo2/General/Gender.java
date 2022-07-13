package com.example.demo2.General;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("m"),
    FEMALE("f"),
    OTHER("o");

    private String value;

    private static final Map<String, Gender> genderStudent = new HashMap<>();

    static {
        for (Gender gender : Gender.values()) {
            genderStudent.put((gender.value), gender);
        }
    }

    public static Gender of(String s) {
        return genderStudent.get(s);
    }
}
