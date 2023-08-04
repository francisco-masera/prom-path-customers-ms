package org.dargor.customer.app.util;

import org.dargor.customer.app.dto.*;
import org.dargor.customer.core.entity.Address;
import org.dargor.customer.core.entity.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MockedTestData {

    public static WishListDto getWishListDto() {
        return WishListDto.builder()
                .customer(getCustomerDto())
                .products(List.of(getProductDto()))
                .build();
    }

    public static ProductDto getProductDto() {
        return ProductDto.builder()
                .denomination("denomination")
                .brand("brand")
                .quantity(1000L)
                .unitPrice(BigDecimal.TEN)
                .build();
    }

    public static CustomerDto getCustomerDto() {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .firstName("firstname")
                .lastName("lastname")
                .email("email@test.com")
                .active(Boolean.TRUE)
                .addresses(List.of(getAddressDto()))
                .build();
    }

    public static AddressDto getAddressDto() {
        return AddressDto.builder()
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
                .products(List.of(getProductDto()))
                .build();
    }

    public static Customer getCustomerWithId() {
        return Customer.builder()
                .id(UUID.randomUUID())
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

    public static CustomerUpdateRequestDto getCustomerUpdateRequestDto(){
        return CustomerUpdateRequestDto.builder()
                .id(UUID.randomUUID())
                .firstName("firstname")
                .lastName("lastname")
                .email("email@test.com")
                .password("password")
                .build();
    }

}
