package Rafael.projeto_crud_clientes.controller;


import Rafael.projeto_crud_clientes.entity.User.AuthenticationDTO;
import Rafael.projeto_crud_clientes.entity.User.LoginResposeDTO;
import Rafael.projeto_crud_clientes.entity.User.RegisterDTO;
import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.infra.security.TokenService;
import Rafael.projeto_crud_clientes.repository.UsersRepositiry;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersRepositiry repositiry;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePasseword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePasseword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResposeDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.repositiry.findByEmail(data.email()) !=  null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        Users newUser = new Users(data.email(), encryptedPassword, data.role());
        this.repositiry.save(newUser);

        return ResponseEntity.ok().build();
    }

//    @PostMapping("/create")
//    public ResponseEntity create(@RequestBody @Valid CreateDTO data) {
//
//    }
}
