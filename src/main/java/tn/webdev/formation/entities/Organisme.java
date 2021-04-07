package tn.webdev.formation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Organisme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgId;

    private String libelle;
    
}
