package dev.syntax.backend.profile.controller;


import dev.syntax.backend.profile.dto.response.ProfileResponse;
import dev.syntax.backend.profile.model.User;
import dev.syntax.backend.profile.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<ProfileResponse> showUserProfile(@PathVariable Long id){
        System.out.println(id + "의 아이디 값을 조회합니다");
        User user = profileService.findById(id);
        return new ResponseEntity<>(ProfileResponse.profileInfoFrom(user), HttpStatus.OK);
    }



}
