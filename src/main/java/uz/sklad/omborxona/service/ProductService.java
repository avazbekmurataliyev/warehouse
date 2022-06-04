package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.*;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.ProductDTO;
import uz.sklad.omborxona.payload.UserDto;
import uz.sklad.omborxona.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private AttachmentRepository attachmentRepository ;
    @Autowired
    private MeasurementRepository measurementRepository ;
    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private CategoryRepository categoryRepository ;

    //get Users

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    // get one user

    public Product get(Integer id ){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) return optionalProduct.get();

        return new Product();
    }

    // delete user
    public Answer delete(Integer id){

        Optional<Product> optionalUsers = productRepository.findById(id);

        if (optionalUsers.isPresent())
        {
            productRepository.delete(optionalUsers.get());
            return new Answer("Success deleted",true);
        }
        return new Answer("Not found ",false);

    }

    public Answer save(ProductDTO productDTO){

        try{
            Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
            if (!optionalCategory.isPresent()) return new Answer("NOt found ",false);

            Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
            if (!optionalMeasurement.isPresent())return new Answer("NOt found ",false);

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getPhotoId());
            if (!optionalAttachment.isPresent()) return new Answer("NOt found ",false);

            Product product = new Product();
            product.setName(productDTO.getName());
            product.setCategory(optionalCategory.get());
            product.setMeasurement(optionalMeasurement.get());
            product.setCode("1234");//generate
            product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }

    }

    public Answer update(Integer id ,ProductDTO productDTO){

        try{
            Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
            if (!optionalCategory.isPresent()) return new Answer("NOt found ",false);

            Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
            if (!optionalMeasurement.isPresent())return new Answer("NOt found ",false);

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getPhotoId());
            if (!optionalAttachment.isPresent()) return new Answer("NOt found ",false);

            Optional<Product> optionalProduct = productRepository.findById(id);
            if (!optionalProduct.isPresent()) return new Answer("NOt found ",false);

            Product product = optionalProduct.get();

            product.setName(productDTO.getName());
            product.setCategory(optionalCategory.get());
            product.setMeasurement(optionalMeasurement.get());
            product.setCode("1234");//generate
            product.setPhoto(optionalAttachment.get());
            productRepository.save(product);
            return new Answer("Save success",true);

        }catch (Exception e){
            return new Answer("Server error ",false);
        }


    }

}
