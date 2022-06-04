package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.*;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputDTO;
import uz.sklad.omborxona.payload.ProductDTO;
import uz.sklad.omborxona.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    private WarehouseRepository warehouseRepository ;
    @Autowired
    private SupplierRepository supplierRepository ;
    @Autowired
    private InputRepostory inputRepostory ;
    @Autowired
    private CurrencyRepository currencyRepository ;

    //get Users

    public List<Input> getAll(){
        return inputRepostory.findAll();
    }

    // get one user

    public Input get(Integer id ){
        Optional<Input> optionalInput = inputRepostory.findById(id);

        if (optionalInput.isPresent()) return optionalInput.get();

        return new Input();
    }

    // delete user
    public Answer delete(Integer id){

        Optional<Input> optionalInput = inputRepostory.findById(id);

        if (optionalInput.isPresent())
        {
            inputRepostory.delete(optionalInput.get());
            return new Answer("Success deleted",true);
        }
        return new Answer("Not found ",false);

    }

    public Answer save(InputDTO inputDTO){

        try{
            Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
            if (!optionalCurrency.isPresent()) return new Answer("NOt found ",false);

            Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
            if (!optionalSupplier.isPresent())return new Answer("NOt found ",false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDTO.getWarehuoseId());
            if (!optionalWarehouse.isPresent()) return new Answer("NOt found ",false);

            Input input = new Input();
            input.setDate(new Date());
            input.setCurrency(optionalCurrency.get());
            input.setSupplier(optionalSupplier.get());
            input.setCode("1234");//generate
            input.setWarehuose(optionalWarehouse.get());
            input.setFactureNumber(inputDTO.getFactureNumber());
        inputRepostory.save(input);
        return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }

    }

    public Answer update(Integer id ,InputDTO inputDTO){

        try{
            Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
            if (!optionalCurrency.isPresent()) return new Answer("NOt found ",false);

            Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
            if (!optionalSupplier.isPresent())return new Answer("NOt found ",false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDTO.getWarehuoseId());
            if (!optionalWarehouse.isPresent()) return new Answer("NOt found ",false);

            Optional<Input> optionalInput = inputRepostory.findById(id);
            if (!optionalInput.isPresent()) return new Answer("NOt found ",false);
            Input input = optionalInput.get();
            input.setDate(new Date());
            input.setCurrency(optionalCurrency.get());
            input.setSupplier(optionalSupplier.get());
            input.setCode("1234");//generate
            input.setWarehuose(optionalWarehouse.get());
            input.setFactureNumber(inputDTO.getFactureNumber());
            inputRepostory.save(input);
            return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }


    }

}
