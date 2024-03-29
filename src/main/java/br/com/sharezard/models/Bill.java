package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("bills")
public class Bill implements Balance<Bill>{

    @Id
    @Column("id")
    private UUID id;

    @Column("title")
    private String title;

    @Column("amount")
    private long amount;

    @Column("owner_id")
    private UUID ownerId;

    @Column("group_id")
    private Group groupId;

    private LocalDateTime createdAt;

    @Override
    public Bill value() {
        return this;
    }
}
