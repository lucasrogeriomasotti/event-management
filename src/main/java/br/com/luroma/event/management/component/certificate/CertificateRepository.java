package br.com.luroma.event.management.component.certificate;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface CertificateRepository extends CrudRepository<CertificateEntity, String> {
    List<CertificateEntity> findByUserId(String userId);
}
