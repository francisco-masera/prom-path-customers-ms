package org.dargor.customer.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListResponseDto {

    private CustomerResponseDto customer;

    private List<ProductResponseDto> products;

}
