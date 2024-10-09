package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;
import com.tngtech.archunit.junit.ArchIgnore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class CertificateComponentTest {

    @Autowired
    private CertificateComponent certificateComponent;

    @Test
    void testCreateAndGetCertificates() {
        var userId = UUID.randomUUID().toString();
        var eventId = UUID.randomUUID().toString();

        var certificate = certificateComponent.createCertificate(userId, eventId);

        List<Certificate> certificates = certificateComponent.getCertificates(userId);
        assertEquals(1, certificates.size());
        assertSame(certificate.getId(), certificates.getFirst().getId());
    }
}
