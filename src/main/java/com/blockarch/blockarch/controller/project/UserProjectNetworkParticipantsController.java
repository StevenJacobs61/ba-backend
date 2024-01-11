package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.model.project.UserProjectNetworkParticipantsDTO;
import com.blockarch.blockarch.service.blockTwo.UserProjectNetworkParticipantsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project-network-participants")
public class UserProjectNetworkParticipantsController {

    private final UserProjectNetworkParticipantsService userProjectNetworkParticipantsService;

    public UserProjectNetworkParticipantsController(UserProjectNetworkParticipantsService userProjectNetworkParticipantsService) {
        this.userProjectNetworkParticipantsService = userProjectNetworkParticipantsService;
    }

    @GetMapping
    public ResponseEntity <List<UserProjectNetworkParticipantsDTO>> getAllUserProjectIndustries() {
        return ResponseEntity.ok(this.userProjectNetworkParticipantsService.getAllUserProjectNetworkParticipants());
    }

    @PostMapping
    public ResponseEntity<UserProjectNetworkParticipantsDTO> createUserProjectNetworkParticipants(@RequestBody UserProjectNetworkParticipantsDTO userProjectNetworkParticipantsDTO) {
        UserProjectNetworkParticipantsDTO newUserProjectNetworkParticipantsDTO = userProjectNetworkParticipantsService.createUserProjectNetworkParticipants(userProjectNetworkParticipantsDTO);
        return ResponseEntity.ok(newUserProjectNetworkParticipantsDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserProjectNetworkParticipantsDTO> getUserProjectNetworkParticipantsById(@PathVariable Long id) {
        UserProjectNetworkParticipantsDTO userProjectNetworkParticipantsDTO = userProjectNetworkParticipantsService.getUserProjectNetworkParticipantsById(id);
        return ResponseEntity.ok(userProjectNetworkParticipantsDTO);
    }

    @PutMapping("/{id}")
    public UserProjectNetworkParticipantsDTO updateUserProjectNetworkParticipants(@PathVariable Long id, @RequestBody UserProjectNetworkParticipantsDTO updatedFields) {
        return userProjectNetworkParticipantsService.updateUserProjectNetworkParticipants(id, updatedFields);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProjectNetworkParticipants(@PathVariable Long id) {
        userProjectNetworkParticipantsService.deleteUserProjectNetworkParticipants(id);
    }
}
