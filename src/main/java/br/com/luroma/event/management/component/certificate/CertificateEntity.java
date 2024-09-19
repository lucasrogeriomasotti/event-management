package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
class CertificateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String userId;
    private String eventId;

    public CertificateEntity() {
    }

    public CertificateEntity(String userId, String eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Certificate toDomainModel() {
        return new Certificate(id, userId, eventId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateEntity that = (CertificateEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
