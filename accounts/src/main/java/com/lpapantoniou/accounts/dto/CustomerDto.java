package com.lpapantoniou.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Customer",
        description = "Customer details schema"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "John Doe"
    )
    @NotEmpty(message = "Name is required")
    @Size(min = 5, max = 30, message = "Name must be between 5 and 30 characters")
    private String name;


    @Schema(
            description = "Email of the customer",
            example = "Tqf5y@example.com"
    )
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "6987654321"
    )
    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountDto accountDto;
}

