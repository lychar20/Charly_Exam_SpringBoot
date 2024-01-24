package fr.charly.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.DTO.UserDTO;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.User;
import fr.charly.exam.json_views.JsonViews;
import fr.charly.exam.service.BrandService;
import fr.charly.exam.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;

    @GetMapping
    @JsonView(JsonViews.UserListView.class)
    List<User> list() {return userService.findAll();}


    @GetMapping(path ="/{id}")
    @JsonView(JsonViews.UserShowView.class)
    User show(@PathVariable String id) {return userService.findBySlug(id);}


    @PostMapping
    @JsonView(JsonViews.UserShowView.class)
    public User persist(@RequestBody UserDTO userDTO) {
        return userService.persist(userDTO, null);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.UserShowView.class)
    public User persist(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
        return userService.persist(userDTO, id);
    }


}
