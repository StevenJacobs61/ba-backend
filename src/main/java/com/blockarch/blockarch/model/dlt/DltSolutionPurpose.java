package com.blockarch.blockarch.model.dlt;

import com.blockarch.blockarch.model.dlt.DltSolution;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DltSolutionPurpose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DltSolution dltSolutionId;

    private Integer business;
    private Integer personal;
    private Integer government;
    private Integer research;

    public DltSolutionPurpose() {
    }

    public DltSolutionPurpose(DltSolution dltSolutionId,
                              Integer business,
                              Integer personal,
                              Integer government,
                              Integer research) {
        this.dltSolutionId = dltSolutionId;
        this.business = business;
        this.personal = personal;
        this.government = government;
        this.research = research;
    }

    // Other methods if needed
}
