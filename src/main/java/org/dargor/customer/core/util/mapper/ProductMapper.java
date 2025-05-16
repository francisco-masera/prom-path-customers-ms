package org.dargor.customer.core.util.mapper;

import java.util.List;

import org.dargor.customer.app.dto.request.ProductRequestDto;
import org.dargor.customer.app.dto.request.WishListRequestDto;
import org.dargor.customer.app.dto.response.CustomerResponseDto;
import org.dargor.customer.app.dto.response.ProductResponseDto;
import org.dargor.customer.app.dto.response.WishListResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    WishListRequestDto toWishListRequestDto(String customerId, List<ProductRequestDto> products);

    default WishListResponseDto toWishListResponseDto(List<ProductResponseDto> wishList, CustomerResponseDto customerResponseDto) {

        return WishListResponseDto.builder().products(wishList).customer(customerResponseDto)
                .build();

    }

}
