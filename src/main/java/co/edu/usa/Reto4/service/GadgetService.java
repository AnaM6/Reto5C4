package co.edu.usa.Reto4.service;

import co.edu.usa.Reto4.model.Gadget;
import co.edu.usa.Reto4.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gadgetRepo;

    public List<Gadget> getAll() {
        return gadgetRepo.getAll();
    }

    public Optional<Gadget> getGadget(int id) {
        return gadgetRepo.getGadget(id);
    }

    public Gadget create(Gadget gadget) {
        if (gadget.getId() == null) {
            return gadget;
        }
        return gadgetRepo.create(gadget);
    }

    public Gadget update(Gadget gadget) {
        if (gadget.getId() != null) {
            Optional<Gadget> gadgetDb = gadgetRepo.getGadget(gadget.getId());
            if (!gadgetDb.isEmpty()) {
                if(gadget.getBrand() != null){
                    gadgetDb.get().setBrand(gadget.getBrand());
                }
                if(gadget.getCategory() != null){
                    gadgetDb.get().setCategory(gadget.getCategory());
                }
                if(gadget.getName() != null){
                    gadgetDb.get().setName(gadget.getName());
                }
                if(gadget.getDescription() != null){
                    gadgetDb.get().setDescription(gadget.getDescription());
                }

                if(gadget.getPrice() != null){
                    gadgetDb.get().setPrice(gadget.getPrice());
                }
               gadgetDb.get().setAvailability(gadget.getAvailability());

                if(gadget.getQuantity() != 0){
                    gadgetDb.get().setQuantity(gadget.getQuantity());
                }
                if(gadget.getPhotography()!= null){
                    gadgetDb.get().setPhotography(gadget.getPhotography());
                }
                gadgetRepo.update(gadgetDb.get());
                return gadgetDb.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }

    }

    public boolean delete(int id){
       return getGadget(id).map(gadget -> {
           gadgetRepo.delete(gadget);
           return true;
       }).orElse(false);
    }

    public List<Gadget> getByPrice(double price){
        return gadgetRepo.getByPrice(price);
    }

    public List<Gadget> getByDescription(String description){
        return gadgetRepo.getByDescription(description);

    }
}


