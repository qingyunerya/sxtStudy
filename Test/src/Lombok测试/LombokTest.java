package Lombok����;


public class LombokTest{
	
	public static void main(String[] args) {
		Model dataObject = Model.builder().id(1)
		.name("dongguangming")
		.password("123456").build();
		System.out.println(dataObject);
		//a add
		//b add
		//b add
		//a add
		//d add
		//c add
	}
}
