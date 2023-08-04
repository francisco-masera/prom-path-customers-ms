package org.dargor.customer.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dargor.customer.app.exception.ExceptionAdviser;
import org.dargor.customer.app.service.CustomerServiceImpl;
import org.dargor.customer.app.util.MockedTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerServiceImpl customerService;

    private MockMvc mockMvc;

    @InjectMocks
    private ExceptionAdviser exceptionAdviser;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(customerController)
                .setControllerAdvice(exceptionAdviser)
                .build();
    }

    @Test
    @DisplayName("createCustomer - OK")
    void createCustomer() throws Exception {

        when(customerService.createCustomer(any()))
                .thenReturn(MockedTestData.getWishListDto());

        var response = mockMvc.perform(post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(MockedTestData.getCustomerCreationRequestDto())))
                .andExpect(status().isCreated())
                .andReturn();

        assertNotNull(response.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("getCustomer - OK")
    void getCustomer() throws Exception {

        when(customerService.getCustomer(any()))
                .thenReturn(MockedTestData.getCustomerDto());

        var response = mockMvc.perform(get("/customer/" + UUID.randomUUID()))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(response.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("updateCustomer - OK")
    void updateCustomer() throws Exception {

        when(customerService.updateCustomer(any()))
                .thenReturn(MockedTestData.getCustomerDto());

        var response = mockMvc.perform(put("/customer/update")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(MockedTestData.getCustomerUpdateRequestDto())))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(response.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("getWishList - OK")
    void getWishList() throws Exception {

        when(customerService.getWishList(any()))
                .thenReturn(MockedTestData.getWishListDto());

        var response = mockMvc.perform(get("/customer/wish-list/" + UUID.randomUUID()))
                .andExpect(status().isOk())
                .andReturn();

        assertNotNull(response.getResponse().getContentAsString());

    }
}