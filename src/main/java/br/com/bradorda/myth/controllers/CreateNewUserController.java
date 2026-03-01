package br.com.bradorda.myth.controllers;

import br.com.bradorda.myth.dtos.request.RegisterUserRequest;
import br.com.bradorda.myth.dtos.response.RegisterUserResponse;
import br.com.bradorda.myth.services.CreateNewUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create-new-user")
public class CreateNewUserController {

    private final CreateNewUserService createNewUserService;

    @Autowired
    public CreateNewUserController(CreateNewUserService createNewUserService) {
        this.createNewUserService = createNewUserService;
    }

    @PostMapping
    public ResponseEntity<RegisterUserResponse> createNewUser(@Valid @RequestBody RegisterUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createNewUserService.createNewUser(request));
    }
}
