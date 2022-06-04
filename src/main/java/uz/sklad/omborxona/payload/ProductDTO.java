package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    private String name ;

    private Integer photoId  ;


    private Integer measurementId  ;

    private Integer categoryId ;

}
