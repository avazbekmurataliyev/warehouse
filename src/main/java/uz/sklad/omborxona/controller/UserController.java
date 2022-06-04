package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Supplier;
import uz.sklad.omborxona.entity.Users;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.UserDto;
import uz.sklad.omborxona.service.SupplierService;
import uz.sklad.omborxona.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public List<Users> getAll(){
        return userService.getAll();
    }

    public Users get(@PathVariable  Integer id){
        return userService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    public Answer save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    public Answer update(@PathVariable Integer id , @RequestBody UserDto userDto){
        return userService.update(id,userDto);
    }
}
