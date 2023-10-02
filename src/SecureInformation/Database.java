package SecureInformation;

public interface Database {
    boolean doesUserExist(String email);
    boolean createNewUser(String email, String protectedPass, String protectedKey,
                          String userType);
}
