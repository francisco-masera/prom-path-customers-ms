package org.dargor.customer.core.util.mapper;

import org.dargor.customer.app.dto.CustomerDto;
import org.dargor.customer.app.dto.ProductDto;
import org.dargor.customer.app.dto.WishListRequestDto;
import org.dargor.customer.app.dto.WishListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    WishListRequestDto toWishListRequestDto(UUID customerId, List<ProductDto> products);


    default WishListResponseDto toWishListResponseDto(WishListResponseDto wishList, CustomerDto customerDto) {

        return WishListResponseDto.builder()
                .products(wishList.getProducts())
                .customer(customerDto)
                .build();

    }

}
