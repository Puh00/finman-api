package net.finman.dao;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Item;

public interface ProductDao {
    void createProduct(Item i) throws ResourceNotCreatedException;
}