package br.com.sharezard.wire.in;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID customerId;
    private String name, nickName, profile;
    private LocalDateTime createdAt;

}
