package tn.esprit.kidzone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kidzone.entity.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {

}
