package br.com.luroma.event.management.component.user;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<UserEntity, String> {
}
