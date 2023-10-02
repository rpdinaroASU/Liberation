package SecureInformation;

public class WorkerCredentialDatabase  implements Database{
    @Override
    public boolean doesUserExist(String email) {
        return true;
    }
}
