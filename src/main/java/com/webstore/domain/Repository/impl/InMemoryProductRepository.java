package com.webstore.domain.Repository.impl;

import com.webstore.domain.Product;
import com.webstore.domain.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public List<Product> getAllProducts() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = template.query("SELECT * FROM products" , params, new ProductMapper());
        return result;
    }

    private static final class ProductMapper implements RowMapper<Product>{
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
            Product product = new Product();
            product.setProductId(rs.getString("ID"));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("UNIT_PRICE"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(rs.getString("MANUFACTURER"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition(rs.getString("CONDITION"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
            return product;
        }
    }
}
