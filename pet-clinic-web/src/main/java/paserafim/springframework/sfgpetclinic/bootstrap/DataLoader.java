package paserafim.springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import paserafim.springframework.sfgpetclinic.model.Owner;
import paserafim.springframework.sfgpetclinic.model.PetType;
import paserafim.springframework.sfgpetclinic.model.Vet;
import paserafim.springframework.sfgpetclinic.services.OwnerService;
import paserafim.springframework.sfgpetclinic.services.PetTypeService;
import paserafim.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("fiona");
        owner2.setLastName("Gleanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("duda");
        vet1.setLastName("Serafim");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mateus");
        vet2.setLastName("Serafim");

        vetService.save(vet2);

        System.out.println("loaded Vets.....");




    }
}
