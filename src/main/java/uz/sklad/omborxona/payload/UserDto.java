package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName ;

    private String lastName ;

    private String phoneNumber ;

    private String password ;

    private List<Integer> warehouseId ;

    private boolean active ;
}
