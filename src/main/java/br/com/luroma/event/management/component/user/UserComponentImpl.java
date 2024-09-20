package br.com.luroma.event.management.component.user;

import br.com.luroma.event.management.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
class UserComponentImpl implements UserComponent {
    private final UserRepository userRepository;

    UserComponentImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), true)
                .map(UserEntity::toDomainModel).toList();
    }

    @Override
    public Optional<User> getUser(String id) {
        return userRepository.findById(id)
                .map(UserEntity::toDomainModel);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(UserEntity.fromDomainModel(user))
                .toDomainModel();
    }
}
