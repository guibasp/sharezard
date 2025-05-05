package br.com.sharezard.wire.out;

import lombok.*;

import java.util.UUID;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private UUID id;
    private String name, nickName;

}
