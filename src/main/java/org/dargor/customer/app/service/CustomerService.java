package org.dargor.customer.app.service;

import org.dargor.customer.app.dto.request.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.request.CustomerUpdateRequestDto;
import org.dargor.customer.app.dto.response.CustomerResponseDto;
import org.dargor.customer.app.dto.response.WishListResponseDto;

public interface CustomerService {

    CustomerResponseDto updateCustomer(CustomerUpdateRequestDto customerCreationRequest);

    CustomerResponseDto getCustomer(String customerId);

    WishListResponseDto createCustomer(CustomerCreationRequestDto customerCreationRequest);

    WishListResponseDto getWishList(String customerId);

}
