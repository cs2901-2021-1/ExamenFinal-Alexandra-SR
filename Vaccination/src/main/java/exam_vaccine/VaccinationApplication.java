package exam_vaccine;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class VaccinationApplication {
    static final Logger logger = Logger.getLogger(VaccinationApplication.class.getName());

    public static void main(String[] args){
        var user = new User();
        user.checkPassword();
        menu();
    }

    public static void menu(){
        var flag = false;
        var scan = new Scanner(System.in);
        var vaccination=  new VaccinationInfo();
        while (!flag) {
            logger.info("1.Vaccination Advance");
            logger.info("2. Vaccination Coverage");
            logger.info("3. Number of Vaccination Centers");
            logger.info("4. Number of partially vaccinated people");
            logger.info("5. Number of people fully vaccinated");
            logger.info("6. Create vaccination center");
            logger.info("7. Close vaccionation center");
            logger.info("8. Log out ");
            try {
                logger.info("Choose an option (1-6): ");
                Integer option = scan.nextInt();
                switch (option) {
                    case 1: {
                        vaccination.vaccinationAdvance();
                        flag = true;
                        break;
                    }
                    case 2:{
                        vaccination.vaccinationCoverage();
                        flag = true;
                        break;
                    }
                    case 3:{
                        Integer number = vaccination.numberVaccinationCenter();
                        var result = "Number of Vaccination Centers : "+ number + "\n";
                        logger.info(result);
                        flag = true;
                        break;
                    }

                    case 4:{
                        vaccination.showPartialVaccination();
                        flag = true;
                        break;

                    }
                    case 5:{
                        vaccination.showCompleteVaccination();
                        flag = true;
                        break;
                    }
                    case 6:{
                        var scanCenter = new Scanner(System.in);
                        logger.info("Please introduce the address of the center: ") ;
                        String address = scanCenter.nextLine();
                        logger.info("Please introduce the id (Integer number): ") ;
                        Integer id = scanCenter.nextInt();
                        vaccination.createCenter( id, address);
                        flag = true;
                        break;
                    }
                    case 7:{
                        var scanDelete = new Scanner(System.in);
                        logger.info("Please introduce the id of the center (Integer number): ") ;
                        Integer id = scanDelete.nextInt();
                        vaccination.closeCenter(id);
                        flag = true;
                        break;
                    }
                    case 8:
                        logger.info("Logged out ");
                        flag = true;
                        break;
                    default:
                        logger.info("Only numbers between 1 and 6 ");
                }
            } catch (InputMismatchException e) {
                logger.info("Input is an integer number");
            }
        }

    }
}
