package org.example.jpaonetomanyf25b.service;

import org.example.jpaonetomanyf25b.model.Region;
import org.example.jpaonetomanyf25b.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner{

    private final RestClient restClient;

    // The RestClient bean we defined in the previous step is injected here
    public ApiServiceGetRegionerImpl(RestClient restClient) {
        this.restClient = restClient;
    }
    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(reg -> regionRepository.save(reg));
    }
    @Override
    public List<Region> getRegioner() {
        RestClient.ResponseSpec responseSpec = restClient.get()
                .uri(regionUrl)
                .header("Accept-Encoding", "identity")
                .retrieve();

        List<Region> regioner = responseSpec.body(new ParameterizedTypeReference<List<Region>>() {});

        if (regioner != null) {
            saveRegioner(regioner);
        }
        return regioner;
    }
}
