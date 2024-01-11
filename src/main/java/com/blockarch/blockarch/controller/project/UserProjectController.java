package com.blockarch.blockarch.controller.project;

import com.blockarch.blockarch.model.Users;
import com.blockarch.blockarch.model.project.UserProject;
import com.blockarch.blockarch.service.UserProjectService;
import com.blockarch.blockarch.service.calculate.CalculateScoreService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-project")
public class UserProjectController {

//    Logger logger = LoggerFactory.getLogger(UserProjectController.class);

    @Autowired
    private final UserProjectService userProjectService;


    public UserProjectController(UserProjectService userProjectService, CalculateScoreService calculateScoreService) {
        this.userProjectService = userProjectService;
    }

    @PostMapping
    public ResponseEntity<UserProject> createUserProject(@RequestBody UserProject userProject) {
        UserProject newUserProject = userProjectService.createUserProject(userProject);
        return ResponseEntity.ok(newUserProject);
    }

    @GetMapping
    public ResponseEntity<List<UserProject>> getAllUserProjects() {
        List<UserProject> allUserProjects = userProjectService.getAllUserProjects();
        return ResponseEntity.ok(allUserProjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProject> getUserProjectById(@PathVariable Long id) {
       UserProject userProject = userProjectService.getUserProjectById(id);
        return ResponseEntity.ok(userProject);
    }
    @PostMapping("/projects")
    public ResponseEntity<List<UserProject>> getUserProjectsByUserId(@RequestBody Users user){
        List<UserProject> userProjects = userProjectService.getUserProjectsByUserId(user);
        return ResponseEntity.ok(userProjects);
    }

    @PutMapping("/{id}")
    public UserProject updateUserProject(@PathVariable Long id, @RequestBody UserProject updatedFields) {
        return userProjectService.updateUserProject(id, updatedFields);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProject(@PathVariable Long id) {
        userProjectService.deleteUserProject(id);
    }
}
