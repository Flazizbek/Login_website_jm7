package org.example.homework_jm7.user;


import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final List<User> USERS = new ArrayList<>();

    public static User add(String username, String email, String password){
        if(USERS.stream().anyMatch(u->email.equals(u.getEmail()))){
             throw new RuntimeException("Email already registered!");
        }
        User user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
        USERS.add(user);
        return user;
    }

    public static User getByEmail(String email, String password ){
        User user = USERS.stream().filter(u-> email.equals(u.getEmail())).findFirst().orElseThrow(()->  new RuntimeException("Email not found!"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password");
        }
        return user;
    }
}
