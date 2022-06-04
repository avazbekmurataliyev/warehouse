package uz.sklad.omborxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.entity.Supplier;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.repository.CurrencyRepository;
import uz.sklad.omborxona.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository ;

    // get all

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

    // get one

    public Supplier getOne(Integer id ){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);

        if (!optionalSupplier.isPresent()) return new Supplier();

        return optionalSupplier.get();
    }


    //delete element

    public Answer delete(Integer id){

        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) return new Answer("Object not found ",false);

        supplierRepository.delete(optionalSupplier.get());
        return new Answer("Success deleted ",true);

    }


    // save

    public Answer save (Supplier supplier){
        try {

            Supplier supplier1 = new Supplier();

            supplier1.setName(supplier.getName());
            supplier1.setPhoneNumber(supplier.getPhoneNumber());
            supplier1.setActive(supplier.isActive());

            supplierRepository.save(supplier1);
            return new Answer("Saved supplier",true);

        } catch (Exception e){

        return  new Answer("Server error " , false);
        }

    }


    // update


    public Answer update (Integer id ,Supplier supplier){
        try {
            Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
            if (!optionalSupplier.isPresent()) return new Answer("Not found error " , false);

            Supplier supplier1 = optionalSupplier.get();
            if (supplier == null ) return new Answer("Null point object  " , false);
            supplier1.setName(supplier.getName());
            supplier1.setPhoneNumber(supplier.getPhoneNumber());
            supplier1.setActive(supplier.isActive());

            supplierRepository.save(supplier1);
            return new Answer("Update supplier",true);

        } catch (Exception e){

            return  new Answer("Server error " , false);
        }

    }

}
