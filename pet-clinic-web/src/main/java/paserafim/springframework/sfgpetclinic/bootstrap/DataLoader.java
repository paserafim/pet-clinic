package paserafim.springframework.sfgpetclinic.bootstrap;


import antlr.ASTNULLType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import paserafim.springframework.sfgpetclinic.model.*;
import paserafim.springframework.sfgpetclinic.services.OwnerService;
import paserafim.springframework.sfgpetclinic.services.PetTypeService;
import paserafim.springframework.sfgpetclinic.services.SpecialtyService;
import paserafim.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Rediology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Weston");
        owner1.setAddress("Rua de Cima, 122");
        owner1.setCity("Braga");
        owner1.setTelephone("2538999888");

        Pet mikePet = new Pet();
        mikePet.setName("Ralph");
        mikePet.setOwner(owner1);
        mikePet.setPetType(savedDogType);
        mikePet.setBirthDate(LocalDate.now());

        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("Av completa, 333");
        owner2.setCity("Porto");
        owner2.setTelephone("22899999333");

        Pet fionaCat = new Pet();
        fionaCat.setName("gatinho");
        fionaCat.setOwner(owner2);
        fionaCat.setPetType(savedCatType);
        fionaCat.setBirthDate(LocalDate.now());

        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("duda");
        vet1.setLastName("Serafim");
        vet1.getSpecialty().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mateus");
        vet2.setLastName("Serafim");
        vet2.getSpecialty().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("loaded Vets.....");
    }
}
