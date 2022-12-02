import java.util.Objects;
import java.util.Random;

public class SIM {
    private final String phoneNumber;
    private float credit;

    private final String[] outgoingIDs = new String[10];
    private final int[] outgoingTime = new int[10];
    private int outgoingIndex = 0;

    //    Array of existing phone numbers and index
    private final static String[] phoneNumbers = new String[10];
    private static int phoneNumbersIndex = 0;

    private static boolean checkPhoneNumber(String tempNumber) {
        for (String num : phoneNumbers) {
            if (Objects.equals(tempNumber, num)) {
                return false;
            }
        }
        return true;
    }

    private String generatePhoneNumber() {
        Random random = new Random();
        return String.format("369%d", random.nextInt(9999999));
    }

    private String newPhoneNumber() {
        String tempNumber = generatePhoneNumber();
        while (!checkPhoneNumber(tempNumber)) {
            tempNumber = generatePhoneNumber();
        }
        return tempNumber;
    }

    public SIM() {
        String tempNumber = newPhoneNumber();
        phoneNumbers[phoneNumbersIndex] = tempNumber;
        phoneNumber = tempNumber;
        phoneNumbersIndex++;

        credit = 5.00F;
    }

    public void addCredit(float creditToAdd) {
        if (creditToAdd > 0) {
            credit += creditToAdd;
        }
    }

    public void makeCall(String callerID, int callDuration) {
        outgoingIDs[outgoingIndex] = callerID;
        outgoingTime[outgoingIndex] = callDuration;
        outgoingIndex++;
    }

    public void getOutgoingList() {
        for (int i = 0; i < outgoingIndex; i++) {
            System.out.printf("%d. To: %s -> %dmin %n", i, outgoingIDs[i], outgoingTime[i]);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getCredit() {
        return credit;
    }
}
