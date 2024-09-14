package br.com.luroma.event.management.component.certificate;

import br.com.luroma.event.management.domain.Certificate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface CertificateRepository extends CrudRepository<Certificate, String> {
    List<Certificate> findByUserId(String userId);
}
