package Liberation;

import Liberation.SecureInformation.StaffLoginSystem;
import Liberation.SecureInformation.UserManagement;

public class Main {
    public static void main(String[] args) {
        UserManagement management = new UserManagement(null);
        StaffLoginSystem loginSystem = new StaffLoginSystem(null);
        for(int x = 0; x < 100;x++) {
            //System.out.println(management.generateTempPassword());
        }
    }
}