package exam_vaccine;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class VaccinationInfo {
    static final Logger logger = Logger.getLogger(VaccinationInfo.class.getName());
    private HashMap<Integer, VaccinationCenter> vaccinationCenter =  new HashMap<>();
    Integer totalVaccinationCompleted;
    Integer totalVaccinationPartial;
    private static VaccinationInfo instance = null;
    public static VaccinationInfo getInstance(){
        if (instance == null){
            instance = new VaccinationInfo();
        }
        return instance;
    }

    public VaccinationInfo() {
        totalVaccinationCompleted =0;
        totalVaccinationPartial = 0;
    }

    public String createCenter(Integer id, String address){
        if (vaccinationCenter.containsKey(id)){
            logger.info("Center already existed! ");
            return ("Center already existed! ");
        }

        else{
            var center = new VaccinationCenter(id, address);
            vaccinationCenter.put(id, center);
            logger.info("Center created correctly");
            return ("Center created correctly");

        }

    }



    public String vaccinationAdvance(){
        var result= "";
        var builder = new StringBuilder();
        var it = vaccinationCenter.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, VaccinationCenter> pair = it.next();
            var center = pair.getValue();
            var vacc =  center;
            result = String.valueOf(builder.append(" Vaccination Advance : "+ vacc.advace() + "\n"));
            logger.info(result);
            it.remove();
        }
        return result;
    }

    public String vaccinationCoverage(){
        var it = vaccinationCenter.entrySet().iterator();
        var result= "";
        var builder = new StringBuilder();
        while (it.hasNext()) {
            Map.Entry<Integer, VaccinationCenter> pair = it.next();
            var center = pair.getValue();
            var vacc =  center;
            result = String.valueOf(builder.append(" Vaccination Coverage : "+ vacc.coverage() + "\n"));
            logger.info(result);
            it.remove();
        }
        return result;
    }

    public String closeCenter(Integer id){
        if (vaccinationCenter.containsKey(id)){
            vaccinationCenter.remove(id);
            return "Successfully deleted";
        }
        else{
            logger.info("Vaccination center doesn't exist");
            return "Vaccination center doesn't exist";
        }

    }

    public Integer  numberVaccinationCenter(){
        return  vaccinationCenter.size();
    }

    public void partialVaccination(int number){
        totalVaccinationCompleted+= number;
    }

    public void completeVaccination(int number){
        totalVaccinationPartial+= number;
    }

    public String showPartialVaccination(){
        var result = "Number of partially vaccinated people : "+ totalVaccinationPartial + "\n";
        logger.info(result);
        return  result;
    }

    public String showCompleteVaccination(){
        var result = "Number of people fully vaccinated : "+ totalVaccinationCompleted + "\n";
        logger.info(result);
        return result;
    }
}
