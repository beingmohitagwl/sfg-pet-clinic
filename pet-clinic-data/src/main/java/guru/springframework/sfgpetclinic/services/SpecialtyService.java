package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Specialty;
import org.springframework.context.annotation.Profile;

@Profile("springdatajpa")
public interface SpecialtyService extends CrudService<Specialty, Long> {
}
