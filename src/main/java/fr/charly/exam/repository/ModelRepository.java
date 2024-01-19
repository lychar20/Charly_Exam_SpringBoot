
package fr.charly.exam.repository;

import fr.charly.exam.entity.interfaces.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long>, EntityNameRepository<Model> {

   // Optional<Brand> findBySlug(String name);

}
