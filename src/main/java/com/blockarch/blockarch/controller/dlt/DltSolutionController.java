package com.blockarch.blockarch.controller.dlt;

import com.blockarch.blockarch.repository.dlt.DltSolutionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dlt-solution")
public class DltSolutionController {

    private final DltSolutionRepository dltSolutionRepository;

    public DltSolutionController(DltSolutionRepository dltSolutionRepository) {
        this.dltSolutionRepository = dltSolutionRepository;
    }

    @GetMapping
    public ResponseEntity getAllDltSolutions() {
        return ResponseEntity.ok(this.dltSolutionRepository.findAll());
    }

    // Add more endpoints for specific operations (create, update, delete, etc.) as needed
}
