package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
}
