package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.project.UserProject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserProjectResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_project_id")
    private UserProject user_project_id;

    private LocalDateTime created_date_time;

    public UserProjectResult() {
    }

    public UserProjectResult(UserProject user_project_id, LocalDateTime created_date_time) {
        this.user_project_id = user_project_id;
        this.created_date_time = created_date_time;
    }

    // Other methods if needed
}
