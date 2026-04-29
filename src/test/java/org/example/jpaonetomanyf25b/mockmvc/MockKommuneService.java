package org.example.jpaonetomanyf25b.mockmvc;

import org.example.jpaonetomanyf25b.controller.KommuneController;
import org.example.jpaonetomanyf25b.model.Kommune;
import org.example.jpaonetomanyf25b.repository.KommuneRepository;
import org.example.jpaonetomanyf25b.service.ApiServiceGetKommuner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(KommuneController.class)
public class MockKommuneService {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ApiServiceGetKommuner apiServiceGetKommuner;

    @MockitoBean
    private KommuneRepository kommuneRepository;

    @Test
    void getHello() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void getKommuneStartsWith_returnsList() throws Exception {
        // Arrange
        List<Kommune> mockList = List.of(
                new Kommune("0001", "Aarhus"),
                new Kommune("0002", "Aalborg")
        );
        when(apiServiceGetKommuner.getKommunerStartsWith('A')).thenReturn(mockList);
        // Act + Assert
        mockMvc.perform(get("/kommunestart/A")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].navn").value("Aarhus"))
                .andExpect(jsonPath("$[1].navn").value("Aalborg"));
        verify(apiServiceGetKommuner).getKommunerStartsWith('A');
    }


}
