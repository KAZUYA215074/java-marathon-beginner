package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;


//@Repository
@Repository
public class Ex20Repository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<User>USER_ROW_MAPPER = 
			(rs,i)->{
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				return user;
			};

	public User load(Integer id) {
		String sql = "SELECT id,name,age,address FROM info WHERE id=:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		User user = template.queryForObject(sql, param, USER_ROW_MAPPER);

		return user;
	}
	
	public List<User> findAll(){
		String sql="SELECT id,name,age,address FROM info";
		
		List<User> userList = template.query(sql, USER_ROW_MAPPER);
		
		return userList;
	}

	public User save(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);

		if (user.getId() == null) {
			String sql = "INSERT INTO  (name,age,address) VALUES (:name,:age,:address)";
			template.update(sql, param);
		} else {
			String sql = "UPDATE info SET name=:name,age=:age,address=:address WHERE id=:id";
			template.update(sql, param);
		}

		return user;
	}

	public void deleteById(Integer id) {
		String sql = "DELETE FROM infi WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}

}
