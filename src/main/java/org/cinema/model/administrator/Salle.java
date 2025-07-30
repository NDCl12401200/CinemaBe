package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.CinemaDto;
import org.cinema.model.dto.SalleDto;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cinema")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "salle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;

    public static Salle from(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setName(salleDto.getName());
        salle.setNombrePlaces(salleDto.getNombrePlaces());
        salle.setCinema(Cinema.from(salleDto.getCinemaDto()));
        salle.setId(salleDto.getId());
        salle.setId(salleDto.getId());
        return salle;
    }

}
