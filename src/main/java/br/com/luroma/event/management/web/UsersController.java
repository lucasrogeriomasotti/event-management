package br.com.luroma.event.management.web;

import br.com.luroma.event.management.component.user.UserComponent;
import br.com.luroma.event.management.domain.Certificate;
import br.com.luroma.event.management.domain.User;
import br.com.luroma.event.management.web.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserComponent userComponent;

    @GetMapping
    public List<User> list() {
        return userComponent.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        return userComponent.getUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User create(@RequestBody CreateUserRequest request) {
        return userComponent.createUser(request.toUser());
    }
}
