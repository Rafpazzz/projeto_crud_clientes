package Rafael.projeto_crud_clientes.entity.User;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "Users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "role", nullable = false)
    private UserRole role;

    public Users (String username,String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return  List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return switch (this.role) {
//            case ADMIN -> List.of(
//                    new SimpleGrantedAuthority("ROLE_ADMIN"),
//                    new SimpleGrantedAuthority("ROLE_USER"),
//                    new SimpleGrantedAuthority("ROLE_RECEPCIONISTA"),
//                    new SimpleGrantedAuthority("ROLE_CAMAREIRA")
//            );
//            case RECEPCIONISTA -> List.of(
//                    new SimpleGrantedAuthority("ROLE_RECEPCIONISTA"),
//                    new SimpleGrantedAuthority("ROLE_USER") // Recepcionista também é um usuário comum
//            );
//            case CAMAREIRA -> List.of(
//                    new SimpleGrantedAuthority("ROLE_CAMAREIRA"),
//                    new SimpleGrantedAuthority("ROLE_USER") // Camareira também é um usuário comum
//            );
//            default -> List.of(new SimpleGrantedAuthority("ROLE_USER"));
//        };
//    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
