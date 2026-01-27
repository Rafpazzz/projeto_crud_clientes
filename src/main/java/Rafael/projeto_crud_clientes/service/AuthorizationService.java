package Rafael.projeto_crud_clientes.service;


import Rafael.projeto_crud_clientes.repository.UsersRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UsersRepositiry repositiry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositiry.findByEmail(username);
    }
}
