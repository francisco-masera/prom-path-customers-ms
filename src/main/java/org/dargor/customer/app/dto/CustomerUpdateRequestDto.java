package org.dargor.customer.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerUpdateRequestDto {

    @NotNull
    private UUID id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    private boolean active;

    private List<AddressDto> addresses;

}
