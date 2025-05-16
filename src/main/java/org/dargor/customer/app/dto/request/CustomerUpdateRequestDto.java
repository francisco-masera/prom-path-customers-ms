package org.dargor.customer.app.dto.request;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequestDto {

    @NotBlank
    private String id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    private Boolean active;

    private List<AddressRequestDto> addresses;

}
