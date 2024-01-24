package fr.charly.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.DTO.BrandDTO;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.json_views.JsonViews;
import fr.charly.exam.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brand")
public class BrandRestController {

    private BrandService brandService;

    @GetMapping
    @JsonView(JsonViews.BrandListView.class)
    List<Brand> list() {return brandService.findAll();}


    @GetMapping(path ="/{id}")
    @JsonView(JsonViews.BrandShowView.class)
    Brand show(@PathVariable String id) {return brandService.findBySlug(id);}

    @PostMapping()
    @JsonView(JsonViews.BrandShowView.class)
    Brand persist(@RequestBody BrandDTO brandDTO) {
        return brandService.persist(brandDTO, null);
    }

}
