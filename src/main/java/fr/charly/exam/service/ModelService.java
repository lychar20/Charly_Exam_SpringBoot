package fr.charly.exam.service;

import fr.charly.exam.entity.interfaces.Brand;
import fr.charly.exam.entity.interfaces.Model;
import fr.charly.exam.repository.ModelRepository;
import fr.charly.exam.utils.NotFoundInstantFakingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService implements DAOServiceInterface<Model> {

    private ModelRepository modelRepository;
    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getObjectById(Long id) {
        return null;
    }

    @Override
    public Model findBySlug(String slug) {
        return null;
    }


    public Model findById(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isEmpty()) {
            throw new NotFoundInstantFakingException("Model", "id", id);
        }
        return optionalModel.get();

    }

}
