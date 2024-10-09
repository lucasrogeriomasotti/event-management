package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.component.notification.NotificationComponent;
import br.com.luroma.event.management.domain.Certificate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CertificateComponentImplTest {
    @Mock
    private CertificateRepository certificateRepository;

    @Mock
    private NotificationComponent notificationComponent;

    @InjectMocks
    private CertificateComponentImpl certificateComponent;

    @Test
    void testGetCertificates() {
        String userId = "user123";
        CertificateEntity certificateEntity = new CertificateEntity(userId, "event123");
        when(certificateRepository.findByUserId(userId)).thenReturn(List.of(certificateEntity));

        List<Certificate> certificates = certificateComponent.getCertificates(userId);

        assertEquals(1, certificates.size());
        assertEquals(userId, certificates.getFirst().getUserId());
        verify(certificateRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testCreateCertificate() {
        String userId = "user123";
        String eventId = "event123";
        CertificateEntity certificateEntity = new CertificateEntity(userId, eventId);
        when(certificateRepository.save(any(CertificateEntity.class))).thenReturn(certificateEntity);

        Certificate certificate = certificateComponent.createCertificate(userId, eventId);

        assertEquals(userId, certificate.getUserId());
        assertEquals(eventId, certificate.getEventId());
        verify(certificateRepository, times(1)).save(any(CertificateEntity.class));
        verify(notificationComponent, times(1)).notifyCertificateCreated(userId, eventId);
    }
}