package com.project.market.persistence.mapper;

import com.project.market.persistence.entity.Producto;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.project.market.domain.Product;

@Mapper(componentModel = "string", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
        @Mapping(source = "idProducto",target = "productId"),
        @Mapping(source = "nombre",target = "name"),
        @Mapping(source = "idCategoria",target = "categoryId"),
        @Mapping(source = "precioVenta",target = "price"),
        @Mapping(source = "cantidadStock",target = "stock"),
        @Mapping(source = "estado",target = "state"),
        @Mapping(source = "categora",target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
    
}
