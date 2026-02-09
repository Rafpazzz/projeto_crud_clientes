package Rafael.projeto_crud_clientes.controller.User;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
@RequiredArgsConstructor
public class UserController_RoleUser {
    private final UsersService usersService;

    @PutMapping("/credenciais")
    public ResponseEntity<Void> atualizarCadastro(@RequestParam Integer id, @RequestBody Users user) {
        usersService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }
}
