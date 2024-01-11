package com.blockarch.blockarch.controller.dlt;

import com.blockarch.blockarch.model.dlt.DltSolutionPurpose;
import com.blockarch.blockarch.service.blockOne.DltSolutionPurposeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dlt-solution-purpose")
public class DltSolutionPurposeController {

    private final DltSolutionPurposeService dltSolutionPurposeService;

    public DltSolutionPurposeController(DltSolutionPurposeService dltSolutionPurposeService) {
        this.dltSolutionPurposeService = dltSolutionPurposeService;
    }

    @GetMapping
    public ResponseEntity <List<DltSolutionPurpose>> getAllUserProjectIndustries() {
        return ResponseEntity.ok(this.dltSolutionPurposeService.getAllDltSolutionPurpose());
    }

    @PostMapping
    public ResponseEntity<DltSolutionPurpose> createDltSolutionPurpose(@RequestBody DltSolutionPurpose dltSolutionPurpose) {
        DltSolutionPurpose newDltSolutionPurpose = dltSolutionPurposeService.createDltSolutionPurpose(dltSolutionPurpose);
        return ResponseEntity.ok(newDltSolutionPurpose);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DltSolutionPurpose> getDltSolutionPurposeById(@PathVariable Long id) {
        DltSolutionPurpose dltSolutionPurpose = dltSolutionPurposeService.getDltSolutionPurposeById(id);
        return ResponseEntity.ok(dltSolutionPurpose);
    }

    @PutMapping("/{id}")
    public DltSolutionPurpose updateDltSolutionPurpose(@PathVariable Long id, @RequestBody DltSolutionPurpose updatedFields) {
        return dltSolutionPurposeService.updateDltSolutionPurpose(id, updatedFields);
    }

    @DeleteMapping("/{id}")
    public void deleteDltSolutionPurpose(@PathVariable Long id) {
        dltSolutionPurposeService.deleteDltSolutionPurpose(id);
    }
}
