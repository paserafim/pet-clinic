package paserafim.springframework.sfgpetclinic.services;

import paserafim.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);
}
