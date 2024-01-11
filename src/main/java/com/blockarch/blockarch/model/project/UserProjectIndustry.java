package com.blockarch.blockarch.model.project;

import com.blockarch.blockarch.model.project.UserProject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class UserProjectIndustry {

//    @Override
//    public String toString() {
//        return "UserProjectIndustry{" +
//                "id=" + id +
//                ", userProject=" + userProject +
//                ", finance=" + finance +
//                ", defiNft=" + defiNft +
//                ", healthcare=" + healthcare +
//                ", digitalAssets=" + digitalAssets +
//                ", intellectualProperty=" + intellectualProperty +
//                ", educationAndResearch=" + educationAndResearch +
//                ", insurance=" + insurance +
//                ", supplyChain=" + supplyChain +
//                '}';
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    public UserProject userProject;

    private Boolean finance;
    private Boolean defiNft;
    private Boolean healthcare;
    private Boolean digitalAssets;
    private Boolean intellectualProperty;
    private Boolean educationAndResearch;
    private Boolean insurance;
    private Boolean supplyChain;

    public UserProjectIndustry() {
    }

    public UserProjectIndustry(Long id,
                               UserProject userProject,
                               Boolean finance,
                               Boolean defiNft,
                               Boolean healthcare,
                               Boolean digitalAssets,
                               Boolean intellectualProperty,
                               Boolean educationAndResearch,
                               Boolean insurance,
                               Boolean supplyChain
    ) {
        this.id = id;
        this.userProject = userProject;
        this.finance = finance;
        this.defiNft = defiNft;
        this.healthcare = healthcare;
        this.digitalAssets = digitalAssets;
        this.intellectualProperty = intellectualProperty;
        this.educationAndResearch = educationAndResearch;
        this.insurance = insurance;
        this.supplyChain = supplyChain;
    }
}


