import exam_vaccine.VaccinationApplication;
import exam_vaccine.VaccinationCenter;
import exam_vaccine.VaccinationInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApp {

    @Test
    void testDarAltaOK() {

        var vaccination = new VaccinationInfo();
        var result = vaccination.createCenter(6, "Av. Medrano Silva 239");
        Assert.assertEquals(result, "Center created correctly");
    }


    @Test
    void testAdvance() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(1,  "Av. Nicolas de Ribera");
        var result = vaccination.vaccinationAdvance();
        Assert.assertEquals(result, " Vaccination Advance : "+ 0.0 + "\n");
    }


    @Test
    void testCoverage() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(9,  "Av. Nicolas de Ribera");
        var result = vaccination.vaccinationCoverage();
        Assert.assertEquals(result, " Vaccination Coverage : "+ 0.0 + "\n");
    }



    @Test
    void testDarAltaFail() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(5, "Av. Medrano Silva 239");
        var result = vaccination.createCenter(5, "Av. Medrano Silva 239");
        Assert.assertEquals(result, "Center already existed! ");
    }

    @Test
    void testCloseCenterOK() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(4, "Av. Arequipa 343");
        var result = vaccination.closeCenter(4);
        Assert.assertEquals(result, "Successfully deleted");
    }

    @Test
    void testCloseCenterFail() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(4, "Av. Arequipa 343");
        var result = vaccination.closeCenter(10);
        Assert.assertEquals(result, "Vaccination center doesn't exist");
    }

    @Test
    void testNumberCenter() {
        var vaccination = new VaccinationInfo();
        vaccination.createCenter(5, "Av. Medrano Silva 239");
        vaccination.createCenter(4, "Av. Belen 349");
        vaccination.createCenter(9, "Av. Pezet 976");

        var result = String.valueOf(vaccination.numberVaccinationCenter());
        Assert.assertEquals(result, "3");
    }

    @Test
    void testPartialVaccination() {
        var vaccination = new VaccinationInfo();
        var result =  vaccination.showPartialVaccination();
       Assert.assertEquals(result, "Number of partially vaccinated people : "+ 0 + "\n");
    }

    @Test
    void testCompleteVaccination() {
        var vaccination = new VaccinationInfo();
        var result =  vaccination.showCompleteVaccination();
       Assert.assertEquals(result, "Number of people fully vaccinated : "+ 0 + "\n");
    }



    @Test
    void testTime(){
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        Assert.assertTrue(timeElapsed < 3000);
    }

}
