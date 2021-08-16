package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService1) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService1;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            extracted();
    }

    private void extracted() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saveRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty saveSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty saveDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ross");
        owner1.setLastName("Gellar");
        owner1.setAddress("123 Central Park");
        owner1.setCity("New York");
        owner1.setTelephone("123123123");

        Pet rossPet = new Pet();
        rossPet.setPetType(savedDogPetType);
        rossPet.setOwner(owner1);
        rossPet.setBirthDate(LocalDate.now());
        rossPet.setName("Marcelle");
        owner1.getPets().add(rossPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Chandler");
        owner2.setLastName("Bing");
        owner2.setAddress("321 Central Park");
        owner2.setCity("New York");
        owner2.setTelephone("123123123");

        Pet chandlerPet = new Pet();
        chandlerPet.setPetType(savedCatPetType);
        chandlerPet.setOwner(owner1);
        chandlerPet.setBirthDate(LocalDate.now());
        chandlerPet.setName("Marcelle");
        owner2.getPets().add(chandlerPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Monica");
        vet1.setLastName("Gellar");
        vet1.getSpecialties().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rachel");
        vet2.setLastName("Green");
        vet2.getSpecialties().add(saveDentistry);
        vet2.getSpecialties().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
