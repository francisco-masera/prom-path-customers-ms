package org.dargor.customer.app.util;

import org.dargor.customer.app.dto.request.AddressRequestDto;
import org.dargor.customer.app.dto.request.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.request.CustomerUpdateRequestDto;
import org.dargor.customer.app.dto.request.ProductRequestDto;
import org.dargor.customer.app.dto.response.CustomerResponseDto;
import org.dargor.customer.app.dto.response.ProductResponseDto;
import org.dargor.customer.app.dto.response.WishListResponseDto;
import org.dargor.customer.core.entity.Address;
import org.dargor.customer.core.entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MockedTestData {

    public static WishListResponseDto getWishListResponseDto() {
        return WishListResponseDto.builder()
                .customer(getCustomerDto())
                .products(List.of(getProductResponseDto()))
                .build();
    }

    public static ProductResponseDto getProductResponseDto() {
        return ProductResponseDto.builder()
                                 .denomination("denomination")
                                 .brand("brand")
                                 .quantity(1000L)
                                 .unitPrice(BigDecimal.TEN)
                                 .build();
    }

    public static ProductRequestDto getProductRequestDto() {
        return ProductRequestDto.builder()
                                 .denomination("denomination")
                                 .brand("brand")
                                 .quantity(1000L)
                                 .unitPrice(BigDecimal.TEN)
                                 .build();
    }

    public static CustomerResponseDto getCustomerDto() {
        return CustomerResponseDto.builder()
                                  .id(String.valueOf(UUID.randomUUID()))
                                  .firstName("firstname")
                                  .lastName("lastname")
                                  .email("email@test.com")
                                  .active(Boolean.TRUE)
                                  .addresses(List.of(getAddressDto()))
                                  .build();
    }

    public static AddressRequestDto getAddressDto() {
        return AddressRequestDto.builder()
                                .street("street")
                                .number("12345")
                                .city("city")
                                .build();
    }

    public static CustomerCreationRequestDto getCustomerCreationRequestDto() {
        return CustomerCreationRequestDto.builder()
                .firstName("firstname")
                .lastName("lastname")
                .email("email@test.com")
                .password("password")
                .addresses(List.of(getAddressDto()))
                .products(List.of(getProductRequestDto()))
                .build();
    }

    public static Customer getCustomerWithId() {
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstName("firstname")
                .lastName("lastname")
                .email("email@test.com")
                .password("password")
                .addresses(List.of(getAddress()))
                .build();
    }

    public static Address getAddress() {
        return Address.builder()
                .street("street")
                .number("12345")
                .city("city")
                .build();
    }

    public static CustomerUpdateRequestDto getCustomerUpdateRequestDto() {
        return CustomerUpdateRequestDto.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .firstName("firstname")
                .lastName("lastname")
                .email("email@test.com")
                .password("password")
                .build();
    }

}
