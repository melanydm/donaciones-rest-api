package app.repository;

import app.model.Periferico;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerifericoRepository extends MongoRepository<Periferico, String>{
	
    public Optional<Periferico> findOneByNombre(String name);
    
    // public void delete(String nombre);

}