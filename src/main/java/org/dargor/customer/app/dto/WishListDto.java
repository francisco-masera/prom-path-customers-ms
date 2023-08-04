package org.dargor.customer.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {

    private CustomerDto customer;

    private List<ProductDto> products;

}
