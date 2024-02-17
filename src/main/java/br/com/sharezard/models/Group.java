package br.com.sharezard.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("groups")
public class Group implements Balance<Group>{

    private List<Brother> brothers;
    @Id
    @Column("id")
    private UUID groupId;
    private String title;

    private String description;
    private LocalDateTime createdAt;

    @Override
    public Group value() {
        return this;
    }
}
