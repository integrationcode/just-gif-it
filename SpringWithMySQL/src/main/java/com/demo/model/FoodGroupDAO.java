package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("foodGroupDAO")
public class FoodGroupDAO {
	private JdbcTemplate myJdbcTemplate;
	private NamedParameterJdbcTemplate myNamedParamJdbcTemplate;
	private SimpleJdbcInsert mySimpleJdbcInsert;
	private SimpleJdbcCall mySimpleJdbcCall;
	
	
	

	public SimpleJdbcCall getMySimpleJdbcCall() {
		return mySimpleJdbcCall;
	}
	
	@Autowired
	public void setMySimpleJdbcCall(DataSource dataSource) {
		this.mySimpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("GET_FOOD_GROUPS");
	}

	public NamedParameterJdbcTemplate getMyNamedParamJdbcTemplate() {
		return myNamedParamJdbcTemplate;
	}

	@Autowired
	@Qualifier(value = "springDS")
	public void setMyNamedParamJdbcTemplate(DataSource dataSource) {
		this.myNamedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public JdbcTemplate getMyJdbcTemplate() {
		return myJdbcTemplate;
	}

	@Autowired
	public void setMyJdbcTemplate(DataSource dataSource) {
		this.myJdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	public SimpleJdbcInsert getMySimpleJdbcInsert() {
		return mySimpleJdbcInsert;
	}
	
	@Autowired
	@Qualifier(value="springDS")
	public void setMySimpleJdbcInsert(DataSource dataSource) {
		this.mySimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("foodgroups").usingGeneratedKeyColumns("id");
	}

	public List<FoodGroup> getFoodGroups(){
		String createTableQuery = "select * from foodgroups";
		return myJdbcTemplate.query(createTableQuery, new RowMapper<FoodGroup>() {
			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodGroup fg = new FoodGroup();
				fg.setId(rs.getInt("id"));
				fg.setName(rs.getString("name"));
				fg.setDescription(rs.getString("description"));
				return fg;
			}
		});		
	}
	
	public List<FoodGroup> getFoodGroupsBasedOnWhere(String name){
		MapSqlParameterSource myMap = new MapSqlParameterSource();
		myMap.addValue("groupName", name);
		
		String query = "select * from foodgroups where name = :groupName";
		
		return myNamedParamJdbcTemplate.query(query, myMap, new RowMapper<FoodGroup>() {
			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodGroup fg = new FoodGroup();
				fg.setId(rs.getInt("id"));
				fg.setName(rs.getString("name"));
				fg.setDescription(rs.getString("description"));
				return fg;
			}
		});
	}

	public FoodGroup getFoodGroupById(int id) {
		MapSqlParameterSource myMap = new MapSqlParameterSource();
		myMap.addValue("id",id);
		String query = "select * from foodgroups where id = :id";
		return myNamedParamJdbcTemplate.queryForObject(query, myMap, new RowMapper<FoodGroup>() {
			public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				FoodGroup fg = new FoodGroup();
				fg.setId(rs.getInt("id"));
				fg.setName(rs.getString("name"));
				fg.setDescription(rs.getString("description"));
				return fg;
			}			
		});
	}
	
	public void createFoodGroups(){
		String createTableQuery = "create table foodgroups (id INT NOT NULL, name VARCHAR(100), description VARCHAR(500))";
		myJdbcTemplate.execute(createTableQuery);
		
		myJdbcTemplate.update("insert into foodgroups values (1,'Fruit','I am fruit. I come from plants and seeds')");
		myJdbcTemplate.update("insert into foodgroups values (2,'Vegetable','I am Vegetable. I come from plants and trees')");
		myJdbcTemplate.update("insert into foodgroups values (3,'Dairy','I am milk product.')");
	}
	
	public boolean addFoodGroups(String name, String description) {
		MapSqlParameterSource myMap = new MapSqlParameterSource();
		myMap.addValue("name", name);
		myMap.addValue("description", description);
		int insertedRows = myNamedParamJdbcTemplate.update("insert into foodgroups (name,description) values(:name,:description)", myMap);
		if(insertedRows>0) {
			System.out.println("Row inserted successfully!");
			return true;
		}
		System.out.println("Couldn't Insert Row!");
		return false;
	}
	
	//Adding based on beans
	public boolean addFoodGroups(FoodGroup fg) {
		BeanPropertySqlParameterSource myMap = new BeanPropertySqlParameterSource(fg);
		int insertedRows = myNamedParamJdbcTemplate.update("insert into foodgroups (name,description) values(:name,:description)", myMap);
		if(insertedRows>0) {
			System.out.println("Row inserted successfully!");
			return true;
		}
		System.out.println("Couldn't Insert Row!");
		return false;
	}
	
	public boolean update(FoodGroup fg) {
		BeanPropertySqlParameterSource myMap = new BeanPropertySqlParameterSource(fg);
		int updatedRow = myNamedParamJdbcTemplate.update("update foodgroups set name=:name, description=:description where id=:id", myMap);
		if(updatedRow>0) {
			System.out.println("Row Updated successfully!");
			return true;
		}
		System.out.println("Couldn't Update Row!");
		return false;
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource myMap = new MapSqlParameterSource();
		myMap.addValue("id", id);
		int updatedRow = myNamedParamJdbcTemplate.update("delete from foodgroups where id=:id", myMap);
		if(updatedRow>0) {
			System.out.println("Row deleted successfully!");
			return true;
		}
		System.out.println("Couldn't Delete Row!");
		return false;
	}

	@Transactional("myTransactionManager")
	public int[] batchUpdate(List<FoodGroup> foodGroups) {
		SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(foodGroups);
		
		return myNamedParamJdbcTemplate.batchUpdate("insert into foodgroups (name,description) values (:name,:description)", batchParams);
	}

	
	public int simpleInsert(FoodGroup fg) {
		SqlParameterSource myParams = new BeanPropertySqlParameterSource(fg);
		Number insertedRow = mySimpleJdbcInsert.executeAndReturnKey(myParams);
		int numOfRowsInserted = insertedRow.intValue();
		//int numOfRowsInserted = mySimpleJdbcInsert.execute(myParams);
		if(numOfRowsInserted>0) {
			System.out.println("Inserted Row with id: " + numOfRowsInserted);			
		}else {
			System.out.println("Not Inserted!");
		}
		return numOfRowsInserted;
	}


	public FoodGroup readFoodGroup(int groupId) {
		MapSqlParameterSource myParms = new MapSqlParameterSource();
		myParms.addValue("IN_ID",groupId);		
		Map<String, Object> outValue = mySimpleJdbcCall.execute(myParms);		
		return new FoodGroup(groupId, (String) outValue.get("GROUP_NAME"), (String) outValue.get("GROUP_DESCRIPTION"));		
	}

	
	public void demoMethod() {
		int count = myJdbcTemplate.queryForObject("select count(1) from foodgroups", Integer.class);
		System.out.println("Number of Rows: " + count);
	}
}
