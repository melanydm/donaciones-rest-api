package app.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Periferico;
import app.repository.PerifericoRepository;

@RestController
@RequestMapping("/periferico")
public class PerifericoController {

  @Autowired
  private PerifericoRepository perifericoRepository;

  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createPeriferico(@RequestBody Map<String, Object> perifericoMap){
    Periferico per = new Periferico(perifericoMap.get("nombre").toString(),
        perifericoMap.get("password").toString());

    perifericoRepository.save(per);
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Periferico created successfully");
    response.put("periferico", per);
    return response;
  }

  @RequestMapping(method = RequestMethod.GET, value="/{perifericoNombre}")
  public Optional<Periferico> getPerifericoDetails(@PathVariable("perifericoNombre") String perifericoNombre){ 
	  return perifericoRepository.findOneByNombre(perifericoNombre);
  }
  
  @RequestMapping(method = RequestMethod.PUT, value="/{perifericoId}")
  public Map<String, Object> editPeriferico(@PathVariable("perifericoId") String perifNombre,
      @RequestBody Map<String, Object> perMap){
    Periferico per = new Periferico(perMap.get("nombre").toString(),
        perMap.get("password").toString());
    per.setNombre(perifNombre);

    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Periferico Updated successfully");
    response.put("periferico", perifericoRepository.save(per));
    return response;
  }
  
  @RequestMapping(method = RequestMethod.DELETE, value="/{perifericoId}")
  public Map<String, String> deletePeriferico(@PathVariable("perifericoId") String perifId){
    perifericoRepository.deleteById(perifId);
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", "Periferico deleted successfully");

    return response;
  }
  
}