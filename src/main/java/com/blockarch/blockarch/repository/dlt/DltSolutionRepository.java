package com.blockarch.blockarch.repository.dlt;

import com.blockarch.blockarch.model.dlt.DltSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DltSolutionRepository extends JpaRepository<DltSolution, Long> {
}
