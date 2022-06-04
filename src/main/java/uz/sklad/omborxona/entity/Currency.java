package uz.sklad.omborxona.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.sklad.omborxona.entity.template.Template;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Currency extends Template {
}
