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
public class Profil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfil;

    private String libelle;
}