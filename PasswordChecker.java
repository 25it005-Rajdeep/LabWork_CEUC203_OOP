public class PasswordChecker{
	String pass;
	
	PasswordChecker()
	{
		pass = "ABCDef1234";
	}
	PasswordChecker(String pswd)
	{
		pass = pswd;
	}
	
	int passcheck()
	{
		int count=0;
		boolean x;
		if (pass.length()>= 9)
			count++;
		x = pass.matches(".*[A-Z]*.");
		if(x == true)
			count++;
		x = pass.matches(".\\d.*");
		if(x == true)
			count++;
		
		return count;
	}
	
}