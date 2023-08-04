package org.dargor.customer.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerCreationRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    private String password;

    private List<AddressDto> addresses;

    private List<ProductDto> products;

}
