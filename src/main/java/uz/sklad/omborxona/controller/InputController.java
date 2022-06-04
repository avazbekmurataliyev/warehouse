package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.entity.Input;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputDTO;
import uz.sklad.omborxona.service.CurrencyService;
import uz.sklad.omborxona.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    private InputService inputService;

    public List<Input> getAll(){
        return inputService.getAll();
    }

    public Input get(@PathVariable  Integer id){
        return inputService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return inputService.delete(id);
    }

    public Answer save(@RequestBody InputDTO inputDTO){
        return inputService.save(inputDTO);
    }

    public Answer update(@PathVariable Integer id , @RequestBody InputDTO inputDTO){
        return inputService.update(id,inputDTO);
    }
}
