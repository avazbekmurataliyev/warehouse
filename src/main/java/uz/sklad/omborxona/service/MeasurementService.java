package uz.sklad.omborxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sklad.omborxona.entity.Currency;
import uz.sklad.omborxona.entity.Measurement;
import uz.sklad.omborxona.payload.Answer;
import uz.sklad.omborxona.repository.CurrencyRepository;
import uz.sklad.omborxona.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    private MeasurementRepository measurementRepository ;

    // get all

    public List<Measurement> getAll(){
        return measurementRepository.findAll();
    }

    // get one

    public Measurement getOne(Integer id ){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);

        if (!optionalMeasurement.isPresent()) return new Measurement();

        return optionalMeasurement.get();
    }


    //delete element

    public Answer delete(Integer id){

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()) return new Answer("Object not found ",false);

        measurementRepository.delete(optionalMeasurement.get());
        return new Answer("Success deleted ",true);

    }


    // save

    public Answer save (Measurement measurement){
        try {

            Measurement measurement1 = new Measurement();

            measurement1.setName(measurement.getName());
            measurement.setActive(measurement.isActive());
            measurementRepository.save(measurement1);
            return new Answer("Saved Measurment",true);

        } catch (Exception e){

        return  new Answer("Server error " , false);
        }

    }


    // update


    public Answer update (Integer id ,Measurement measurement){
        try {
            Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
            if (!optionalMeasurement.isPresent()) return new Answer("Not found error " , false);

            Measurement measurement1 = optionalMeasurement.get();
            if (measurement == null ) return new Answer("Null point object  " , false);
            measurement1.setName(measurement.getName());
            measurement1.setActive(measurement.isActive());

            measurementRepository.save(measurement1);
            return new Answer("Updated ",true);

        } catch (Exception e){

            return  new Answer("Server error " , false);
        }

    }

}
