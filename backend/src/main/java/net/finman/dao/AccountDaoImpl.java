package net.finman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.finman.exception.ResourceNotCreatedException;
import net.finman.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String INSERST_ACCOUNT = "INSERT INTO Accounts VALUES (:name, :email, :telephone, :password)";

    @Override
    public void createAccount(Account account) throws ResourceNotCreatedException {
        try{
            SqlParameterSource accountParams = new MapSqlParameterSource()
                    .addValue("name", account.getName())
                    .addValue("email", account.getEmail())
                    .addValue("telephone", account.getTelephone())
                    .addValue("password", account.getPassword());

            template.update(INSERST_ACCOUNT, accountParams);
        } catch (DataAccessException e) {
            throw new ResourceNotCreatedException("Could not create account!", e.getMessage());
        }
    }

}
