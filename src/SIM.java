import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class SIM {
    private int phoneNumber;
    private float credit;

    private String[] outgoingIDs = new String[10];
    private int[] outgoingTime = new int[10];

    private static int index=0;
    private final static String[] phoneNumbers = new String[10];

    private static boolean checkPhoneNumber(String tempNumber) {
        for (String i : phoneNumbers) {
            if (Objects.equals(tempNumber, i)) {
                return false;
            }
        }
        return true;
    }

    public SIM() {
        Random random = new Random();
        String tempNumber = String.format("369%d", random.nextInt(9999999));

        System.out.println(tempNumber);
        if (checkPhoneNumber(tempNumber)) {
            phoneNumbers[index] = tempNumber;
            index++;
        }

        credit = 0;
    }

    public void addCredit() {
        /* todo */
    }
}
