CREATE TABLE pluginev( 
id LONG PRIMARY KEY AUTO_INCREMENT, 
vehiclemake VARCHAR(255), 
vehiclemodel VARCHAR(255),
enginetype VARCHAR(255), 
purchaseDate DATE, 
purchaseTime TIME 
); 

INSERT INTO pluginev(vehiclemake, vehiclemodel, enginetype, purchaseDate, purchaseTime) VALUES 
('GM', 'Volt', 'Electric', '2020-01-01', '12:00:00'), 
('Nissan', 'Leaf', 'Gas Electric', '2020-02-02', '08:15:00'), 
('Hyundai', 'Elantra', 'Hybrid', '2020-03-03', '14:30:00'); 
