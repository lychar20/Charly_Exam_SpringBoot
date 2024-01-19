package fr.charly.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.User;
import fr.charly.exam.json_views.JsonViews;
import fr.charly.exam.service.BrandService;
import fr.charly.exam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private UserService userService;

    @GetMapping
    @JsonView(JsonViews.BrandListView.class)
    List<User> list() {return userService.findAll();}


    @GetMapping(path ="/{id}")
    @JsonView(JsonViews.BrandShowView.class)
    User show(@PathVariable String id) {return userService.findBySlug(id);}

}
