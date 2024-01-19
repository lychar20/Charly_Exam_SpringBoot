package fr.charly.exam.service;

import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.Listing;
import fr.charly.exam.repository.ListingRepository;
import fr.charly.exam.utils.NotFoundInstantFakingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService implements DAOServiceInterface<Listing> {

    private ListingRepository listingRepository;
    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public Listing getObjectById(Long id) {
        return null;
    }

    @Override
    public Listing findBySlug(String slug) {
        return null;
    }

    public Listing findById(Long id) {
        Optional<Listing> optionalBrand = listingRepository.findById(id);
        if (optionalBrand.isEmpty()) {
            throw new NotFoundInstantFakingException("List", "id", id);
        }
        return optionalBrand.get();

    }

}
