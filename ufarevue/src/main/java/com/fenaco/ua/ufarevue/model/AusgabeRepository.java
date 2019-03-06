package com.fenaco.ua.ufarevue.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AusgabeRepository extends CrudRepository<Ausgabe, Long> {

}
