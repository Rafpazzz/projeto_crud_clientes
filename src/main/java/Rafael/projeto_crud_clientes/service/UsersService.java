package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.exceptions.*;
import Rafael.projeto_crud_clientes.repository.UsersRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepositiry repositiry;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersRepositiry repositiry) {
        this.repositiry = repositiry;
    }

    public void saveUser(Users user) {
        user.formatCpf(user.getCpf());
        repositiry.saveAndFlush(user);
    }

    public Users findById(Integer id) {
        Users user = repositiry.findById(id).orElseThrow(IdNotFound::new);

        return user;
    }

    public List<Users> findAllUsers() {
        return repositiry.findAll();
    }

    public Users findByCpf(String cpf) {
        return repositiry.findByCpf(cpf).orElseThrow(CpfNotFound::new);
    }

    public void updateUser(Integer id, Users user) {
        Users existingUser = repositiry.findById(id).orElseThrow(UsernameNotFound::new);

        if(user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail())) {
            if(repositiry.existsByEmail(user.getEmail())){
                throw new EmailExistente("O Email: " + user.getEmail()+ " pertence a um outro usuario");
            }

            existingUser.setEmail(user.getEmail());
        }

        if(user.getCpf() != null && !user.getCpf().equals(existingUser.getCpf())) {
            if(repositiry.existsBycpf(user.getCpf())) {
                throw new CpfExistente("O CPF "+ user.getCpf() + " pertence a um outro usuario");
            }

            existingUser.setCpf(user.getCpf());
        }

        if (user.getUsername() != null) {
            existingUser.setUsername(user.getUsername());
        }
        if (user.getAge() != null) {
            existingUser.setAge(user.getAge());
        }
        if (user.getRole() != null) {
            existingUser.setRole(user.getRole());
        }
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            //Criptografa a nova senha que veio no JSON
            String senhaCriptografada = passwordEncoder.encode(user.getPassword());
            existingUser.setPassword(senhaCriptografada);
        }

        repositiry.save(existingUser);
    }

    public void deleteUserById(Integer id) {
        repositiry.deleteById(id);
    }

}
