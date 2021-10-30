package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Profile("springdatajpa")
public interface PetService extends CrudService<Pet, Long> {

}
