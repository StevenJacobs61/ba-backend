package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.model.project.UserProjectIndustryDTO;
import com.blockarch.blockarch.service.blockOne.UserProjectIndustryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project-industry")
public class UserProjectIndustryController {

    private final UserProjectIndustryService userProjectIndustryService;

    public UserProjectIndustryController(UserProjectIndustryService userProjectIndustryService) {
        this.userProjectIndustryService = userProjectIndustryService;
    }

    @GetMapping
    public ResponseEntity <List<UserProjectIndustryDTO>> getAllUserProjectIndustries() {
        return ResponseEntity.ok(this.userProjectIndustryService.getAllUserProjectIndustries());
    }

    @PostMapping
    public ResponseEntity<UserProjectIndustryDTO> createUserProjectIndustry(@RequestBody UserProjectIndustryDTO userProjectIndustryDTO) {
        UserProjectIndustryDTO newUserProjectIndustry = userProjectIndustryService.createUserProjectIndustry(userProjectIndustryDTO);
        return ResponseEntity.ok(newUserProjectIndustry);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProjectIndustryDTO> getUserProjectIndustryById(@PathVariable Long id) {
        UserProjectIndustryDTO userProjectIndustry = userProjectIndustryService.getUserProjectIndustryById(id);
        return ResponseEntity.ok(userProjectIndustry);
    }

    @PutMapping("/{id}")
    public UserProjectIndustryDTO updateUserProjectIndustry(@PathVariable Long id, @RequestBody UserProjectIndustryDTO updatedFields) {
        return userProjectIndustryService.updateUserProjectIndustry(id, updatedFields);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProjectIndustry(@PathVariable Long id) {
        userProjectIndustryService.deleteUserProjectIndustry(id);
    }
}
