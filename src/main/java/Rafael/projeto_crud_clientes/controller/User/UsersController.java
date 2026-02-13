package Rafael.projeto_crud_clientes.controller.User;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save-user")
    public ResponseEntity<Void> saveUser(@RequestBody Users user) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        Users newUser = user;
        newUser.setPassword(encryptedPassword);
        usersService.saveUser(newUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Users> findUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(usersService.findById(id));
    }

    @GetMapping("/find_all_users")
    public ResponseEntity<List<Users>> findAllUsers() {
        return ResponseEntity.ok(usersService.findAllUsers());
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<Void> upadateUser(@PathVariable Integer id, @RequestBody Users user) {
        usersService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        usersService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
