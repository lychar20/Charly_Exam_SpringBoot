package fr.charly.exam.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JsonView(JsonViews.BrandListView.class)
    private Brand brand;

}