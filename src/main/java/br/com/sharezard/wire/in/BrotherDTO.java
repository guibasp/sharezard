package br.com.sharezard.wire.in;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrotherDTO {

    private UUID brotherId;
    private String name, nickName, profile;
    private LocalDate createdAt;

}
