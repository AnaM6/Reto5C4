package co.edu.usa.Reto4.repository.crud;

import co.edu.usa.Reto4.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface GadgetCrudRepository extends MongoRepository<Gadget,Integer> {

    @Query("{ 'price' : {'lte':?0}}")
    public List<Gadget> findByPrice(Double precio);

    @Query("{'description' : {'$regex': {'$regularExpression': 'pattern': '?0','options':'i'}}}}")
    public List<Gadget> findByDescription(final String description);
}
