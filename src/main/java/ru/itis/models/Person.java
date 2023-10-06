package ru.itis.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Person {
    private Long id;
    private String nickname;
    private String email;
    private String password;
}
