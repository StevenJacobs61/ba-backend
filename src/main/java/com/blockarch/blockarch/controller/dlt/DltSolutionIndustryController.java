package com.blockarch.blockarch.controller.dlt;

import com.blockarch.blockarch.repository.dlt.DltSolutionIndustryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dlt-solution-industry") // Adjust the mapping to your preference
public class DltSolutionIndustryController {

    private final DltSolutionIndustryRepository dltSolutionIndustryRepository;

    public DltSolutionIndustryController(DltSolutionIndustryRepository dltSolutionIndustryRepository) {
        this.dltSolutionIndustryRepository = dltSolutionIndustryRepository;
    }

    @GetMapping
    public ResponseEntity getAllDltSolutionIndustries() {
        return ResponseEntity.ok(this.dltSolutionIndustryRepository.findAll());
    }

    // Add more endpoints for specific operations (create, update, delete, etc.) as needed
}
