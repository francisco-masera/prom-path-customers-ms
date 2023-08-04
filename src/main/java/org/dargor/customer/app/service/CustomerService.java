package org.dargor.customer.app.service;

import org.dargor.customer.app.dto.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.CustomerDto;
import org.dargor.customer.app.dto.CustomerUpdateRequestDto;
import org.dargor.customer.app.dto.WishListDto;

import java.util.UUID;

public interface CustomerService {


    CustomerDto updateCustomer(CustomerUpdateRequestDto customerCreationRequest);

    CustomerDto getCustomer(UUID customerId);

    WishListDto createCustomer(CustomerCreationRequestDto customerCreationRequest);

    WishListDto getWishList(UUID customerId);

}
