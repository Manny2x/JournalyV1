package data.logic;

import java.util.Random;

public class IDCreator {

    public static String createID(int length){

        StringBuilder stringBuilder = new StringBuilder();
        while(stringBuilder.length() != 8){
            Random random = new Random();
            stringBuilder.append((char) random.nextInt(256));
        }
        return stringBuilder.toString();
    }
}
