import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GestioneFile gf = new GestioneFile();
        List<Ufficio> uffici = null;

        File file = new File("azienda.xml");
        if (file.exists()) {
            uffici = gf.caricaXML("azienda.xml");
        } else {
            uffici = new ArrayList<>();
        }

        Dipendente dipendente1 = new Dipendente("Nome1", "Cognome1", "Indirizzo1", "DataNascita1", "DataAssunzione1",
                40, "Ufficio1");
        Dipendente dipendente2 = new Dipendente("Nome2", "Cognome2", "Indirizzo2", "DataNascita2", "DataAssunzione2",
                30, "Ufficio1");
        Dipendente dipendente3 = new Dipendente("Nome3", "Cognome3", "Indirizzo3", "DataNascita3",
                "DataAssunzione3", 40, "Ufficio2");
       
        Ufficio ufficio1 = new Ufficio("Ufficio1", 1, "Locale1", 10, "Responsabile1");
        ufficio1.aggiungiDipendente(dipendente1);
        ufficio1.aggiungiDipendente(dipendente2);

        Ufficio ufficio2 = new Ufficio("Ufficio2", 1, "Locale2", 20, "Responsabile2");
        ufficio2.aggiungiDipendente(dipendente3);

        uffici.add(ufficio1);
        uffici.add(ufficio2);

        gf.salvaXML("azienda.xml", uffici);
    }
}
