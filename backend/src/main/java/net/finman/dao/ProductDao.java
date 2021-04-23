package net.finman.dao;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.model.Item;

public interface ProductDao {
    void createProduct(Item i) throws ResourceNotCreatedException;

    List<Item> getProductsOwnedBy(int owner) throws ResourceNotFoundException;
}