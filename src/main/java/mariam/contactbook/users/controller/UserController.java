package mariam.contactbook.users.controller;

import mariam.contactbook.users.model.UserRequest;
import mariam.contactbook.users.model.Users;
import mariam.contactbook.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    private ResponseEntity<Users> createUser(@RequestBody UserRequest request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }
    @GetMapping
    private ResponseEntity<List<Users>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/get/{email}")
    private ResponseEntity<Optional<Users>> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/get/{name}")
    private ResponseEntity<Optional<Users>> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }
    @PutMapping("/update")
    private ResponseEntity<Users> updateUser(@RequestBody UserRequest request, @RequestParam String username){
        return new ResponseEntity<>(userService.updateUser(request, username), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    private ResponseEntity<Void> deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
