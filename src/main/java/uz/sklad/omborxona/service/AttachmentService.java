    package uz.sklad.omborxona.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.multipart.MultipartHttpServletRequest;
    import uz.sklad.omborxona.entity.Attachment;
    import uz.sklad.omborxona.payload.Answer;
    import uz.sklad.omborxona.repository.AttachmentRepository;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class AttachmentService {

    @Autowired
        private AttachmentRepository attachmentRepository ;


    // get all
        public List<Attachment> getAll(){
            return attachmentRepository.findAll();
        }

        //get one file info

        public Attachment get(Integer id ){
            Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
            if (!optionalAttachment.isPresent()) return new Attachment();

            return optionalAttachment.get();

        }


        // delete file info

        public Answer delete(Integer id ){

            Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
            if (!optionalAttachment.isPresent()) return new Answer("Object not found ",false);
            attachmentRepository.delete(optionalAttachment.get());
            return new Answer("Success deleted ",true);
        }

        // Save file info
        public Answer save(MultipartHttpServletRequest request){

            try {
                if (request == null) return new Answer("Object is null ",false);
                Iterator<String> fileNames = request.getFileNames();
                while (fileNames.hasNext()){
                    Attachment attachment = new Attachment();
                    MultipartFile file = request.getFile(fileNames.next());
                    attachment.setName(file.getOriginalFilename());
                    attachment.setContentType(file.getContentType());
                    attachment.setSize(file.getSize());
                attachmentRepository.save(attachment);

                }

                return new Answer("Saved object ",true);

            }catch (Exception e){
                return new Answer("Server error.Try again ",false);
            }

        }

        //update file info

    }
