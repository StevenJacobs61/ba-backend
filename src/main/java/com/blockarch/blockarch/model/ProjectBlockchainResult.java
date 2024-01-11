package com.blockarch.blockarch.model;

import com.blockarch.blockarch.model.dlt.DltSolution;
import com.blockarch.blockarch.model.project.UserProject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProjectBlockchainResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_project_id")
    private UserProject user_project_id;

    @ManyToOne
    @JoinColumn(name = "dlt_solution_id")
    public DltSolution dlt_solution_id;

    private LocalDateTime created_date_time;
    private Integer block_1_score;
    private Integer block_2_score;
    private Integer block_3_score;
    private Integer block_4_score;
    private Integer block_5_score;
    private Integer block_6_score;
    private Integer block_7_score;


    public String toString(){
        return "ProjectBlockchainResult: {" +
                "Id:" + id + ", " +
                "DltSolutionId:" + dlt_solution_id + ", " +
                "UserProjectId:" + user_project_id + ", " +
                "CreatedAtTimeDate:" + created_date_time + ", " +
                "BlockScore1:" + block_1_score + ", " +
                "BlockScore2:" + block_2_score + ", " +
                "BlockScore3:" + block_3_score + ", " +
                "BlockScore4:" + block_4_score + ", " +
                "BlockScore5:" + block_5_score + ", " +
                "BlockScore6:" + block_6_score + ", " +
                "BlockScore7:" + block_7_score + ", " +
                "}";

    }

    public void updateBlockScore (int block, int value){
        switch (block) {
            case 1 -> this.block_1_score += value;
            case 2 -> this.block_2_score += value;
            case 3 -> this.block_3_score += value;
            case 4 -> this.block_4_score += value;
            case 5 -> this.block_5_score += value;
            case 6 -> this.block_6_score += value;
            case 7 -> this.block_7_score += value;
        }
    }
    public ProjectBlockchainResult() {
    }

    public ProjectBlockchainResult(UserProject user_project_id,
                                   DltSolution dlt_solution_id,
                                   LocalDateTime created_date_time,
                                   Integer block_1_score,
                                   Integer block_2_score,
                                   Integer block_3_score,
                                   Integer block_4_score,
                                   Integer block_5_score,
                                   Integer block_6_score,
                                   Integer block_7_score
                                  ) {
        this.user_project_id = user_project_id;
        this.dlt_solution_id = dlt_solution_id;
        this.created_date_time = created_date_time;
        this.block_1_score = block_1_score;
        this.block_2_score = block_2_score;
        this.block_3_score = block_3_score;
        this.block_4_score = block_4_score;
        this.block_5_score = block_5_score;
        this.block_6_score = block_6_score;
        this.block_7_score = block_7_score;
    }
}
