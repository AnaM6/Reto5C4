package co.edu.usa.Reto4.repository.crud;

import co.edu.usa.Reto4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderCrudRepository extends MongoRepository<Order,Integer> {


    List<Order> findBySalesManZone(String Zone);

    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    @Query("{'salesMan.id': ?0}")
    List<Order> findByUserId(final int id);

    @Query("{'status' : ?0 , 'salesMan.id' : ?1} ")
    List<Order> findByStatusAndUserId(final String status , final int id);

    @Query("{'registerDay' : ?0 , 'salesMan.id' : ?1}")
    List<Order> findByDateAndUserId(final Date date , final int id);

    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
