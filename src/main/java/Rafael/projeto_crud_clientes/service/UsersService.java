package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.Users;
import Rafael.projeto_crud_clientes.exceptions.UsernameNotFound;
import Rafael.projeto_crud_clientes.repository.UsersRepositiry;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepositiry repositiry;

    public UsersService(UsersRepositiry repositiry) {
        this.repositiry = repositiry;
    }

    public void saveUser(Users user) {
        repositiry.saveAndFlush(user);
    }

    public Users findById(long id) {
        Users user = repositiry.findById(id).orElseThrow(UsernameNotFound::new);

        return user;
    }

    public void updateUser(long id, Users user) {
        Users userTemp = repositiry.findById(id).orElseThrow(
                () -> new RuntimeException("Id invalido")
        );

        Users userUpdate = Users.builder()
                .username(user.getUsername() != null ? user.getUsername() : userTemp.getUsername())
                .email(user.getEmail() != null ? user.getEmail() : userTemp.getEmail())
                .age(user.getAge() != null ? user.getAge() : userTemp.getAge())
                .id(userTemp.getId()).build();

        repositiry.saveAndFlush(userUpdate);
    }

    public void deleteUserById(long id) {
        repositiry.deleteById(id);
    }

    public void deleteById(long id) {

    }
}
