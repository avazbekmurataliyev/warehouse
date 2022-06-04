package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Users;
import uz.sklad.omborxona.entity.Warehouse;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.UserDto;
import uz.sklad.omborxona.repository.UserRepository;
import uz.sklad.omborxona.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private WarehouseRepository warehouseRepository ;

    //get Users

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    // get one user

    public Users get(Integer id ){
        Optional<Users> optionalUsers = userRepository.findById(id);

        if (optionalUsers.isPresent()) return optionalUsers.get();

        return new Users();
    }

    // delete user
    public Answer delete(Integer id){

        Optional<Users> optionalUsers = userRepository.findById(id);

        if (optionalUsers.isPresent())
        {
            userRepository.delete(optionalUsers.get());
            return new Answer("Success deleted",true);
        }
        return new Answer("Not found ",false);

    }

    public Answer save(UserDto userDto){

        try{
            List<Warehouse> allById = warehouseRepository.findAllById(userDto.getWarehouseId());
            Users users = new Users();
            users.setActive(true);
            users.setFirstName(userDto.getFirstName());
            users.setLastName(userDto.getLastName());
            users.setPhoneNumber(userDto.getPhoneNumber());
            users.setWarehouse(allById);
            users.setCode("1234");//generate
            users.setPassword(userDto.getPassword());
        userRepository.save(users);
        return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }

    }

    public Answer update(Integer id ,UserDto userDto){

        try{
            List<Warehouse> allById = warehouseRepository.findAllById(userDto.getWarehouseId());
            Optional<Users> optionalUsers = userRepository.findById(id);
            if (!optionalUsers.isPresent())return new Answer("Not found",false);
            Users users = optionalUsers.get();
            if (userDto==null) return new Answer("Object is null ",false);
            users.setActive(true);
            users.setFirstName(userDto.getFirstName());
            users.setLastName(userDto.getLastName());
            users.setPhoneNumber(userDto.getPhoneNumber());
            users.setWarehouse(allById);
            users.setCode("1234");//generate
            users.setPassword(userDto.getPassword());
            userRepository.save(users);
            return new Answer("Update success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }

    }

}
