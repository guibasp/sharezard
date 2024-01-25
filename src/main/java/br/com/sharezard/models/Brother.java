package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("brothers")
public class Brother {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;
}
