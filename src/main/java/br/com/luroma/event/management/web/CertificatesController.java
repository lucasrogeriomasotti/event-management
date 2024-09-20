package br.com.luroma.event.management.web;


import br.com.luroma.event.management.component.certificate.CertificateComponent;
import br.com.luroma.event.management.domain.Certificate;
import br.com.luroma.event.management.web.requests.CreateCertificateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/certificates")
public class CertificatesController {

    @Autowired
    private CertificateComponent certificateComponent;

    @GetMapping
    public List<Certificate> list(@RequestParam String userId) {
        return certificateComponent.getCertificates(userId);
    }

    @PostMapping
    public Certificate create(@RequestBody CreateCertificateRequest request) {
        return certificateComponent.createCertificate(request.userId(), request.eventId());
    }
}
