package br.com.sharezard.models;

import br.com.sharezard.exceptions.ConflictException;
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

    private int age;

    public void validateLegalPerson () {
        if (age < 18)
            throw new ConflictException("O parca ai tem que ser de maior");
    }
}
