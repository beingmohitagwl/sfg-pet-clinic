package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.context.annotation.Profile;

import java.util.Set;

@Profile("springdatajpa")
public interface VetService extends CrudService<Vet, Long> {

}
