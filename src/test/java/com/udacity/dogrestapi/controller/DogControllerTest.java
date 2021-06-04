package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;

    @WithMockUser(username = "admin", password = "1234")
    @Test
    public void getDogs() throws Exception {
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogs();
    }

    @WithMockUser(username = "admin", password = "1234")
    @Test
    public void getDogBreeds() throws Exception {
        mockMvc.perform(get("/dogs/breeds"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogBreed();
    }

    @WithMockUser(username = "admin", password = "1234")
    @Test
    public void getDogBreedsById() throws Exception {
        mockMvc.perform(get("/dogs/breeds/1"))
                .andExpect(status().isOk());
        verify(dogService, times(1)).retrieveDogBreedById(1L);
    }

    @WithMockUser(username = "admin", password = "1234")
    @Test
    public void getDogNames() throws Exception {
        mockMvc.perform(get("/dogs/names"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogNames();
    }
}
