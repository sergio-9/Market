package com.project.market.persistence;

import com.project.market.domain.repository.ProductRepository;
import com.project.market.persistence.crud.ProductoCrudRepository;
import com.project.market.persistence.entity.Producto;
import com.project.market.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;
import com.project.market.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//indica interaccion con base de datos
public class ProductoRepository  implements ProductRepository{
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public Optional<List<Product>> getByCategoria(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    @Override
    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getScarseProducts(int cantidad){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }
    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    @Override
    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
