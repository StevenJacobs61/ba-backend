package com.blockarch.blockarch.repository.dlt;

import com.blockarch.blockarch.model.dlt.DltSolutionIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DltSolutionIndustryRepository extends JpaRepository<DltSolutionIndustry, Long> {
}
