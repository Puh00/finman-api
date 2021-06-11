package net.finman.mapper;

import net.finman.model.UserCustomer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<UserCustomer> {

    @Override
    public UserCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setEmail(rs.getString("email"));
        userCustomer.convertAndSetCustomerJsonToObject(rs.getString("customer"));
        return userCustomer;
    }

}