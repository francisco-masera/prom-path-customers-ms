package org.dargor.customer.core.util.mapper;

import org.dargor.customer.app.dto.AddressDto;
import org.dargor.customer.app.dto.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.CustomerDto;
import org.dargor.customer.app.dto.CustomerUpdateRequestDto;
import org.dargor.customer.core.entity.Address;
import org.dargor.customer.core.entity.Customer;
import org.dargor.customer.core.util.EncoderUtil;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    default Customer customerCreationRequestToCustomer(CustomerCreationRequestDto customerCreationRequestDto) {
        var customer = Customer.builder()
                .email(customerCreationRequestDto.getEmail())
                .active(Boolean.TRUE)
                .firstName(customerCreationRequestDto.getFirstName())
                .lastName(customerCreationRequestDto.getLastName())
                .password(EncoderUtil.passwordEncoder(customerCreationRequestDto.getPassword()))
                .build();
        customer.setAddresses(addressDtoListToAddresses(customerCreationRequestDto.getAddresses(), customer));
        return customer;

    }

    @Named("addressDtoListToAddresses")
    default List<Address> addressDtoListToAddresses(List<AddressDto> addresses, Customer customer) {
        return addresses
                .stream()
                .map(addressDto -> Address.builder()
                        .city(addressDto.getCity())
                        .number(addressDto.getNumber())
                        .street(addressDto.getStreet())
                        .customer(customer)
                        .build())
                .collect(Collectors.toList());
    }

    @Named("addressDtoListToAddresses")
    @IterableMapping(qualifiedByName = "addressDtoToAddress")
    List<Address> addressDtoListToAddresses(List<AddressDto> addresses);

    @Named("addressDtoToAddress")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Address addressDtoToAddress(AddressDto addressDto);

    CustomerDto customerToCustomerDto(Customer customer);

    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "addressDtoListToAddresses")
    @Mapping(target = "password", expression = "java(org.dargor.customer.core.util.EncoderUtil.passwordEncoder(customerUpdateRequest.getPassword()))")
    Customer customerUpdateRequestToCustomer(CustomerUpdateRequestDto customerUpdateRequest);

}
