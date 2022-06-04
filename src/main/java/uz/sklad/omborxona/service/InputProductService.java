package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Input;
import uz.sklad.omborxona.entity.InputProduct;
import uz.sklad.omborxona.entity.Product;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputProductDTO;
import uz.sklad.omborxona.repository.InputProductRepository;
import uz.sklad.omborxona.repository.InputRepostory;
import uz.sklad.omborxona.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private InputProductRepository inputProductRepository;
    @Autowired
    private InputRepostory inputRepostory ;

    public List<InputProduct> getAll(){
        return inputProductRepository.findAll();
    }

    public InputProduct get(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);

        if (!optionalInputProduct.isPresent()) return new InputProduct();

        return optionalInputProduct.get();
    }

    public Answer delete(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);

        if (!optionalInputProduct.isPresent()) return new Answer("not found ",false);

        inputProductRepository.delete(optionalInputProduct.get());
        return new Answer("deleted  ",true);
    }

    public Answer save(InputProductDTO inputProductDTO){

        Optional<Product> optionalProduct = productRepository.findById(inputProductDTO.getProductId());
        if (!optionalProduct.isPresent()) return new Answer("Product not found ",false);

        Optional<Input> optionalInput = inputRepostory.findById(inputProductDTO.getInputId());
        if (!optionalInput.isPresent()) return new Answer("Input not found ",false);
        InputProduct inputProduct = new InputProduct();
        inputProduct.setInput(optionalInput.get());
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setAmount(inputProductDTO.getAmount());
        inputProduct.setPrice(inputProductDTO.getPrice());
        inputProduct.setExpireDate(inputProductDTO.getExpireDate());

        inputProductRepository.save(inputProduct);
        return new Answer("Saved ",true);
    }

    public Answer update(Integer id ,InputProductDTO inputProductDTO){

        Optional<Product> optionalProduct = productRepository.findById(inputProductDTO.getProductId());
        if (!optionalProduct.isPresent()) return new Answer("Product not found ",false);

        Optional<Input> optionalInput = inputRepostory.findById(inputProductDTO.getInputId());
        if (!optionalInput.isPresent()) return new Answer("Input not found ",false);

        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent()) return new Answer("InputProduct not found ",false);

        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setInput(optionalInput.get());
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setAmount(inputProductDTO.getAmount());
        inputProduct.setPrice(inputProductDTO.getPrice());
        inputProduct.setExpireDate(inputProductDTO.getExpireDate());

        inputProductRepository.save(inputProduct);
        return new Answer("Update  ",true);
    }


}
