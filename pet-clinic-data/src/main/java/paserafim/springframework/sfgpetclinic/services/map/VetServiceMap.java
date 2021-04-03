package paserafim.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import paserafim.springframework.sfgpetclinic.model.Specialty;
import paserafim.springframework.sfgpetclinic.model.Vet;
import paserafim.springframework.sfgpetclinic.services.SpecialtyService;
import paserafim.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialty().size() > 0) {
            object.getSpecialty().forEach(specialty -> {
               if(specialty.getId() == null) {
                   Specialty savedSpecialty = specialtyService.save(specialty);
                   specialty.setId(savedSpecialty.getId());
               }
            });
        }
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
