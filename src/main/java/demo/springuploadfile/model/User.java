package demo.springuploadfile.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;

    @ManyToMany(mappedBy = "sharedUsers", fetch = FetchType.EAGER)
    private List<Task> sharedTasks;
}
