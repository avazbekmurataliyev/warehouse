package uz.sklad.omborxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Category;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.CategoryDTO;
import uz.sklad.omborxona.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository ;

    // get all

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    // get one

    public Category getOne(Integer id ){
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (!optionalCategory.isPresent()) return new Category();

        return optionalCategory.get();
    }


    //delete element

    public Answer delete(Integer id){

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()) return new Answer("Object not found ",false);

        categoryRepository.delete(optionalCategory.get());
        return new Answer("Success deleted ",true);

    }


    // save

    public Answer save (CategoryDTO categoryDTO){
        try {

            Category category = new Category();

            category.setName(categoryDTO.getName());
            category.setActive(categoryDTO.isActive());
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getCategoryId());
            if (optionalCategory.isPresent())
            category.setCategory(optionalCategory.get());

            categoryRepository.save(category);
            return new Answer("Saved category",true);

        } catch (Exception e){

        return  new Answer("Server error " , false);
        }

    }


    // update


    public Answer update (Integer id ,CategoryDTO categoryDTO){
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getCategoryId());
            if (!optionalCategory.isPresent()) return new Answer("Object not found",false);
            Category category = optionalCategory.get();

            category.setName(categoryDTO.getName());
            category.setActive(categoryDTO.isActive());
            Optional<Category> optionalCategory1 = categoryRepository.findById(categoryDTO.getCategoryId());
            if (optionalCategory1.isPresent())
                category.setCategory(optionalCategory1.get());

            categoryRepository.save(category);
            return new Answer("update category",true);

        } catch (Exception e){

            return  new Answer("Server error " , false);
        }

    }

}
