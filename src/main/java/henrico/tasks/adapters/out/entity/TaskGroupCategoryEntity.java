package henrico.tasks.adapters.out.entity;

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
@Table(name = "task_group_category")
public class TaskGroupCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<TaskGroupEntity> taskGroupEntities;

}
