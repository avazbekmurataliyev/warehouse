package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Users;
import uz.sklad.omborxona.entity.Warehouse;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.UserDto;
import uz.sklad.omborxona.service.UserService;
import uz.sklad.omborxona.service.WareHouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WareHouseService wareHouseService;

    public List<Warehouse> getAll(){
        return wareHouseService.getAll();
    }

    public Warehouse get(@PathVariable  Integer id){
        return wareHouseService.getOne(id);
    }

    public Answer delete(@PathVariable Integer id){
        return wareHouseService.delete(id);
    }

    public Answer save(@RequestBody Warehouse warehouse){
        return wareHouseService.save(warehouse);
    }

    public Answer update(@PathVariable Integer id , @RequestBody Warehouse warehouse){
        return wareHouseService.update(id,warehouse);
    }
}
