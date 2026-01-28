package henrico.tasks.adapters.out.jpa.persistence.entity;

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
@Table(name = "task_group")
public class TaskGroupDbContext {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskDbContext> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDbContext user;

}
