package net.finman.service;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Item;

public interface ProductService {
    void createProduct(Item i) throws ResourceNotCreatedException;
}
