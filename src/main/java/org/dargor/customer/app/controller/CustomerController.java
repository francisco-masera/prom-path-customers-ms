package org.dargor.customer.app.controller;

import org.dargor.customer.app.dto.request.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.request.CustomerUpdateRequestDto;
import org.dargor.customer.app.dto.response.CustomerResponseDto;
import org.dargor.customer.app.dto.response.WishListResponseDto;
import org.dargor.customer.app.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WishListResponseDto> createCustomer(@RequestBody @Valid CustomerCreationRequestDto request) {
        var response = customerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable String customerId) {
        var response = customerService.getCustomer(customerId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponseDto> updateCustomer(@RequestBody @Valid CustomerUpdateRequestDto request) {
        var response = customerService.updateCustomer(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/wish-list/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WishListResponseDto> getWishList(@PathVariable String customerId) {
        var response = customerService.getWishList(customerId);
        return ResponseEntity.ok(response);
    }

}
