package org.example.homework_jm7.user;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@Builder
public class User {
    private String id = UUID.randomUUID().toString();
    private String username;
    private String email;
    private String password;
}
