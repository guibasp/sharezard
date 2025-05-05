package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("wallets")
public class Wallet {

    @Id
    @Column("id")
    private UUID id;
    private UUID customerId;
    private String name;

}
