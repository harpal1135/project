package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() { return repository.findAll(); }
    public Product getProductById(Long id) { return repository.findById(id).orElse(null); }
    public List<Product> getProductsByCategory(String category) { return repository.findByCategory(category); }
    public Product saveProduct(Product product) { return repository.save(product); }
    public Product updateProduct(Long id, Product product) {
        Product existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setCategory(product.getCategory());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            return repository.save(existing);
        }
        return null;
    }
    public void deleteProduct(Long id) { repository.deleteById(id); }
}
