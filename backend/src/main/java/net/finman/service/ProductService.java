package net.finman.service;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Item;

public interface ProductService {
    void createProduct(Item i) throws ResourceNotCreatedException;

    List<Item> getProductsOwnedBy(int owner) throws ResourceNotFoundException;

    void deleteProduct(int owner, String name) throws ResourceNotDeletedException, ResourceNotFoundException;
}
