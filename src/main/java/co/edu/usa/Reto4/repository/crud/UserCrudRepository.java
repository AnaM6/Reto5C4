package co.edu.usa.Reto4.repository.crud;

import co.edu.usa.Reto4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {


    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email,String password);

    Optional<User> findByNameOrEmail(String name, String email);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String mesCumpleaños);
}
