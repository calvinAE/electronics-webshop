package ehb.be.webapp.service;

import ehb.be.webapp.model.UserDTO;
import ehb.be.webapp.model.User;
import ehb.be.webapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;



    public User registerNewUserAccount(UserDTO u) {
        User user =  new User();
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setUsername(u.getUsername());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setEmail(u.getEmail());
        user.setRole("guest");

        return repository.save(user);
    }


    private boolean userExists(String username) {
        return repository.findByUsername(username) != null;
    }
}
