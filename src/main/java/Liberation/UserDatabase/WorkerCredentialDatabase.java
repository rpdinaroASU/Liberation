package Liberation.UserDatabase;

public class WorkerCredentialDatabase  implements Database {
    @Override
    public boolean doesUserExist(String email) {
        return true;
    }

    @Override
    public boolean createNewUser(String email, String password, String key) {
        return false;
    }
}
