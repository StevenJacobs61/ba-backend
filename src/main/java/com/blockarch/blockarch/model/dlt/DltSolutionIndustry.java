package com.blockarch.blockarch.model.dlt;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DltSolutionIndustry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private DltSolution dltSolutionId;

    private Integer finance;

    private Integer supplyChain;
    private Integer defiNft;
    private Integer healthcare;
    private Integer digitalAssets;
    private Integer intellectualProperty;
    private Integer educationAndResearch;
    private Integer insurance;

    public DltSolutionIndustry() {
    }

    public DltSolutionIndustry(DltSolution dltSolutionId,
                               Integer finance,
                               Integer supplyChain,
                               Integer defiNft,
                               Integer healthcare,
                               Integer digitalAssets,
                               Integer intellectualProperty,
                               Integer educationAndResearch,
                               Integer insurance) {
        this.dltSolutionId = dltSolutionId;
        this.finance = finance;
        this.supplyChain = supplyChain;
        this.defiNft = defiNft;
        this.healthcare = healthcare;
        this.digitalAssets = digitalAssets;
        this.intellectualProperty = intellectualProperty;
        this.educationAndResearch = educationAndResearch;
        this.insurance = insurance;
    }

    // Other methods if needed
}
