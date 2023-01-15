package ca.sheridancollege.ananpune.beans;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlugInEV {
	private Long id; 
	private String vehiclemake;
	private String vehiclemodel; 
	private String enginetype;
	private Date purchaseDate;
	private String purchaseTime;

}
