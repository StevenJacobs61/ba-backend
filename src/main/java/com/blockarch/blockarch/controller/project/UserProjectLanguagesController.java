package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.model.project.UserProjectLanguagesDTO;
import com.blockarch.blockarch.service.blockOne.UserProjectLanguagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project-languages")
public class UserProjectLanguagesController {

    private final UserProjectLanguagesService userProjectLanguagesService;

    public UserProjectLanguagesController(UserProjectLanguagesService userProjectLanguagesService) {
        this.userProjectLanguagesService = userProjectLanguagesService;
    }

    @GetMapping
    public ResponseEntity <List<UserProjectLanguagesDTO>> getAllUserProjectIndustries() {
        return ResponseEntity.ok(this.userProjectLanguagesService.getAllUserProjectLanguages());
    }

    @PostMapping
    public ResponseEntity<UserProjectLanguagesDTO> createUserProjectLanguages(@RequestBody UserProjectLanguagesDTO userProjectLanguagesDTO) {
        UserProjectLanguagesDTO newUserProjectLanguages = userProjectLanguagesService.createUserProjectLanguages(userProjectLanguagesDTO);
        return ResponseEntity.ok(newUserProjectLanguages);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProjectLanguagesDTO> getUserProjectLanguagesById(@PathVariable Long id) {
        UserProjectLanguagesDTO userProjectLanguagesDTO = userProjectLanguagesService.getUserProjectLanguagesById(id);
        return ResponseEntity.ok(userProjectLanguagesDTO);
    }

    @PutMapping("/{id}")
    public UserProjectLanguagesDTO updateUserProjectLanguages(@PathVariable Long id, @RequestBody UserProjectLanguagesDTO updatedFields) {
        return userProjectLanguagesService.updateUserProjectLanguages(id, updatedFields);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProjectLanguages(@PathVariable Long id) {
        userProjectLanguagesService.deleteUserProjectLanguages(id);
    }
}
