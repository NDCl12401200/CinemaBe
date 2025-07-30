package org.cinema.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.cinema.model.administrator.Seance;

import java.util.Date;

@Data
public class SeanceDto {
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date heure;

    public static SeanceDto from(Seance seance){
        SeanceDto seanceDto = new SeanceDto();
        seanceDto.setId(seance.getId());
        seanceDto.setHeure(seance.getHeure());
        return seanceDto;
    }
}
