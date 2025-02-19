package com.lpapantoniou.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Account",
        description = "Account details of the customer"
)
public class AccountDto {

    @Schema(
            name = "Account number"
    )
    @NotEmpty(message = "Account number is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    @NotEmpty(message = "Account type is required")
    private String accountType;

    @Schema(
            description = "Branch address of the customer",
            example = "123 Main Street, New York"
    )
    @NotEmpty(message = "Branch address is required")
    private String branchAddress;
}
