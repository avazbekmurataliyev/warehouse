package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.*;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.InputProductDTO;
import uz.sklad.omborxona.payload.OutputProductDTO;
import uz.sklad.omborxona.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private OutputProductRepository outputProductRepository;
    @Autowired
    private OutputRepository outputRepository ;

    public List<OutputProduct> getAll(){
        return outputProductRepository.findAll();
    }

    public OutputProduct get(Integer id){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);

        if (!optionalOutputProduct.isPresent()) return new OutputProduct();

        return optionalOutputProduct.get();
    }

    public Answer delete(Integer id){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);

        if (!optionalOutputProduct.isPresent()) return new Answer("not found ",false);

        outputProductRepository.delete(optionalOutputProduct.get());
        return new Answer("deleted  ",true);
    }

    public Answer save(OutputProductDTO outputProductDTO){

        Optional<Product> optionalProduct = productRepository.findById(outputProductDTO.getProductId());
        if (!optionalProduct.isPresent()) return new Answer("Product not found ",false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDTO.getOutputId());
        if (!optionalOutput.isPresent()) return new Answer("Output not found ",false);

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDTO.getAmount());
        outputProduct.setPrice(outputProduct.getPrice());

        outputProductRepository.save(outputProduct);
        return new Answer("Saved ",true);
    }

    public Answer update(Integer id ,OutputProductDTO outputProductDTO){

        Optional<Product> optionalProduct = productRepository.findById(outputProductDTO.getProductId());
        if (!optionalProduct.isPresent()) return new Answer("Product not found ",false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDTO.getOutputId());
        if (!optionalOutput.isPresent()) return new Answer("Output not found ",false);

        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent()) return new Answer("OutputProduct not found ",false);


        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setOutput(optionalOutput.get());
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDTO.getAmount());
        outputProduct.setPrice(outputProduct.getPrice());

        outputProductRepository.save(outputProduct);
        return new Answer("Update ",true);
    }


}
