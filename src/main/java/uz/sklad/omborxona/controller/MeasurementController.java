package uz.sklad.omborxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.sklad.omborxona.entity.Measurement;
import uz.sklad.omborxona.entity.Supplier;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    private MeasurementService measurementService;

    public List<Measurement> getAll(){
        return measurementService.getAll();
    }

    public Measurement get(@PathVariable  Integer id){
        return measurementService.getOne(id);
    }

    public Answer delete(@PathVariable Integer id){
        return measurementService.delete(id);
    }

    public Answer save(@RequestBody Measurement measurement){
        return measurementService.save(measurement);
    }

    public Answer update(@PathVariable Integer id , @RequestBody Measurement measurement){
        return measurementService.update(id,measurement);
    }
}
