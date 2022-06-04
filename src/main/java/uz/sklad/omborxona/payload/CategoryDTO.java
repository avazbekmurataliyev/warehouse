package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDTO {


    private String name ;

    private boolean active ;

    private Integer categoryId ;

}
