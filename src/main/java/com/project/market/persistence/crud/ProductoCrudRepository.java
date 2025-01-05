package com.project.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.project.market.persistence.entity.Producto;
import java.util.List;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //query methods
    List<Producto> findByIdCategoria(Integer idCategoria);
}
