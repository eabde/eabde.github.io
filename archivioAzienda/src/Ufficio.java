import java.util.ArrayList;
import java.util.List;

class Ufficio {
    private String nomeUfficioReparto;
    private int piano;
    private String siglaLocale;
    private int numeroPostazioni;
    private String responsabile;
    private List<Dipendente> dipendenti;

    public Ufficio(String nomeUfficioReparto, int piano, String siglaLocale, int numeroPostazioni,
            String responsabile) {
        this.nomeUfficioReparto = nomeUfficioReparto;
        this.piano = piano;
        this.siglaLocale = siglaLocale;
        this.numeroPostazioni = numeroPostazioni;
        this.responsabile = responsabile;
        this.dipendenti = new ArrayList<>();
    }

    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }

    public void rimuoviDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public String getNomeUfficioReparto() {
        return nomeUfficioReparto;
    }

    public void setNomeUfficioReparto(String nomeUfficioReparto) {
        this.nomeUfficioReparto = nomeUfficioReparto;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public String getSiglaLocale() {
        return siglaLocale;
    }

    public void setSiglaLocale(String siglaLocale) {
        this.siglaLocale = siglaLocale;
    }

    public int getNumeroPostazioni() {
        return numeroPostazioni;
    }

    public void setNumeroPostazioni(int numeroPostazioni) {
        this.numeroPostazioni = numeroPostazioni;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

}
