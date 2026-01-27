package Rafael.projeto_crud_clientes.controller;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save-user")
    public ResponseEntity<Void> saveUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-User-id")
    public ResponseEntity<Users> findUserId(@RequestParam Integer indent) {
        return ResponseEntity.ok(usersService.findById(indent));
    }

    @PutMapping("/update-user")
    public ResponseEntity<Void> upadateUser(@RequestParam Integer id, @RequestBody Users user) {
        usersService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<Void> deleteById(@RequestParam Integer id) {
        usersService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
