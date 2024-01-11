package com.blockarch.blockarch.repository.dlt;

import com.blockarch.blockarch.model.dlt.DltSolutionPurpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DltSolutionPurposeRepository extends JpaRepository<DltSolutionPurpose, Long> {
}
