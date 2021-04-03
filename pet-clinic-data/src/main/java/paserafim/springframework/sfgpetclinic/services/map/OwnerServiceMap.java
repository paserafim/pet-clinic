package paserafim.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import paserafim.springframework.sfgpetclinic.model.Owner;
import paserafim.springframework.sfgpetclinic.model.Pet;
import paserafim.springframework.sfgpetclinic.services.OwnerService;
import paserafim.springframework.sfgpetclinic.services.PetService;
import paserafim.springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                   if(pet.getPetType() != null) {
                       pet.setPetType(petTypeService.save(pet.getPetType()));
                   } else {
                       throw new RuntimeException("Pet Type is Required.");
                   }

                   if(pet.getId() == null){
                       Pet savedPet = petService.save(pet);
                       pet.setId(savedPet.getId());
                   }
                });
            }
            return super.save(object);


        } else {
            return null;
        }


    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String name) {
        return null;
    }
}
