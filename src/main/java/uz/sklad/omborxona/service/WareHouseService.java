package uz.sklad.omborxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.entity.Warehouse;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.repository.CurrencyRepository;
import uz.sklad.omborxona.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService {
    @Autowired
    private WarehouseRepository warehouseRepository ;

    // get all

    public List<Warehouse> getAll(){
        return warehouseRepository.findAll();
    }

    // get one

    public Warehouse getOne(Integer id ){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);

        if (!optionalWarehouse.isPresent()) return new Warehouse();

        return optionalWarehouse.get();
    }


    //delete element

    public Answer delete(Integer id){

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent()) return new Answer("Object not found ",false);

        warehouseRepository.delete(optionalWarehouse.get());
        return new Answer("Success deleted ",true);

    }


    // save

    public Answer save (Warehouse warehouse){
        try {

            Warehouse warehouse1 = new Warehouse();

            warehouse1.setName(warehouse.getName());
            warehouse1.setActive(warehouse.isActive());

            warehouseRepository.save(warehouse1);
            return new Answer("Saved warehouse",true);

        } catch (Exception e){

        return  new Answer("Server error " , false);
        }

    }


    // update


    public Answer update (Integer id ,Warehouse warehouse){
        try {
            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
            if (!optionalWarehouse.isPresent()) return new Answer("Not found error " , false);

            Warehouse warehouse1 = optionalWarehouse.get();
            if (warehouse == null ) return new Answer("Null point object  " , false);
            warehouse1.setName(warehouse.getName());
            warehouse1.setActive(warehouse.isActive());

            warehouseRepository.save(warehouse1);
            return new Answer("Update warehouse",true);

        } catch (Exception e){

            return  new Answer("Server error " , false);
        }

    }

}
