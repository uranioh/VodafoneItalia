import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        SIM[] sims = new SIM[10];
        for (int i = 0; i < sims.length; i++) {
            sims[i] = new SIM();
        }

        System.out.println("Inserisci l'ID della SIM [0-9]: ");
        int simID = s.nextInt();

        boolean loopStatus = true;
        while (loopStatus) {
            System.out.printf("""
                    SIM ID: %d
                    Numero di telefono: %s
                    Credito: %.2f
                    
                    1. Effettua una chiamata
                    2. Ricarica credito
                    3. Mostra registro chiamate effettuate
                    
                    0. Logout
                    """,
                    simID, sims[simID].getPhoneNumber(), sims[simID].getCredit());

            switch (s.nextInt()) {
                case 1 -> {

                }

                case 2 -> {
                    System.out.println("Inserisci l'importo da ricaricare: ");
                    sims[simID].addCredit(s.nextInt());
                }

                case 3 -> sims[simID].getOutgoingList();

                case 0 -> loopStatus = false;
            }
        }
    }
}