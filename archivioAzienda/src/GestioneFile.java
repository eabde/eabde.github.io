import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GestioneFile {
    public void salvaXML(String nomeFile, List<Ufficio> uffici) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crea un nuovo documento XML
            Document doc = docBuilder.newDocument();

            // Crea l'elemento radice "Azienda"
            Element radice = doc.createElement("Azienda");
            doc.appendChild(radice);

            // Per ogni ufficio, crea un elemento "ufficio" e aggiungi i suoi dati
            for (Ufficio ufficio : uffici) {
                Element elementoUfficio = doc.createElement("ufficio");
                radice.appendChild(elementoUfficio);

                // Aggiungi gli attributi dell'ufficio come elementi
                Element nomeUfficioReparto = doc.createElement("nomeUfficioReparto");
                nomeUfficioReparto.appendChild(doc.createTextNode(ufficio.getNomeUfficioReparto()));
                elementoUfficio.appendChild(nomeUfficioReparto);

                Element piano = doc.createElement("piano");
                piano.appendChild(doc.createTextNode(Integer.toString(ufficio.getPiano())));
                elementoUfficio.appendChild(piano);

                Element siglaLocale = doc.createElement("siglaLocale");
                siglaLocale.appendChild(doc.createTextNode(ufficio.getSiglaLocale()));
                elementoUfficio.appendChild(siglaLocale);

                Element numeroPostazioni = doc.createElement("numeroPostazioni");
                numeroPostazioni.appendChild(doc.createTextNode(Integer.toString(ufficio.getNumeroPostazioni())));
                elementoUfficio.appendChild(numeroPostazioni);

                Element responsabile = doc.createElement("responsabile");
                responsabile.appendChild(doc.createTextNode(ufficio.getResponsabile()));
                elementoUfficio.appendChild(responsabile);

                // Crea un elemento "dipendenti" per ogni ufficio e aggiungi i dipendenti
                Element elementoDipendenti = doc.createElement("dipendenti");
                elementoUfficio.appendChild(elementoDipendenti);

                for (Dipendente dipendente : ufficio.getDipendenti()) {
                    Element elementoDipendente = doc.createElement("dipendente");
                    elementoDipendenti.appendChild(elementoDipendente);

                    // Aggiungi gli attributi del dipendente come elementi
                    Element nome = doc.createElement("nome");
                    nome.appendChild(doc.createTextNode(dipendente.getNome()));
                    elementoDipendente.appendChild(nome);

                    Element cognome = doc.createElement("cognome");
                    cognome.appendChild(doc.createTextNode(dipendente.getCognome()));
                    elementoDipendente.appendChild(cognome);

                    Element indirizzoResidenza = doc.createElement("indirizzoResidenza");
                    indirizzoResidenza.appendChild(doc.createTextNode(dipendente.getIndirizzoResidenza()));
                    elementoDipendente.appendChild(indirizzoResidenza);

                    Element dataNascita = doc.createElement("dataNascita");
                    dataNascita.appendChild(doc.createTextNode(dipendente.getDataNascita()));
                    elementoDipendente.appendChild(dataNascita);

                    Element dataAssunzione = doc.createElement("dataAssunzione");
                    dataAssunzione.appendChild(doc.createTextNode(dipendente.getDataAssunzione()));
                    elementoDipendente.appendChild(dataAssunzione);

                    Element oreLavoroSettimanali = doc.createElement("oreLavoroSettimanali");
                    oreLavoroSettimanali
                            .appendChild(doc.createTextNode(Integer.toString(dipendente.getOreLavoroSettimanali())));
                    elementoDipendente.appendChild(oreLavoroSettimanali);

                    Element ufficioRepartoAppartenenza = doc.createElement("ufficioRepartoAppartenenza");
                    ufficioRepartoAppartenenza
                            .appendChild(doc.createTextNode(dipendente.getUfficioRepartoAppartenenza()));
                    elementoDipendente.appendChild(ufficioRepartoAppartenenza);
                }
            }

            // Salva il documento in un file XML con formattazione
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory
                    .newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();

            // Imposta la formattazione
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); // Indentazione di 2 spazi

            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(
                    new File(nomeFile));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | DOMException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }

    public List<Ufficio> caricaXML(String nomeFile) {
        List<Ufficio> uffici = new ArrayList<>();

        try {
            File fileXML = new File(nomeFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileXML);

            // Ottieni l'elemento radice (uffici)
            Element radice = document.getDocumentElement();

            // Ottieni la lista degli elementi figli (ufficio)
            NodeList listaUffici = radice.getElementsByTagName("ufficio");

            for (int i = 0; i < listaUffici.getLength(); i++) {
                Element elementoUfficio = (Element) listaUffici.item(i);

                // Leggi gli attributi dell'ufficio
                String nomeUfficioReparto = elementoUfficio.getElementsByTagName("nomeUfficioReparto").item(0)
                        .getTextContent();
                int piano = Integer.parseInt(elementoUfficio.getElementsByTagName("piano").item(0).getTextContent());
                String siglaLocale = elementoUfficio.getElementsByTagName("siglaLocale").item(0).getTextContent();
                int numeroPostazioni = Integer
                        .parseInt(elementoUfficio.getElementsByTagName("numeroPostazioni").item(0).getTextContent());
                String responsabile = elementoUfficio.getElementsByTagName("responsabile").item(0).getTextContent();

                // Crea un nuovo oggetto Ufficio con gli attributi letti
                Ufficio ufficio = new Ufficio(nomeUfficioReparto, piano, siglaLocale, numeroPostazioni, responsabile);

                // Ottieni la lista dei dipendenti all'interno dell'ufficio
                Element elementoDipendenti = (Element) elementoUfficio.getElementsByTagName("dipendenti").item(0);
                NodeList listaDipendenti = elementoDipendenti.getElementsByTagName("dipendente");

                for (int j = 0; j < listaDipendenti.getLength(); j++) {
                    Element elementoDipendente = (Element) listaDipendenti.item(j);

                    // Leggi gli attributi del dipendente
                    String nome = elementoDipendente.getElementsByTagName("nome").item(0).getTextContent();
                    String cognome = elementoDipendente.getElementsByTagName("cognome").item(0).getTextContent();
                    String indirizzoResidenza = elementoDipendente.getElementsByTagName("indirizzoResidenza").item(0)
                            .getTextContent();
                    String dataNascita = elementoDipendente.getElementsByTagName("dataNascita").item(0)
                            .getTextContent();
                    String dataAssunzione = elementoDipendente.getElementsByTagName("dataAssunzione").item(0)
                            .getTextContent();
                    int oreLavoroSettimanali = Integer.parseInt(
                            elementoDipendente.getElementsByTagName("oreLavoroSettimanali").item(0).getTextContent());
                    String ufficioRepartoAppartenenza = elementoDipendente
                            .getElementsByTagName("ufficioRepartoAppartenenza").item(0).getTextContent();

                    // Crea un nuovo oggetto Dipendente con gli attributi letti
                    Dipendente dipendente = new Dipendente(nome, cognome, indirizzoResidenza, dataNascita,
                            dataAssunzione, oreLavoroSettimanali, ufficioRepartoAppartenenza);

                    // Aggiungi il dipendente all'ufficio
                    ufficio.aggiungiDipendente(dipendente);
                }
                // Aggiungi l'ufficio alla lista
                uffici.add(ufficio);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return uffici;
    }
}
