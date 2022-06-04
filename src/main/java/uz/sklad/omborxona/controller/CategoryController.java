package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.sklad.omborxona.entity.AttachmentContent;
import uz.sklad.omborxona.entity.Category;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.payload.CategoryDTO;
import uz.sklad.omborxona.service.AttachmentContentService;
import uz.sklad.omborxona.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public List<Category> getAll(){
        return categoryService.getAll();
    }

    public Category get(@PathVariable  Integer id){
        return categoryService.getOne(id);
    }

    public Answer delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }

    public Answer save(@RequestBody CategoryDTO category){
        return categoryService.save(category);
    }

    public Answer update(@PathVariable Integer id , @RequestBody CategoryDTO categoryDTO){
        return categoryService.update(id,categoryDTO);
    }
}
