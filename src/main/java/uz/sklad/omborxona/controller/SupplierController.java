package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Product;
import uz.sklad.omborxona.entity.Supplier;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.ProductDTO;
import uz.sklad.omborxona.service.ProductService;
import uz.sklad.omborxona.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    public List<Supplier> getAll(){
        return supplierService.getAll();
    }

    public Supplier get(@PathVariable  Integer id){
        return supplierService.getOne(id);
    }

    public Answer delete(@PathVariable Integer id){
        return supplierService.delete(id);
    }

    public Answer save(@RequestBody Supplier supplier){
        return supplierService.save(supplier);
    }

    public Answer update(@PathVariable Integer id , @RequestBody Supplier supplier){
        return supplierService.update(id,supplier);
    }
}
