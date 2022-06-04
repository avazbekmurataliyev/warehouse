package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Input;
import uz.sklad.omborxona.entity.Output;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputDTO;
import uz.sklad.omborxona.payload.OutputDTO;
import uz.sklad.omborxona.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    private OutputService outputService;

    public List<Output> getAll(){
        return outputService.getAll();
    }

    public Output get(@PathVariable  Integer id){
        return outputService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return outputService.delete(id);
    }

    public Answer save(@RequestBody OutputDTO outputDTO){
        return outputService.save(outputDTO);
    }

    public Answer update(@PathVariable Integer id , @RequestBody OutputDTO outputDTO){
        return outputService.update(id,outputDTO);
    }
}
