package org.dargor.customer.app.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.dargor.customer.app.client.ProductClient;
import org.dargor.customer.app.exception.CustomException;
import org.dargor.customer.app.util.MockedTestData;
import org.dargor.customer.core.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductClient productClient;

    @Test
    @DisplayName("createCustomer - OK")
    void createCustomer() {

        var wishListDto = MockedTestData.getWishListResponseDto();

        when(customerRepository.save(any()))
                .thenReturn(MockedTestData.getCustomerWithId());
        when(productClient.createProducts(any()))
                .thenReturn(wishListDto.getProducts());

        var actual = customerService.createCustomer(MockedTestData.getCustomerCreationRequestDto());

        assertNotNull(actual);
        verifyNoMoreInteractions(customerRepository, productClient);

    }

    @Test
    @DisplayName("getCustomer - OK")
    void getCustomer() {

        when(customerRepository.getReferenceById(any()))
                .thenReturn(MockedTestData.getCustomerWithId());

        var actual = customerService.getCustomer(UUID.randomUUID().toString());

        assertNotNull(actual);
        verifyNoMoreInteractions(customerRepository);
        verifyNoInteractions(productClient);

    }

    @Test
    @DisplayName("updateCustomer - OK")
    void updateCustomer() {

        var customer = MockedTestData.getCustomerUpdateRequestDto();

        when(customerRepository.save(any()))
                .thenReturn(MockedTestData.getCustomerWithId());

        var actual = customerService.updateCustomer(customer);

        assertNotNull(actual);
        verifyNoMoreInteractions(customerRepository);
        verifyNoInteractions(productClient);

    }

    @Test
    @DisplayName("getWishList - OK")
    void getWishList() {

        when(productClient.getWishList(any()))
                .thenReturn(MockedTestData.getWishListResponseDto().getProducts());

        when(customerRepository.getReferenceById(any()))
                .thenReturn(MockedTestData.getCustomerWithId());

        var actual = customerService.getWishList(String.valueOf(UUID.randomUUID()));

        assertNotNull(actual);
        verifyNoMoreInteractions(customerRepository, productClient);

    }

    @Test
    @DisplayName("getWishList - NOOK - Wrong input data")
    void getWishList_NOOK_Invalid_Input() {

        assertThrows(CustomException.class, () -> customerService.getWishList(null));

        verifyNoInteractions(customerRepository, productClient);

    }

    @Test
    @DisplayName("getCustomer - NOOK - Wrong input data")
    void getCustomer_NOOK_Invalid_Input() {

        assertThrows(CustomException.class, () -> customerService.getCustomer(null));

        verifyNoInteractions(customerRepository, productClient);

    }


}