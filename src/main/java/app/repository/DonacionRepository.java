package app.repository;

import app.model.Donacion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonacionRepository extends MongoRepository<Donacion, String>{
	
    public Optional<Donacion> findOneByTransaccionId(String transaccionId);
    //public List<Donacion> getAll();
    // public void delete(String nombre);
	public void deleteByTransaccionId(String transId);

}