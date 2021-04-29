package net.finman.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.finman.model.Item;

public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setOwner(rs.getString("owner"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getInt("price"));
        item.setAmount(rs.getInt("amount"));
        return item;
    }
}
