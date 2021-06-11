package net.finman.mapper;

import net.finman.model.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setOwner(rs.getString("owner"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getInt("price"));
        return item;
    }
}