package net.finman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Item;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final String INSERT_PRODUCT = "INSERT INTO Items(owner, name, price) VALUES (:owner, :name, :price)";

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public void createProduct(Item i) throws ResourceNotCreatedException {
        try {
            SqlParameterSource itemParams = new MapSqlParameterSource()
                    .addValue("owner", i.getOwner())
                    .addValue("name", i.getName())
                    .addValue("price", i.getPrice());
            template.update(INSERT_PRODUCT, itemParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Failed to add the item!", e.getMessage());
        }
    }
}
