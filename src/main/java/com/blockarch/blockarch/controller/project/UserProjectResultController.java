package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.repository.project.UserProjectResultRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-project-result") // Adjust the mapping to your preference
public class UserProjectResultController {

    private final UserProjectResultRepository userProjectResultRepository;

    public UserProjectResultController(UserProjectResultRepository userProjectResultRepository) {
        this.userProjectResultRepository = userProjectResultRepository;
    }

    @GetMapping
    public ResponseEntity getAllUserProjectResults() {
        return ResponseEntity.ok(this.userProjectResultRepository.findAll());
    }

    // Add more endpoints for specific operations (create, update, delete, etc.) as needed
}
