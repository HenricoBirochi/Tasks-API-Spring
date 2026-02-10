package henrico.tasks.adapters.out.jpa.entity;

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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer coins;

    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = "image_id", nullable = true)
    private ImageEntity image;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskTagEntity> taskTags;

}
