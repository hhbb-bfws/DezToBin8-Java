import java.io.Console;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Console console = System.console();
            if (console == null) {
                System.out.println("No console available");
                //return;
            }

            System.out.println("\nDezToBin8");
            String strEnde = "";

            while (strEnde != "e") {
                System.out.print("\nBitte Zahl im Dezimalsystem eingegebn (0..255): ");
                String strDez = reader.readLine();
                //String strZahl = System.console().readLine();

                DezToBin8(strDez);

                System.out.print("\nProgramm be(e)nden? ");
                strEnde = reader.readLine();
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }

    private static String DezToBin8(String strDez) {
        String strBin = "";
        Integer nDez = Integer.parseInt(strDez);


        if ((nDez >= 0) && (nDez < 256)) {

            Integer nMod = 0;
            Integer nDiv = nDez;

            for (int i = 0; i < 8; i++) {
                nMod = nDiv % 2;
                nDiv = nDiv / 2;
                strBin = nMod.toString() + strBin;
            }

            System.out.println(strDez + " lautet im Binärsystem: " + strBin);
        } else if (nDez < 0) {
            System.out.println("Fehler, Zahl zu klein!");
        } else {
            System.out.println("Fehler, Zahl zu groß!");
        }
        return strBin;
    }
}
