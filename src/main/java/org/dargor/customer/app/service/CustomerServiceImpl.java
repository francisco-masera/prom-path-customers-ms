package org.dargor.customer.app.service;

import java.util.List;

import org.dargor.customer.app.client.ProductClient;
import org.dargor.customer.app.dto.request.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.request.CustomerUpdateRequestDto;
import org.dargor.customer.app.dto.request.WishListRequestDto;
import org.dargor.customer.app.dto.response.CustomerResponseDto;
import org.dargor.customer.app.dto.response.ProductResponseDto;
import org.dargor.customer.app.dto.response.WishListResponseDto;
import org.dargor.customer.app.exception.CustomException;
import org.dargor.customer.app.exception.ErrorDefinition;
import org.dargor.customer.core.entity.Customer;
import org.dargor.customer.core.repository.CustomerRepository;
import org.dargor.customer.core.util.mapper.CustomerMapper;
import org.dargor.customer.core.util.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private static final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final CustomerRepository customerRepository;
    private final ProductClient productClient;

    @Override
    public WishListResponseDto createCustomer(CustomerCreationRequestDto request) {
        try {
            Customer customer = customerMapper.customerCreationRequestToCustomer(request);
            Customer savedCustomer = customerRepository.save(customer);
            CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerDto(savedCustomer);
            WishListRequestDto wishListRequest = productMapper.toWishListRequestDto(customer.getId(), request.getProducts());
            List<ProductResponseDto> products = productClient.createProducts(wishListRequest);
            return productMapper.toWishListResponseDto(products, customerResponseDto);
        } catch (Exception e) {
            log.error("Error found creating customer [request: {}] [error: {}]", request.toString(), e.getMessage());
            throw new CustomException(ErrorDefinition.UNKNOWN_ERROR);
        }
    }

    @Override
    public CustomerResponseDto getCustomer(String customerId) {
        try {
            if (ObjectUtils.isEmpty(customerId)) {
                throw new CustomException(ErrorDefinition.INVALID_INPUT_DATA);
            }
            Customer customer = customerRepository.getReferenceById(customerId);
            return customerMapper.customerToCustomerDto(customer);
        } catch (CustomException e) {
            log.error("Error found fetching customer [customerId: {}] [error: {}]", customerId, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("System error found fetching customer [customerId: {}] [error: {}]", customerId, e.getMessage());
            throw new CustomException(ErrorDefinition.UNKNOWN_ERROR);
        }
    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerUpdateRequestDto request) {
        try {
            Customer customer = customerMapper.customerUpdateRequestToCustomer(request);
            Customer updatedCustomer = customerRepository.save(customer);
            return customerMapper.customerToCustomerDto(updatedCustomer);
        } catch (Exception e) {
            log.error("System error found updating customer [request: {}] [error: {}]", request.toString(), e.getMessage());
            throw new CustomException(ErrorDefinition.UNKNOWN_ERROR);
        }
    }

    public WishListResponseDto getWishList(String customerId) {
        try {
            if (ObjectUtils.isEmpty(customerId)) {
                throw new CustomException(ErrorDefinition.INVALID_INPUT_DATA);
            }
            List<ProductResponseDto> wishList = productClient.getWishList(customerId);
            Customer customer = customerRepository.getReferenceById(customerId);
            CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerDto(customer);
            return productMapper.toWishListResponseDto(wishList, customerResponseDto);
        } catch (CustomException e) {
            log.error("Error found getting customer products [customerId: {}] [error: {}]", customerId, e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("System error found getting customer products [id: {}] [error: {}]", customerId, e.getMessage());
            throw new CustomException(ErrorDefinition.UNKNOWN_ERROR);
        }
    }


}
