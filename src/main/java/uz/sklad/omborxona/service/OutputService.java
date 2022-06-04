package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.*;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputDTO;
import uz.sklad.omborxona.payload.OutputDTO;
import uz.sklad.omborxona.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    private WarehouseRepository warehouseRepository ;
    @Autowired
    private OutputRepository outputRepository ;
    @Autowired
    private CurrencyRepository currencyRepository ;

    //get Users

    public List<Output> getAll(){
        return outputRepository.findAll();
    }

    // get one user

    public Output get(Integer id ){
        Optional<Output> optionalInput = outputRepository.findById(id);

        if (optionalInput.isPresent()) return optionalInput.get();

        return new Output();
    }

    // delete user
    public Answer delete(Integer id){

        Optional<Output> optionalOutput = outputRepository.findById(id);

        if (optionalOutput.isPresent())
        {
            outputRepository.delete(optionalOutput.get());
            return new Answer("Success deleted",true);
        }
        return new Answer("Not found ",false);

    }

    public Answer save(OutputDTO outputDTO){

        try{
            Optional<Currency> optionalCurrency = currencyRepository.findById(outputDTO.getCurrencyId());
            if (!optionalCurrency.isPresent()) return new Answer("NOt found ",false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDTO.getWarehuoseId());
            if (!optionalWarehouse.isPresent()) return new Answer("NOt found ",false);


            Output output = new Output();
            output.setDate(new Date());
            output.setCurrency(optionalCurrency.get());
            output.setCode("1234");//generate
            output.setWarehuose(optionalWarehouse.get());
            output.setFactureNumber(outputDTO.getFactureNumber());
        outputRepository.save(output);
        return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }

    }

    public Answer update(Integer id ,OutputDTO outputDTO){

        try{
            Optional<Currency> optionalCurrency = currencyRepository.findById(outputDTO.getCurrencyId());
            if (!optionalCurrency.isPresent()) return new Answer("NOt found ",false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDTO.getWarehuoseId());
            if (!optionalWarehouse.isPresent()) return new Answer("NOt found ",false);

            Optional<Output> optionalOutput = outputRepository.findById(id);
            if (!optionalOutput.isPresent()) return new Answer("NOt found ",false);


            Output output = optionalOutput.get();
            output.setDate(new Date());
            output.setCurrency(optionalCurrency.get());
            output.setCode("1234");//generate
            output.setWarehuose(optionalWarehouse.get());
            output.setFactureNumber(outputDTO.getFactureNumber());
            outputRepository.save(output);
            return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }


    }

}
