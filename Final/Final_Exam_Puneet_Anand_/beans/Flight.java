package ca.sheridancollege.ananpune.beans;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	private Long id; 
	private String flightnumber;
	private String airline; 
	private String airplane;
	private Date departureDate;
	private String departureTime;

}
