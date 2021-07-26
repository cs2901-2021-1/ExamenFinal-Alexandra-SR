import exam_vaccine.User;
import exam_vaccine.VaccinationApplication;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class test {

    @Test
    void testUser() {
        var user = new User();
        user.checkPassword();
        assertTrue(true, "ela");
    }

    @Test
    void testTime(){
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        Assert.assertTrue(timeElapsed < 3000);
    }

}
