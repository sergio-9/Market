package com.project.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.project.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //query methods
    List<Producto> findByIdCategoria(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado); 

}
