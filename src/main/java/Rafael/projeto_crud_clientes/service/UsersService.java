package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.exceptions.*;
import Rafael.projeto_crud_clientes.repository.UsersRepositiry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepositiry repositiry;

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
        Users userTemp = repositiry.findById(id).orElseThrow(UsernameNotFound::new);

        if(repositiry.existsByEmail(user.getEmail())) {
            throw new EmailExistente("O Email: " + user.getEmail()+ " pertence a um outro usuario");
        }

        if(repositiry.existsBycpf(user.getCpf())) {
            throw new CpfExistente("O CPF "+ user.getCpf() + " pertence a um outro usuario");
        }

        Users userUpdate = Users.builder()
                .username(user.getUsername() != null ? user.getUsername() : userTemp.getUsername())
                .email(user.getEmail() != null ? user.getEmail() : userTemp.getEmail())
                .age(user.getAge() != null ? user.getAge() : userTemp.getAge())
                .id(userTemp.getId())
                .password(user.getPassword() != null ? user.getPassword() : userTemp.getPassword())
                .role(user.getRole() != null ? user.getRole() : userTemp.getRole())
                .cpf(user.getCpf() != null ? user.getCpf() : userTemp.getCpf()).build();

        repositiry.saveAndFlush(userUpdate);
    }

    public void deleteUserById(Integer id) {
        repositiry.deleteById(id);
    }

}
