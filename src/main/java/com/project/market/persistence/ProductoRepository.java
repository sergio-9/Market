package com.project.market.persistence;

import com.project.market.persistence.crud.ProductoCrudRepository;
import com.project.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository//indica interaccion con base de datos
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
