public class Ex2Exception {
	
	public static void main(String[] args) {
		Ex2Exception ex2 = new Ex2Exception();
		ex2.launch();
	}
	
	public void launch() {
		try{
			String str = null;
			int i = str.length();
		} catch (Exception ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) { //null pointer exception already gets caught in previous catch
			ex.printStackTrace();
		}
	}
}