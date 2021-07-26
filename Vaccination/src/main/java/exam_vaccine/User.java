package exam_vaccine;

import java.util.Scanner;
import java.util.logging.Logger;

public class User {
    static final Logger logger = Logger.getLogger(User.class.getName());


    public boolean checkPassword(){
        var scan = new Scanner(System.in);
        logger.info("---------------Log in------------------") ;
        logger.info("Please introduce your name: ") ;
        String name = scan.nextLine();
        logger.info("Please introduce your password: ") ;
        String password = scan.nextLine();
        var pass = new StringBuilder(name).reverse().toString();
        if (pass.equals(password)){
            logger.info("You're logged in! Welcome") ;
            return true;
        }
        else{
            logger.info("Error, invalid password") ;
            return false;
        }

    }
}
