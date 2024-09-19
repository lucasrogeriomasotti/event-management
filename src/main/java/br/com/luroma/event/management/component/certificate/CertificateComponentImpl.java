package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class CertificateComponentImpl implements CertificateComponent {
    private final CertificateRepository certificateRepository;

    public CertificateComponentImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public List<Certificate> getCertificates(String userId) {
        return certificateRepository.findByUserId(userId).stream().map(CertificateEntity::toDomainModel).toList();
    }

    @Override
    public Certificate createCertificate(String userId, String eventId) {
        return certificateRepository.save(new CertificateEntity(userId, eventId)).toDomainModel();
    }
}
