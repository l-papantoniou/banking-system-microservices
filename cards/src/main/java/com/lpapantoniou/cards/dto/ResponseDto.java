package com.lpapantoniou.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(
            description = "Status code of the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message of the response"
    )
    private String statusMessage;
}
