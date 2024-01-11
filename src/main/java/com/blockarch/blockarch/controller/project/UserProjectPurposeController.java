package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.model.project.UserProjectPurposeDTO;
import com.blockarch.blockarch.service.blockOne.UserProjectPurposeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project-purpose")
public class UserProjectPurposeController {

    private final UserProjectPurposeService userProjectPurposeService;

    public UserProjectPurposeController(UserProjectPurposeService userProjectPurposeService) {
        this.userProjectPurposeService = userProjectPurposeService;
    }

    @GetMapping
    public ResponseEntity<List<UserProjectPurposeDTO>> getAllUserProjectPurposes() {
        return ResponseEntity.ok(this.userProjectPurposeService.getAllUserProjectPurposes());
    }

    @PostMapping
    public ResponseEntity<UserProjectPurposeDTO> createUserProjectPurpose(@RequestBody UserProjectPurposeDTO userProjectPurposeDTO) {
        UserProjectPurposeDTO newUserProjectPurposeDTO = userProjectPurposeService.createUserProjectPurpose(userProjectPurposeDTO);
        return ResponseEntity.ok(newUserProjectPurposeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProjectPurposeDTO> getUserProjectPurposeById(@PathVariable Long id) {
        UserProjectPurposeDTO userProjectPurposeDTO = userProjectPurposeService.getUserProjectPurposeById(id);
        return ResponseEntity.ok(userProjectPurposeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProjectPurposeDTO> updateUserProjectPurpose(@PathVariable Long id, @RequestBody UserProjectPurposeDTO updatedFields) {
        UserProjectPurposeDTO updatedUserProjectPurposeDTO = userProjectPurposeService.updateUserProjectPurpose(id, updatedFields);
        return ResponseEntity.ok(updatedUserProjectPurposeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProjectPurpose(@PathVariable Long id) {
        userProjectPurposeService.deleteUserProjectPurpose(id);
    }
}
