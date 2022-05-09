package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.ifaces.CrudRepository;

@Repository
public class ProductRepository implements CrudRepository<Product> {
	
	
	@Autowired
	public ProductRepository(JdbcTemplate template) {
		super();
		this.template = template;
	}

	private JdbcTemplate template;

	@Override
	public int add(Product t) {
		
		String sql = "insert into sathiyaa_product values(?,?,?)";
		
		return template.update(sql,t.getProductId(),t.getProductName(),t.getPrice());
	}

	@Override
	public List<Product> findAll() {
		
		String sql = "select * from sathiyaa_product";
		return template.query(sql,
				BeanPropertyRowMapper.newInstance(Product.class));
		
	}

	@Override
	public Optional<Product> findById(int id) {
		Optional<Product> opt = Optional.empty();
		try {
			String sql ="select * from sathiyaa_product where product_id = ? ";
			Product ptr= template.queryForObject(sql,BeanPropertyRowMapper.newInstance(Product.class),id);
			opt= Optional.of(ptr);
		} catch (Exception e) {
		}
		return opt;
	}

	@Override
	public int update(Product t) {
		String sql = "update sathiyaa_product set product_name=?,price=? where product_Id = ?";
		return template.update(sql,t.getProductName(),t.getPrice(),t.getProductId());
	}

	@Override
	public int remove(int id) {
		String sql = "Delete from sathiyaa_product where product_Id =?";
		return template.update(sql,id);
	}


}
