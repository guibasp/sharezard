package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("bills")
public class Bill {

    @Id
    @Column("id")
    private Long id;

    @Column("title")
    private String title;

    @Column("price")
    private long price;

    @Column("owner_id")
    private Brother onwer;

    private List<Brother> brothers;

}
