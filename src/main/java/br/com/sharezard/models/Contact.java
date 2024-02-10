package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("contacts")
public class Contact {

    @Id
    @Column("id")
    private UUID contactId;

    @Column("contact")
    private String contact;

    @Column("brother_id")
    private UUID brotherId;

    @Column("type")
    private ContactType contactType;
}
