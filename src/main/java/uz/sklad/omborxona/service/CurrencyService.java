package uz.sklad.omborxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Category;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.CategoryDTO;
import uz.sklad.omborxona.repository.CategoryRepository;
import uz.sklad.omborxona.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository ;

    // get all

    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }

    // get one

    public Currency getOne(Integer id ){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);

        if (!optionalCurrency.isPresent()) return new Currency();

        return optionalCurrency.get();
    }


    //delete element

    public Answer delete(Integer id){

        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()) return new Answer("Object not found ",false);

        currencyRepository.delete(optionalCurrency.get());
        return new Answer("Success deleted ",true);

    }


    // save

    public Answer save (Currency currency){
        try {

            Currency currency1 = new Currency();

            currency1.setName(currency.getName());
            currency1.setActive(currency.isActive());

            currencyRepository.save(currency1);
            return new Answer("Saved category",true);

        } catch (Exception e){

        return  new Answer("Server error " , false);
        }

    }


    // update


    public Answer update (Integer id ,Currency currency){
        try {
            Optional<Currency> optionalCurrency = currencyRepository.findById(id);
            if (!optionalCurrency.isPresent()) return new Answer("Not found error " , false);

            Currency currency1 = optionalCurrency.get();
            if (currency == null ) return new Answer("Null point object  " , false);
            currency1.setName(currency.getName());
            currency1.setActive(currency.isActive());

            currencyRepository.save(currency1);
            return new Answer("Saved currency",true);

        } catch (Exception e){

            return  new Answer("Server error " , false);
        }

    }

}
