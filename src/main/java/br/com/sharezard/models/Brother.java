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
@Table("brothers")
public class Brother {

    @Id
    @Column("id")
    private UUID brotherId;

    @Column("name")
    private String name;

    @Column("nick_name")
    private String nickName;

    @Column("profile_url")
    private String profile;

    public boolean isLegalAge () {
        return true;
    }
}
