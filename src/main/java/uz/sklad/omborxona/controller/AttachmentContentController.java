package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.sklad.omborxona.entity.AttachmentContent;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.service.AttachmentContentService;

import java.util.List;

@RestController
@RequestMapping("/file/content")
public class AttachmentContentController {

    @Autowired
    private AttachmentContentService attachmentContentService;

    public List<AttachmentContent> getAll(){
        return attachmentContentService.getAll();
    }

    public AttachmentContent get(@PathVariable Integer id){
        return attachmentContentService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return attachmentContentService.delete(id);
    }

    public Answer save(MultipartHttpServletRequest request){
        return attachmentContentService.save(request);
    }

}
