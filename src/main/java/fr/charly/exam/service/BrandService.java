package fr.charly.exam.service;

import fr.charly.exam.DTO.BrandDTO;
import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.repository.BrandRepository;
import fr.charly.exam.utils.NotFoundInstantFakingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService implements DAOServiceInterface<Brand> {

    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getObjectById(Long id) {
        return null;
    }

    @Override
    public Brand findBySlug(String slug) {
        return null;
    }

    public Brand findById(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isEmpty()) {
            throw new NotFoundInstantFakingException("Brand", "id", id);
        }
        return optionalBrand.get();

    }

//    public Brand create(BrandDTO brandDTO) {
//        Brand brand = new Brand();
//        brand.setName(brandDTO.getName());
//        return brandRepository.saveAllAndFlush(brand);
//    }

}
