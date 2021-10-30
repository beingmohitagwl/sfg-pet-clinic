package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Visit;
import org.springframework.context.annotation.Profile;

@Profile("springdatajpa")
public interface VisitService extends CrudService<Visit, Long> {
}
