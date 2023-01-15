package ca.sheridancollege.ananpune.database;

import java.time.LocalDate;



import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


import ca.sheridancollege.ananpune.beans.PlugInEV;




@Repository
public class DatabaseAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void insertPlugInEV() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query="INSERT INTO pluginev(vehiclemake,vehiclemodel,enginetype,purchaseDate, purchaseTime) VALUES ('Honda','Civic','Electric','2022-01-01','12:00:00' )";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0) 
			System.out.println("Inserted EV into database.");
	}

	public void insertPlugInEV(String vehiclemake, String vehiclemodel, String enginetype, Date purchaseDate, String purchaseTime) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("vehiclemake", vehiclemake);
		namedParameters.addValue("vehiclemodel", vehiclemodel);
		namedParameters.addValue("enginetype", enginetype);
		namedParameters.addValue("purchaseDate", purchaseDate);
		namedParameters.addValue("purchaseTime", purchaseTime);
		String query="INSERT INTO pluginev(vehiclemake,vehiclemodel,enginetype,purchaseDate, purchaseTime) VALUES (:vehiclemake,:vehiclemodel,:enginetype,:purchaseDate,:purchaseTime)";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0) 
			System.out.println("Inserted EV into database.");
	}
	public void deletePlugInEV(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM pluginev WHERE id = :id";
		namedParameters.addValue("id", id);
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
		System.out.println("Deleted EV " + id + " from database");
		}
	
	public List<PlugInEV> getPlugInEVs() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM pluginev";
		return jdbc.query(query, namedParameters, new
		BeanPropertyRowMapper<PlugInEV>(PlugInEV.class));
	}
	public List<PlugInEV> getPlugInEVById(Long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM pluginev WHERE id = :id";
		namedParameters.addValue("id", id);
		
		return jdbc.query(query, namedParameters, new
		BeanPropertyRowMapper<PlugInEV>(PlugInEV.class));
		}
	

}
