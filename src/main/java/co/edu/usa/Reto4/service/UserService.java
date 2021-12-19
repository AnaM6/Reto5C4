package co.edu.usa.Reto4.service;
/**
 * Autor: Ana Mendoza G1
 */
import co.edu.usa.Reto4.model.User;
import co.edu.usa.Reto4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    /**
     * Variable de user Repository
     */
    private UserRepository userRepo;

    /**
     * Funcion para traer todos los usuarios
     * @return listado de todos los usuarios
     */

    public List<User> getAll(){
        return userRepo.getAll();
    }

    /**
     * Esta función es para traer usuarios por id
     * @param id es el parametro por el que se buscara el usuario
     * @return el usuario que tiene ese id si este existe
     */
    public Optional<User> getUser(int id){
        return userRepo.getUser(id);
    }

    /**
     * Función para guardar usuarios
     * @param user trae los datos que se van a guardar
     * @return el usuario que se guardo
     */
    public User create(User user){
        if (user.getId() ==null){
            return user;
        }else{
            Optional<User> exist=userRepo.getUser(user.getId());
            if (exist.isEmpty()){
                if (existEmail(user.getEmail())== false){
                    return userRepo.create(user);
                }else {
                    return user;
                }
            }else {
                return user;
            }
        }
    }

    /**
     * Función para consultar si existe el email
     * @param email por lo que se va a buscar el usuario
     * @return un valor booleano true si existe el correo
     */

    public boolean existEmail(String email){
        return userRepo.existEmail(email);
    }

    /**
     * Funcion autenticar
     * @param email que se va a consultar
     * @param password que se va a consultar
     * @return el usuario al que pertenece la información
     */

    public User authenticateUser(String email, String password){
        Optional<User> usuario = userRepo.authenticateUser(email,password);

        if (usuario.isEmpty()){
            return new User();
        }
            return usuario.get();


    }

    /**
     * Función actualizar
     * @param user nos trae la información actualizada
     * @return usuario actualizado
     */
    public User update(User user){
       if(user.getId() !=null){
           Optional<User> userDb = userRepo.getUser(user.getId());
           if (!userDb.isEmpty()){
               if (user.getIdentification() !=null){
                   userDb.get().setIdentification(user.getIdentification());
               }
               if (user.getName() != null){
                   userDb.get().setName(user.getName());
               }
               if (user.getBirthtDay() != null){
                   userDb.get().setBirthtDay(user.getBirthtDay());
               }
               if (user.getMonthBirthtDay()!= null){
                   userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
               }

               if (user.getAddress() != null){
                   userDb.get().setAddress(user.getAddress());
               }
               if (user.getCellPhone() != null){
                   userDb.get().setCellPhone(user.getCellPhone());
               }
               if (user.getEmail() != null){
                   userDb.get().setEmail(user.getEmail());
               }
               if (user.getPassword() != null){
                   userDb.get().setPassword(user.getPassword());
               }
               if (user.getZone() != null){
                   userDb.get().setZone(user.getZone());
               }
               if (user.getType() != null){
                   userDb.get().setType(user.getType());
               }
               userRepo.update(userDb.get());
               return userDb.get();
           } else{
               return user;
           }
       }
       return user;

    }

    /**
     * Función borrar usuario
     * @param userId para eliminar el usuario con este id
     * @return
     */
    public boolean delete(int userId){
        Boolean userBoo = getUser(userId).map(user ->{userRepo.delete(user);
            return true;
        }).orElse(false);
        return userBoo;
    }

    /**
     * Función para buscar por cumpleaños
     * @param mesCumpleaños parametro por el que se va a buscar
     * @return mes de cumpleaños.
     */
    public List<User> getByMonthBirthday(String mesCumpleaños){
        return userRepo.getMonthBirthday(mesCumpleaños);
    }
}
