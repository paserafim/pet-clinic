package paserafim.springframework.sfgpetclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import paserafim.springframework.sfgpetclinic.model.Owner;
import paserafim.springframework.sfgpetclinic.model.Vet;
import paserafim.springframework.sfgpetclinic.services.OwnerService;
import paserafim.springframework.sfgpetclinic.services.VetService;
import paserafim.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import paserafim.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
