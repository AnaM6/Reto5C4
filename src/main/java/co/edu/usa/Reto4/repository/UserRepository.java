package co.edu.usa.Reto4.repository;

/**
 * Autor: Ana Mendoza G1
 */
import co.edu.usa.Reto4.model.User;
import co.edu.usa.Reto4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class  UserRepository {

    @Autowired
    /**
     * Variable de usercrudrepository
     */
    private UserCrudRepository userCrudRepo;

    /**
     * Función para buscar por id
     * @param id parametro por el que se va a buscar
     * @return el usuario que existe por ese id
     */
    public Optional<User> getUser(int id){
        return userCrudRepo.findById(id);
    }

    /**
     * Función para traer todos los usuarios
     * @return la  lista de usuarios que existe
     */
    public List<User> getAll(){
        return (List<User>)userCrudRepo.findAll();
    }

    /**
     * Función para comprobar que el email existe
     * @param email por el que se va a buscar
     * @return un valor booleano dependiendo si existe o no el correo
     */
    public boolean existEmail(String email){
        Optional<User> usuario = userCrudRepo.findByEmail(email);
        return !usuario.isEmpty();
    }

    /**
     * Función para verificar si el usuario existe
     * @param email a consultar
     * @param password a consultar
     * @return el usuario al que pertenece esta información
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepo.findByEmailAndPassword(email,password);
    }

    /**
     * Función para guardar usuarios
     * @param user información a guardar
     * @return información que se guardo
     */
    public User create(User user){
        return userCrudRepo.save(user);
    }

    /**
     * Función actualizar
     * @param user información que se va a actualizar
     * @return información actualizada
     */
    public User update(User user){
        return userCrudRepo.save(user);
    }

    /**
     * Función borrar
     * @param user usuario a borrar
     */
    public void delete(User user){
        userCrudRepo.delete(user);
    }

    /**
     * Función  para encontrar id máximo
     * @return usuario con id máximo
     */
    public Optional<User> getIdMaximo(){
        return userCrudRepo.findTopByOrderByIdDesc();
    }

    /**
     * Función para buscar por mes de cumpleaños
     * @param mesCumpleaños
     * @return usuarios por mes de cumpleaños
     */
    public List<User> getMonthBirthday(String mesCumpleaños){
        return userCrudRepo.findByMonthBirthtDay(mesCumpleaños);
    }
}
