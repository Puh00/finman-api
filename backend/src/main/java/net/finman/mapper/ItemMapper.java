
package net.finman.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.finman.model.InvoiceItem;
import net.finman.model.Item;

public class ItemMapper implements RowMapper<InvoiceItem> {

    @Override
    public InvoiceItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        InvoiceItem item = new InvoiceItem();

        item.setName(rs.getString("name"));
        item.setAmount(rs.getInt("amount"));
        return item;
    }
}
