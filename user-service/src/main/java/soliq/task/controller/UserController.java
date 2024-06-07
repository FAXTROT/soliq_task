package soliq.task.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soliq.task.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping(value = "/{passportNumber}")
    public ResponseEntity readUser(@PathVariable("passportNumber") String passportNumber) {
        return ResponseEntity.ok(userService.getByPassportNumber(passportNumber));
    }
    
}
