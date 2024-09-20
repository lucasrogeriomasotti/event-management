package br.com.luroma.event.management.component.user;

import br.com.luroma.event.management.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserComponent {
    List<User> getUsers();
    Optional<User> getUser(String id);
    User createUser(User user);
}
