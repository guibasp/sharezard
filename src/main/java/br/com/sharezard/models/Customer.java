package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("customers")
public class Customer {

    @Id
    @Column("id")
    private UUID customerId;

    @Column("name")
    private String name;

    @Column("nick_name")
    private String nickName;

    @Column("profile_url")
    private String profile;

    @Column("created_at")
    private LocalDateTime createdAt;

}
