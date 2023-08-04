package org.dargor.customer.core.util.mapper;

import org.dargor.customer.app.dto.AddressDto;
import org.dargor.customer.app.dto.CustomerCreationRequestDto;
import org.dargor.customer.app.dto.CustomerDto;
import org.dargor.customer.app.dto.CustomerUpdateRequestDto;
import org.dargor.customer.core.entity.Address;
import org.dargor.customer.core.entity.Customer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", expression = "java(true)")
    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "addressDtoListToAddresses")
    Customer customerCreationRequestToCustomer(CustomerCreationRequestDto customerCreationRequest);

    @Named("addressDtoListToAddresses")
    @IterableMapping(qualifiedByName = "addressDtoToAddress")
    List<Address> addressDtoListToAddresses(List<AddressDto> addresses);

    @Named("addressDtoToAddress")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Address addressDtoToAddress(AddressDto address);

    CustomerDto customerToCustomerResponse(Customer customer);

    @Mapping(target = "addresses", source = "addresses", qualifiedByName = "addressDtoListToAddresses")
    Customer customerUpdateRequestToCustomer(CustomerUpdateRequestDto customerUpdateRequest);

}
