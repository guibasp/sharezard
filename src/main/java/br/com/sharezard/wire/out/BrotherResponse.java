package br.com.sharezard.wire.out;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrotherResponse {

    private UUID id;
    private String name;

}
