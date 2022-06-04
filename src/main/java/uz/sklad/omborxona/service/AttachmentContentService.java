package uz.sklad.omborxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.sklad.omborxona.entity.Attachment;
import uz.sklad.omborxona.entity.AttachmentContent;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.repository.AttachmentContentRepository;
import uz.sklad.omborxona.repository.AttachmentRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentContentService {

    @Autowired
    private AttachmentRepository attachmentRepository ;
    @Autowired
    private AttachmentContentRepository attachmentContentRepository ;

    // get all content
    public List<AttachmentContent> getAll(){
        return attachmentContentRepository.findAll();
    }

    //get one content
    public AttachmentContent get(Integer id){

        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);

        if (!optionalAttachmentContent.isPresent()) return new AttachmentContent();

        return optionalAttachmentContent.get();
    }

    //delete
    public Answer delete(Integer id ){

        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        if (!optionalAttachmentContent.isPresent()) return new Answer("Object not found ",false);
        attachmentContentRepository.delete(optionalAttachmentContent.get());
        return new Answer("Success deleted ",true);
    }

    // save

    public Answer save(MultipartHttpServletRequest request){

        try {
            if (request == null) return new Answer("Object is null ",false);
            Iterator<String> fileNames = request.getFileNames();
            while (fileNames.hasNext()){
                AttachmentContent attachmentContent = new AttachmentContent();
                MultipartFile file = request.getFile(fileNames.next());
                Attachment attachment = attachmentRepository.findByName(file.getOriginalFilename());

                attachmentContent.setContent(file.getBytes());
               attachmentContent.setAttachment(attachment);

                attachmentContentRepository.save(attachmentContent);

            }

            return new Answer("Saved object ",true);

        }catch (Exception e){
            return new Answer("Server error.Try again ",false);
        }

    }




}
