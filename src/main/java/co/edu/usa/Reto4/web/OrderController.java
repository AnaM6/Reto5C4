package co.edu.usa.Reto4.web;

import co.edu.usa.Reto4.model.Order;
import co.edu.usa.Reto4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable("id") int id){
        return orderService.getOrder(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zone){
        return orderService.getByOrderZone(zone);
    }

     @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return orderService.delete(id);

    }

    @GetMapping("/salesman/{id}")
    public List<Order> getOrdersSalesManById(@PathVariable("id") int id){
        return orderService.getOrdersSalesManById(id);
    }

    @GetMapping("/state/{state}/{id}")
    public List<Order> getOrdersSalesManByState(@PathVariable("state") String state,@PathVariable("id") int id){
        return orderService.getOrdersSalesManByState(state,id);
    }

    @GetMapping("/date/{date}/{id}")
    public List<Order> getOrderByDateAndUser(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.getOrdersSalesManByDate(dateStr,id);
    }

    @GetMapping("/status/{status}")
    public List<Order> getStatus(@PathVariable("status") String status){
        return orderService.getByStatus(status);
    }

}
