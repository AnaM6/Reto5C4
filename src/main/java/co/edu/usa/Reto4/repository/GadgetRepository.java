package co.edu.usa.Reto4.repository;

import co.edu.usa.Reto4.model.Gadget;
import co.edu.usa.Reto4.repository.crud.GadgetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GadgetRepository {

    @Autowired
    private GadgetCrudRepository gadgetCrudRepo;

    public List<Gadget> getAll(){
        return gadgetCrudRepo.findAll();
    }

    public Optional<Gadget> getGadget(int id){
        return gadgetCrudRepo.findById(id);
    }

    public Gadget create(Gadget gadget){
        return gadgetCrudRepo.save(gadget);
    }

    public Gadget update(Gadget gadget){
        return gadgetCrudRepo.save(gadget);
    }

    public void delete(Gadget gadget){
        gadgetCrudRepo.delete(gadget);
    }

    public List<Gadget> getByPrice(double price){
        return gadgetCrudRepo.findByPrice(price);
    }

    public List<Gadget> getByDescription(String description){
        return gadgetCrudRepo.findByDescription(description);
    }
}
