package fr.charly.exam.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;

    @JsonView(JsonViews.UserShowView.class)
    private String email;

    @JsonView(JsonViews.UserShowView.class)
    private String password;

    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Listing> listings = new ArrayList<>();


}