package com.project.market.persistence.mapper;

import com.project.market.persistence.entity.Categoria;
import com.project.market.domain.Category;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "string")
public interface CategoryMapper {
    @Mappings({
        @Mapping(source = "idCategoria", target = "CategoryId"),
        @Mapping(source = "descipcion", target = "category"),
        @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
