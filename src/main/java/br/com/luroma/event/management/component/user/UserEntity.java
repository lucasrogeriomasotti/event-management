package br.com.luroma.event.management.component.user;

import br.com.luroma.event.management.domain.Event;
import br.com.luroma.event.management.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String email;
    private String firstName;
    private String lastName;

    public User toDomainModel() {
        return new User(id, email, firstName, lastName);
    }

    public static UserEntity fromDomainModel(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        return entity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
