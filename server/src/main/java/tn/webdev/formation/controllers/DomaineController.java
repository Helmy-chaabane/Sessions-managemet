package tn.webdev.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.HttpClientErrorException;
import tn.webdev.formation.dao.DomaineRepository;
import tn.webdev.formation.entities.Domaine;

@RestController
@RequestMapping("/domaines")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DomaineController {
    
    @Autowired
    private DomaineRepository domaineRepository;

    @GetMapping(value = "/")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public List<Domaine> getdomaines(){
        return domaineRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public Domaine getAdomaine(@PathVariable Long id){
        return domaineRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public ResponseEntity<String> adddomaine(@RequestBody Domaine domaine){
        domaineRepository.save(domaine);
        return new ResponseEntity<>("Domaine added successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public ResponseEntity<String> updatedomaine(@RequestBody Domaine domaine){
        if(domaine.getId()==null)
            return new ResponseEntity<>("No domaine provided",HttpStatus.BAD_REQUEST);
        if(domaineRepository.findById(domaine.getId())==null)
            return new ResponseEntity<>("No domaine with the provided id",HttpStatus.BAD_REQUEST);

        domaineRepository.save(domaine);
        return new ResponseEntity<>("Domaine updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public ResponseEntity<String> deletealldomaines(){
        domaineRepository.deleteAll();
        return new ResponseEntity<>("All domaines deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMINISTRATEUR')")
    public ResponseEntity<String> deleteadomaine(@PathVariable Long id){
        domaineRepository.deleteById(id);
        return new ResponseEntity<>("Domaine deleted successfully", HttpStatus.OK);
    }

}
