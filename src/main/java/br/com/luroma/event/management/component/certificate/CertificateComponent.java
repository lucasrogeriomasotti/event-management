package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;

import java.util.List;


public interface CertificateComponent {
    List<Certificate> getCertificates(String userId);
    Certificate createCertificate(String userId, String eventId);
}
