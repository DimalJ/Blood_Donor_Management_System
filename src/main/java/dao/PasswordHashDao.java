package dao;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordHashDao {
	
	
	public String hashPassword(String password) {
		  String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
		  return hashedPassword;
    }
	 public boolean verifyPassword(String enteredPassword, String hashedPassword) {
	        BCrypt.Result result = BCrypt.verifyer().verify(enteredPassword.toCharArray(), hashedPassword);
	        return result.verified;
	    }
	
	public boolean login(String enteredPassword, String savedPassword) {
		
		 // Verify the password
        boolean isPasswordCorrect = verifyPassword(enteredPassword, savedPassword);

        // Check if the password is correct
        if (isPasswordCorrect) {
            return isPasswordCorrect;
        } else {
        	 return isPasswordCorrect=false;
        }
	}
}
