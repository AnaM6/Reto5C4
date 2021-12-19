package co.edu.usa.Reto4.web;

import co.edu.usa.Reto4.model.Gadget;
import co.edu.usa.Reto4.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GadgetController {

    @Autowired
    private GadgetService gadgetService;

    @GetMapping("/all")
    public List<Gadget> getAll(){
        return gadgetService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gadget> getById(@PathVariable("id") int id){
        return gadgetService.getGadget(id);
    }

   @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget gadget){
        return gadgetService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget){
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return gadgetService.delete(id);

    }

    @GetMapping("/price/{price}")
    public List<Gadget> getPrice(@PathVariable("price") double price){
        return gadgetService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Gadget> getDescription(@PathVariable("description") String description){
        return gadgetService.getByDescription(description);
    }
}
