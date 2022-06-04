package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Category;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.CategoryDTO;
import uz.sklad.omborxona.service.CategoryService;
import uz.sklad.omborxona.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    public List<Currency> getAll(){
        return currencyService.getAll();
    }

    public Currency get(@PathVariable  Integer id){
        return currencyService.getOne(id);
    }

    public Answer delete(@PathVariable Integer id){
        return currencyService.delete(id);
    }

    public Answer save(@RequestBody Currency currency){
        return currencyService.save(currency);
    }

    public Answer update(@PathVariable Integer id , @RequestBody Currency currency){
        return currencyService.update(id,currency);
    }
}
