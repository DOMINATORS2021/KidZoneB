package tn.esprit.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Integer> {



}
