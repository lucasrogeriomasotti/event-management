package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.component.notification.NotificationComponent;
import br.com.luroma.event.management.domain.Certificate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class CertificateComponentImpl implements CertificateComponent {
    private final CertificateRepository certificateRepository;
    private final NotificationComponent notificationComponent;

    public CertificateComponentImpl(CertificateRepository certificateRepository, NotificationComponent notificationComponent) {
        this.certificateRepository = certificateRepository;
        this.notificationComponent = notificationComponent;
    }

    @Override
    public List<Certificate> getCertificates(String userId) {
        return certificateRepository.findByUserId(userId).stream().map(CertificateEntity::toDomainModel).toList();
    }

    @Override
    public Certificate createCertificate(String userId, String eventId) {
        //TODO Validate existence of user and event

        Certificate certificate = certificateRepository.save(new CertificateEntity(userId, eventId)).toDomainModel();
        notificationComponent.notifyCertificateCreated(userId, eventId);
        return certificate;
    }
}
