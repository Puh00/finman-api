package net.finman.service;

import net.finman.dao.ProductDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.exception.ResourceNotUpdatedException;
import net.finman.model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public void createProduct(Item item) throws ResourceNotCreatedException {
        productDao.createProduct(item);
    }

    @Override
    public List<Item> getProductsOwnedBy(String owner) throws ResourceNotFoundException {
        return productDao.getProductsOwnedBy(owner);
    }

    @Override
    public void deleteProduct(String owner, String name) throws ResourceNotDeletedException, ResourceNotFoundException {
        productDao.deleteProduct(owner, name);
    }

    @Override
    public void updateProduct(String owner, String name, Item item)
            throws ResourceNotFoundException, ResourceNotUpdatedException {
        productDao.updateProduct(owner, name, item);

    }
}