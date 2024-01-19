package fr.charly.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.Model;
import fr.charly.exam.json_views.JsonViews;
import fr.charly.exam.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/model")
public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    @JsonView(JsonViews.ModelShowView.class)
    List<Model> list() {return modelService.findAll();}

    @GetMapping(path ="/{id}")
   @JsonView(JsonViews.ModelShowView.class)
    Model show(@PathVariable String id) {return modelService.findBySlug(id);}

}
