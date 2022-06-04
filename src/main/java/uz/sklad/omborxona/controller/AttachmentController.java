package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.sklad.omborxona.entity.Attachment;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.service.AttachmentService;

import java.util.List;

@RestController
@RequestMapping("/file")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    public List<Attachment> getAll(){
        return attachmentService.getAll();
    }

    public Attachment get(@PathVariable Integer id){
        return attachmentService.get(id);
    }

    public Answer delete(@PathVariable Integer id){
        return attachmentService.delete(id);
    }

    public Answer save(MultipartHttpServletRequest request){
        return attachmentService.save(request);
    }

}
