package fr.charly.exam.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.BrandListView.class)
    private Long id;
    @JsonView(JsonViews.BrandListView.class)
    private String name;

    @JsonView(JsonViews.BrandListView.class)
    @OneToMany
    private List<Model> model;
}