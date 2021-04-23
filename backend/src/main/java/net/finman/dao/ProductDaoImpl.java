package net.finman.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.exception.ResourceNotDeletedException;
import net.finman.exception.ResourceNotFoundException;
import net.finman.exception.ResourceNotUpdatedException;
import net.finman.mapper.ProductMapper;
import net.finman.model.Item;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final String INSERT_PRODUCT = "INSERT INTO Items(owner, name, price) VALUES (:owner, :name, :price)";
    private static final String SELECT_ALL = "SELECT * FROM Items WHERE owner=:owner";
    private static final String DELETE_PRODUCT = "DELETE FROM Items WHERE (owner=:owner AND name=:name)";
    private static final String UPDATE_PRODUCT = "UPDATE Items SET name=:newName, price=:price WHERE owner=:owner AND name=:oldName";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public void createProduct(Item item) throws ResourceNotCreatedException {
        try {
            SqlParameterSource itemParams = new MapSqlParameterSource()
                    .addValue("owner", item.getOwner())
                    .addValue("name", item.getName())
                    .addValue("price", item.getPrice());
            template.update(INSERT_PRODUCT, itemParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to add the item!", e.getMessage());
        }
    }

    @Override
    public List<Item> getProductsOwnedBy(int owner) throws ResourceNotFoundException {
        try {
            ProductMapper mapper = new ProductMapper();
            SqlParameterSource itemParams = new MapSqlParameterSource().addValue("owner", owner);
            List<Item> products = template.query(SELECT_ALL, itemParams, mapper);

            if (products.isEmpty())
                throw new ResourceNotFoundException("No items were found");
            return products;
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Error commnucating with database", e.getMessage());
        }
    }

    @Override
    public void deleteProduct(int owner, String name) throws ResourceNotDeletedException, ResourceNotFoundException {
        try {
            SqlParameterSource itemParams = new MapSqlParameterSource()
                    .addValue("owner", owner)
                    .addValue("name", name);

            int affectedRows = template.update(DELETE_PRODUCT, itemParams);
            
            if (affectedRows == 0)
                throw new ResourceNotFoundException("Resource does not exist");
        } catch (DataAccessException e) {
            throw new ResourceNotDeletedException("Failed deleting the item", e.getMessage());
        }
    }

    @Override
    public void updateProduct(int owner, String name, Item item) throws ResourceNotFoundException, ResourceNotUpdatedException {
         try {
            SqlParameterSource itemParams = new MapSqlParameterSource()
                    .addValue("newName", item.getName())
                    .addValue("price", item.getPrice())
                    .addValue("oldName", name)
                    .addValue("owner", owner);

            int affectedRows = template.update(UPDATE_PRODUCT, itemParams);
            
            if (affectedRows == 0)
                throw new ResourceNotFoundException("Resource does not exist");
        } catch (DataAccessException e) {
            throw new ResourceNotUpdatedException("Failed updating the item", e.getMessage());
        }       
    }
}
