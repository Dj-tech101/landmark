package Utility;

import java.util.Random;

public class randomNumberUtility {
	
	public static int getRanNumber() {
        Random rand = new Random();
        return rand.nextInt(20);
    }

    
}
