package paserafim.springframework.sfgpetclinic.services.map;

import paserafim.springframework.sfgpetclinic.model.Specialty;
import paserafim.springframework.sfgpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtiesService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
