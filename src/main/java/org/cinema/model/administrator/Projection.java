package org.cinema.model.administrator;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cinema.model.dto.FilmDto;
import org.cinema.model.dto.ProjectionDto;
import org.cinema.model.dto.TicketDto;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double prix;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="projection")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_film")
    private Film film;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "id_salle")
    private Salle salle;
    @ManyToOne
    private Seance seance;

    public static Projection from(ProjectionDto projectionDto){
        Projection projection = new Projection();
        projection.setId(projectionDto.getId());
        projection.setDate(projectionDto.getDate());
        projection.setPrix(projectionDto.getPrix());
        return projection;
    }
}
