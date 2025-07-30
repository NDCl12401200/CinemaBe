package org.cinema.model.dto;

import lombok.Data;
import org.cinema.model.administrator.Categorie;
@Data
public class CategorieDto {
    private Long id;
    private String name;

    public static CategorieDto from(Categorie categorie) {
        if (categorie == null) return null;

        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setId(categorie.getId());
        categorieDto.setName(categorie.getName());
        return categorieDto;
    }
}
