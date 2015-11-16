public class Patient {
	
	String name;
	int age;
	
	public Patient(String name, int age) {
		try {
			if(age < 0 || age > 130) {
				//RuntimeException ex = new RuntimeException("IllegalArgumentException");
				//throw ex;
				throw new RuntimeException("IllegalArgumentException");
			}
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		this.name = name;
		this.age = age;
	}
	
}