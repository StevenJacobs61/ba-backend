package com.blockarch.blockarch.model.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProjectIndustryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userProjectId;
    private Boolean finance;
    private Boolean defiNft;
    private Boolean healthcare;
    private Boolean digitalAssets;
    private Boolean intellectualProperty;
    private Boolean educationAndResearch;
    private Boolean insurance;
    private Boolean supplyChain;

    public UserProjectIndustryDTO(){
    }

    public UserProjectIndustryDTO(Long id,
                                  Long userProjectId,
                                  Boolean finance,
                                  Boolean defiNft,
                                  Boolean healthcare,
                                  Boolean digitalAssets,
                                  Boolean intellectualProperty,
                                  Boolean educationAndResearch,
                                  Boolean insurance,
                                  Boolean supplyChain) {
        this.id = id;
        this.userProjectId = userProjectId;
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
