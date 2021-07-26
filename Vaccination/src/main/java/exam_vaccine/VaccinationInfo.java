package exam_vaccine;
import java.util.HashMap;
import java.util.logging.Logger;

public class VaccinationInfo {
    static final Logger logger = Logger.getLogger(VaccinationInfo.class.getName());
    private HashMap<Integer, VaccinationCenter> vaccinationCenter =  new HashMap<>();
    private HashMap<String, Integer> ageVaccionation = new HashMap<> ();
    Integer totalVaccinationCompleted;
    Integer totalVaccinationPartial;
    private static VaccinationInfo instance = null;
    public static VaccinationInfo getInstance(){
        if (instance == null){
            instance = new VaccinationInfo();
        }
        return instance;
    }


    void getData(){
        ageVaccionation = new HashMap<>();
        ageVaccionation.put("From 18 to 39", 11334787);
        ageVaccionation.put("From 40 to 49", 4183174);
        ageVaccionation.put("From 50 to 59", 3277134);
        ageVaccionation.put("From 60 to 69", 2221241);
        ageVaccionation.put("From 70 to 79", 1271842);
        ageVaccionation.put("From 80 to more", 647355);
    }

    public void createCenter(Integer id,  String address){
        if (vaccinationCenter.containsKey(id))
            logger.info("Center already existed! ");
        else{
            var center = new VaccinationCenter(id, address);
            vaccinationCenter.put(id, center);
            logger.info("Center created correctly");

        }

    }



    public void vaccinationAdvance(){
        createCenter(1,  "Av. Nicolas de Ribera");
        var it = vaccinationCenter.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = it.next();
            var center = pair.getValue();
            var vacc = (VaccinationCenter) center;
            var result = " Vaccination Advance : "+ vacc.advace() + "\n";
            logger.info(result);
            it.remove();
        }
    }

    public void vaccinationCoverage(){
        createCenter(2,  "Jr. Medrano Silva");
        var it = vaccinationCenter.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = it.next();
            var center = pair.getValue();
            var vacc = (VaccinationCenter) center;
            var result = " Vaccination Coverage : "+ vacc.coverage() + "\n";
            logger.info(result);
            it.remove();
        }
    }

    public void closeCenter(Integer id){
        if (vaccinationCenter.containsKey(id))
            vaccinationCenter.remove(id);
        else
            logger.info("Vaccination center doesn't exist");
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

    public void showPartialVaccination(){
        var result = "Number of partially vaccinated people : "+ totalVaccinationPartial + "\n";
        logger.info(result);
    }

    public void showCompleteVaccination(){
        var result = "Number of people fully vaccinated : "+ totalVaccinationCompleted + "\n";
        logger.info(result);
    }
}
