package Lombok����;


public class LombokTest{
	
	public static void main(String[] args) {
		Model dataObject = Model.builder().id(1)
		.name("dongguangming")
		.password("123456").build();
		System.out.println(dataObject);
		//b add
		//b add 2
	}
}
