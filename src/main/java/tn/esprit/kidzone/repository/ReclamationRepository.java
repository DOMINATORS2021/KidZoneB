package tn.esprit.kidzone.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kidzone.entity.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Integer> {



}
