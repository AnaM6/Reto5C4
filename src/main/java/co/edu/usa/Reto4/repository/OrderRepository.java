package co.edu.usa.Reto4.repository;

import co.edu.usa.Reto4.model.Order;
import co.edu.usa.Reto4.repository.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepo;

    @Autowired
    private MongoTemplate mongoTemp;


    public List<Order> getAll(){
        return orderCrudRepo.findAll();
    }

    public Optional<Order> getOrder(int id){
        return orderCrudRepo.findById(id);
    }

    public Order create(Order order){
        return orderCrudRepo.save(order);
    }

    public Order update(Order order){
        return orderCrudRepo.save(order);
    }

    public void delete(Order order){
        orderCrudRepo.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepo.findBySalesManZone(zone);

    }

    /**
     * Metodos reto 4
     */

    public List<Order> ordersSalesManById(int id){
        Query query = new Query();
        Criteria dataCriteria = Criteria.where("salesMan.id").is(id);
        query.addCriteria(dataCriteria);

        List<Order> orders = mongoTemp.find(query,Order.class);
        return orders;
    }

    public List<Order> ordersSalesManByState(String state, Integer id){
        Query query = new Query();
        Criteria criteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criteria);

        List<Order> orders = mongoTemp.find(query,Order.class);

        return orders;

    }

    public List<Order> ordersSalemanByDate(String dateStr, int id){
        DateTimeFormatter dateTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        Criteria criteria = Criteria.where("registerDay")
               .gte(LocalDate.parse(dateStr, dateTF).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dateTF).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        List<Order> orders = mongoTemp.find(query,Order.class);

        return orders;
    }

    public Optional<Order> getIdMaximo(){
        return orderCrudRepo.findTopByOrderByIdDesc();
    }

    public List<Order> getByStatus(String status){
        return orderCrudRepo.findByStatus(status);
    }

    public List<Order> getByUserId(int id){
        return orderCrudRepo.findByUserId(id);
    }

    public List<Order> getByStatusAndUserId(String status , int id){
        return orderCrudRepo.findByStatusAndUserId(status, id);
    }

    public List<Order> getByDateAndUserId(Date date , int id){
        return orderCrudRepo.findByDateAndUserId(date, id);
    }

}
