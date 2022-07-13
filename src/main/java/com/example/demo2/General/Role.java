package com.example.demo2.General;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Role {
    Read("r"),
    Write("w"),
    Execute("e");

    private String value;

    private static final Map<String, Role> roleStudent = new HashMap<>();

    static {
        for (Role role : Role.values()) {
            roleStudent.put((role.value), role);
        }
    }

    public static Role of(String s) {
        return roleStudent.get(s);
    }
}
