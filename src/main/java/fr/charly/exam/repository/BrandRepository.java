
package fr.charly.exam.repository;

import fr.charly.exam.entity.interfaces.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>, EntityNameRepository<Brand> {



}
