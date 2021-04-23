package net.finman.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.finman.dao.ProductDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.exception.ResourceNotUpdatedException;
import net.finman.model.Item;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public void createProduct(Item i) throws ResourceNotCreatedException {
        productDao.createProduct(i);
    }

    @Override
    public List<Item> getProductsOwnedBy(int owner) throws ResourceNotFoundException {
        return productDao.getProductsOwnedBy(owner);
    }

    @Override
    public void deleteProduct(int owner, String name) throws ResourceNotDeletedException, ResourceNotFoundException {
        productDao.deleteProduct(owner, name);
    }

    @Override
    public void updateProduct(int owner, String name, Item item)
            throws ResourceNotFoundException, ResourceNotUpdatedException {
        productDao.updateProduct(owner, name, item);

    }
}