package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CertificateComponentImpl implements CertificateComponent {
    private final CertificateRepository certificateRepository;

    public CertificateComponentImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public List<Certificate> getCertificates(String userId) {
        return certificateRepository.findByUserId(userId);
    }

    @Override
    public Certificate createCertificate(String userId, String eventId) {
        return certificateRepository.save(new Certificate(userId, eventId));
    }
}
