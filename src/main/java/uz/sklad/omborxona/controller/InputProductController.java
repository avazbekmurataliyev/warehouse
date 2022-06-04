package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Input;
import uz.sklad.omborxona.entity.InputProduct;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputDTO;
import uz.sklad.omborxona.payload.InputProductDTO;
import uz.sklad.omborxona.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {

    @Autowired
    private InputProductService inputProductService;

    public List<InputProduct> getAll(){
        return inputProductService.getAll();
    }

    public InputProduct get(@PathVariable  Integer id){
        return inputProductService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return inputProductService.delete(id);
    }

    public Answer save(@RequestBody InputProductDTO inputProductDTO){
        return inputProductService.save(inputProductDTO);
    }

    public Answer update(@PathVariable Integer id , @RequestBody InputProductDTO inputProductDTO){
        return inputProductService.update(id,inputProductDTO);
    }
}
