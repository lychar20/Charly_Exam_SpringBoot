package fr.charly.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.Listing;
import fr.charly.exam.json_views.JsonViews;
import fr.charly.exam.service.BrandService;
import fr.charly.exam.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/listing")
public class ListingRestController {

    private ListingService listingService;

    @GetMapping
    //@JsonView(JsonViews.BrandListView.class)
    List<Listing> list() {return listingService.findAll();}


    @GetMapping(path ="/{id}")
    //@JsonView(JsonViews.BrandShowView.class)
    Listing show(@PathVariable String id) {return listingService.findBySlug(id);}

}
