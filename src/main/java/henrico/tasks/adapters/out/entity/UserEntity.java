package henrico.tasks.adapters.out.entity;

import henrico.tasks.application.core.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer coins;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageEntity imageEntity;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskGroupEntity> taskGroupEntities;

}
