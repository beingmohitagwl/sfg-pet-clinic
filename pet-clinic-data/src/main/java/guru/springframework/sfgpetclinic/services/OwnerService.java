package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Specialty;
import org.springframework.context.annotation.Profile;

@Profile("springdatajpa")
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
