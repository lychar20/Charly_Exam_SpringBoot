package fr.charly.exam.service;

import fr.charly.exam.DTO.BrandDTO;
import fr.charly.exam.DTO.UserDTO;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.User;
import fr.charly.exam.repository.UserRepository;
import fr.charly.exam.utils.NotFoundInstantFakingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User> {

    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getObjectById(Long id) {
        return null;
    }

    @Override
    public User findBySlug(String slug) {
        return null;
    }



    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundInstantFakingException("User", "id", id);
        }
        return optionalUser.get();

    }

    public User persist(UserDTO userDTO, Long id) {
        if (id != null && userRepository.findById(id).isEmpty()) {
            throw new NotFoundInstantFakingException(
                    "User", "id", id
            );
        }

        User user = new User();
        user.setId(id);
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

}
