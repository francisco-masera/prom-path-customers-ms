package org.dargor.customer.app.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String denomination;

    private String brand;

    private Long quantity;

    private BigDecimal unitPrice;

}
