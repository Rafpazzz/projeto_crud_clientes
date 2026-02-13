package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.User.Users;
import Rafael.projeto_crud_clientes.exceptions.EmailExistente;
import Rafael.projeto_crud_clientes.exceptions.IdNotFound;
import Rafael.projeto_crud_clientes.exceptions.UsernameNotFound;
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
        repositiry.saveAndFlush(user);
    }

    public Users findById(Integer id) {
        Users user = repositiry.findById(id).orElseThrow(IdNotFound::new);

        return user;
    }

    public List<Users> findAllUsers() {
        return repositiry.findAll();
    }

    public void updateUser(Integer id, Users user) {
        Users userTemp = repositiry.findById(id).orElseThrow(UsernameNotFound::new);

        if(repositiry.existsByEmail(user.getEmail())) {
            throw new EmailExistente("O Email: " + user.getEmail()+ " exite no banco");
        }

        Users userUpdate = Users.builder()
                .username(user.getUsername() != null ? user.getUsername() : userTemp.getUsername())
                .email(user.getEmail() != null ? user.getEmail() : userTemp.getEmail())
                .age(user.getAge() != null ? user.getAge() : userTemp.getAge())
                .id(userTemp.getId())
                .password(user.getPassword() != null ? user.getPassword() : userTemp.getPassword())
                .role(user.getRole() != null ? user.getRole() : userTemp.getRole()).build();

        repositiry.saveAndFlush(userUpdate);
    }

    public void deleteUserById(Integer id) {
        repositiry.deleteById(id);
    }

}
