package org.dargor.customer.app.dto.response;

import java.util.List;

import org.dargor.customer.app.dto.request.AddressRequestDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerResponseDto {

    private String id;

    private String firstName;

    private String lastName;

    @JsonProperty("user")
    private String email;

    private Boolean active;

    private List<AddressRequestDto> addresses;

}
