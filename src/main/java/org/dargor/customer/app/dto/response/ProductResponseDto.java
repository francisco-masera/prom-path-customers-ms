package org.dargor.customer.app.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private String denomination;

    private String brand;

    private Long quantity;

    private BigDecimal unitPrice;

}
