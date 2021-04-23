package net.finman.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.finman.dao.ProductDao;
import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Item;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public void createProduct(Item i) throws ResourceNotCreatedException {
        productDao.createProduct(i);
    }
}