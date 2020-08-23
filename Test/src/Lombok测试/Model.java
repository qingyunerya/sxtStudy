package Lombok≤‚ ‘;

import lombok.Builder;
import lombok.Data;  
import lombok.Getter;  
import lombok.Setter; 
@Data  
@Builder
public class Model{
	
	private int id;     
    private String name;     
    private String password;    
}
