package org.example.jpaonetomanyf25b.service;

import org.example.jpaonetomanyf25b.model.Kommune;
import org.example.jpaonetomanyf25b.model.Region;
import org.example.jpaonetomanyf25b.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner{

    private final RestClient restClient;

    // The RestClient bean we defined in the previous step is injected here
    public ApiServiceGetKommunerImpl(RestClient restClient) {
        this.restClient = restClient;
    }
    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuner(List<Kommune> kommuner) {
        kommuner.forEach(reg -> kommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner() {
        RestClient.ResponseSpec responseSpec = restClient.get()
                .uri(kommuneUrl)
                .header("Accept-Encoding", "identity")
                .retrieve();

        List<Kommune> kommuner = responseSpec.body(new ParameterizedTypeReference<List<Kommune>>() {});

        if (kommuner != null) {
            saveKommuner(kommuner);
        }
        return kommuner;

    }




}
