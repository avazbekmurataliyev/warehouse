package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.InputProduct;
import uz.sklad.omborxona.entity.OutputProduct;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputProductDTO;
import uz.sklad.omborxona.payload.OutputProductDTO;
import uz.sklad.omborxona.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    @Autowired
    private OutputProductService outputProductService;

    public List<OutputProduct> getAll(){
        return outputProductService.getAll();
    }

    public OutputProduct get(@PathVariable  Integer id){
        return outputProductService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return outputProductService.delete(id);
    }

    public Answer save(@RequestBody OutputProductDTO outputProductDTO){
        return outputProductService.save(outputProductDTO);
    }

    public Answer update(@PathVariable Integer id , @RequestBody OutputProductDTO outputProductDTO){
        return outputProductService.update(id,outputProductDTO);
    }
}
