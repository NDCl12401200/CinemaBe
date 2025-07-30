package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.CinemaDto;
import org.cinema.model.dto.VilleDto;

import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double longitude;
    private double latitude;
    private double altitude;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ville")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Cinema> cinemas;

    public static Ville from(VilleDto villeDto){
        Ville ville = new Ville();
        ville.setId(villeDto.getId());
        ville.setNom(villeDto.getNom());
        ville.setLongitude(villeDto.getLongitude());
        ville.setLatitude(villeDto.getLatitude());
        ville.setAltitude(villeDto.getAltitude());
        return ville;
    }
}
