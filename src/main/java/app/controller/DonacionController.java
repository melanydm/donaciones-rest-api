package app.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Donacion;
import app.model.Donacion.moneda;
import app.repository.DonacionRepository;

@RestController
@RequestMapping("/donacion")
public class DonacionController {

  @Autowired
  private DonacionRepository donacionRepository;

  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createDonacion(@RequestBody Map<String, Object> donacionMap){
    Donacion dona = new Donacion(donacionMap.get("transaccionId").toString(),
    	donacionMap.get("fecha").toString(),
    	donacionMap.get("monto").toString(),
    	donacionMap.get("moneda").toString(),
    	donacionMap.get("usuario").toString());

    donacionRepository.save(dona);
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Donacion created successfully");
    response.put("periferico", dona);
    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{transaccionId}")
  public Optional<Donacion> getPerifericoDetails(@PathVariable("transaccionId") String transaccionId){ 
	  return donacionRepository.findOneByTransaccionId(transaccionId);
  }
  
  @RequestMapping(method = RequestMethod.GET, value="/getAll")
  public List<Donacion> getAllDonacion(){ 
	  return donacionRepository.findAll();
  }
  
  @RequestMapping(method = RequestMethod.PUT, value="/{transaccionId}")
  public Map<String, Object> editPeriferico(@PathVariable("transaccionId") String transaccionId,
      @RequestBody Map<String, Object> donacionMap){
    Donacion don = new Donacion(donacionMap.get("transaccionId").toString(),
        	donacionMap.get("fecha").toString(),
        	donacionMap.get("monto").toString(),
        	donacionMap.get("moneda").toString(),
        	donacionMap.get("usuario").toString());

    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Donacion Updated successfully");
    response.put("donacion", donacionRepository.save(don));
    return response;
  }
  
  @RequestMapping(method = RequestMethod.DELETE, value="/{transaccionId}")
  public Map<String, String> deletePeriferico(@PathVariable("transaccionId") String transId){
    donacionRepository.deleteByTransaccionId(transId);
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", "Donacion deleted successfully");

    return response;
  }
  
}