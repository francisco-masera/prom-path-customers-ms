package org.dargor.customer.app.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishListRequestDto {

    @NotBlank
    private String customerId;

    private List<ProductRequestDto> products;

}
