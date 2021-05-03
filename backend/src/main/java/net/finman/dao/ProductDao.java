package net.finman.dao;

import java.util.List;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.exception.ResourceNotUpdatedException;
import net.finman.model.Item;

public interface ProductDao {
    /**
     * Creates a product.
     * 
     * @param item Item to be stored in the database.
     * @throws ResourceNotCreatedException If the sql insertion failed.
     */
    void createProduct(Item item) throws ResourceNotCreatedException;

    /**
     * Retrieves all products related to the specified owner.
     * 
     * @param owner The email of the account that owns the product.
     * @return List of products.
     * @throws ResourceNotFoundException If the sql query found nothing.
     */
    List<Item> getProductsOwnedBy(String owner) throws ResourceNotFoundException;

    /**
     * Deletes a product from an account.
     * 
     * @param owner The email of the account that owns the product.
     * @param name  The name of the product to be deleted.
     * @throws ResourceNotDeletedException If the sql delete failed.
     * @throws ResourceNotFoundException   If the sql quety found nothing.
     */
    void deleteProduct(String owner, String name) throws ResourceNotDeletedException, ResourceNotFoundException;

    /**
     * Updates a product.
     * 
     * @param owner The email of the account that owns the product.
     * @param name  The name of the product to be updated.
     * @param item  The new product.
     * @throws ResourceNotFoundException   If the sql query found nothing.
     * @throws ResourceNotUpdatedException If the sql update failed.
     */
    void updateProduct(String owner, String name, Item item) throws ResourceNotFoundException, ResourceNotUpdatedException;
}