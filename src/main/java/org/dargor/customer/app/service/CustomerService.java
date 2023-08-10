package org.dargor.customer.app.service;

import org.dargor.customer.app.dto.*;

import java.util.UUID;

public interface CustomerService {


    CustomerDto updateCustomer(CustomerUpdateRequestDto customerCreationRequest);

    CustomerDto getCustomer(UUID customerId);

    WishListResponseDto createCustomer(CustomerCreationRequestDto customerCreationRequest);

    WishListResponseDto getWishList(UUID customerId);

}
