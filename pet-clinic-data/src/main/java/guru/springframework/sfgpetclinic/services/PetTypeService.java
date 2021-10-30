package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.context.annotation.Profile;

@Profile("springdatajpa")
public interface PetTypeService extends CrudService<PetType, Long> {
}
