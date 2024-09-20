package br.com.luroma.event.management.web.requests;

import br.com.luroma.event.management.domain.User;

public record CreateUserRequest(String email, String firstName, String lastName) {
    public User toUser() {
        User user = new User(email, firstName, lastName);
        return user;
    }
}
