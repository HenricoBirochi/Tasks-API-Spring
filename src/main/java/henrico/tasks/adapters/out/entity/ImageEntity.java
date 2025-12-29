package henrico.tasks.adapters.out.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String imagePath;

    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

}
