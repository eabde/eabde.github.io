class Dipendente {
    private String nome;
    private String cognome;
    private String indirizzoResidenza;
    private String dataNascita;
    private String dataAssunzione;
    private int oreLavoroSettimanali;
    private String ufficioRepartoAppartenenza;

    public Dipendente(String nome, String cognome, String indirizzoResidenza, String dataNascita,
            String dataAssunzione, int oreLavoroSettimanali, String ufficioRepartoAppartenenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzoResidenza = indirizzoResidenza;
        this.dataNascita = dataNascita;
        this.dataAssunzione = dataAssunzione;
        this.oreLavoroSettimanali = oreLavoroSettimanali;
        this.ufficioRepartoAppartenenza = ufficioRepartoAppartenenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzoResidenza() {
        return indirizzoResidenza;
    }

    public void setIndirizzoResidenza(String indirizzoResidenza) {
        this.indirizzoResidenza = indirizzoResidenza;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(String dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public int getOreLavoroSettimanali() {
        return oreLavoroSettimanali;
    }

    public void setOreLavoroSettimanali(int oreLavoroSettimanali) {
        this.oreLavoroSettimanali = oreLavoroSettimanali;
    }

    public String getUfficioRepartoAppartenenza() {
        return ufficioRepartoAppartenenza;
    }

    public void setUfficioRepartoAppartenenza(String ufficioRepartoAppartenenza) {
        this.ufficioRepartoAppartenenza = ufficioRepartoAppartenenza;
    }
}