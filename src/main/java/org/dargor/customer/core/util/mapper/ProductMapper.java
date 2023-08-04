package org.dargor.customer.core.util.mapper;

import org.dargor.customer.app.dto.CustomerDto;
import org.dargor.customer.app.dto.ProductDto;
import org.dargor.customer.app.dto.WishListDto;
import org.dargor.customer.core.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    WishListDto toWishListDto(CustomerDto customer, List<ProductDto> products);

    WishListDto toWishListDto(Customer customer, List<ProductDto> products);


}
