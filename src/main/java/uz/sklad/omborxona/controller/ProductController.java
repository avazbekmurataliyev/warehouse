package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Output;
import uz.sklad.omborxona.entity.Product;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.OutputDTO;
import uz.sklad.omborxona.payload.ProductDTO;
import uz.sklad.omborxona.service.OutputService;
import uz.sklad.omborxona.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Product get(@PathVariable  Integer id){
        return productService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return productService.delete(id);
    }

    public Answer save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    public Answer update(@PathVariable Integer id , @RequestBody ProductDTO productDTO){
        return productService.update(id,productDTO);
    }
}
