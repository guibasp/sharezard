package br.com.sharezard.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("papers")
public class Paper {
    @Id
    private String code;
    private String name;
}
