package br.com.luroma.event.management.web;

import br.com.luroma.event.management.domain.Certificate;
import br.com.luroma.event.management.web.requests.CreateCertificateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tngtech.archunit.junit.ArchIgnore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class CertificatesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void create() throws Exception {
        var userId = UUID.randomUUID().toString();
        var eventId = UUID.randomUUID().toString();

        CreateCertificateRequest request = new CreateCertificateRequest(userId, eventId);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/certificates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Certificate createdCertificate = objectMapper.readValue(result.getResponse().getContentAsString(), Certificate.class);
        assertNotNull(createdCertificate.getId());
        assertEquals(userId, createdCertificate.getUserId());
        assertEquals(eventId, createdCertificate.getEventId());
    }
}