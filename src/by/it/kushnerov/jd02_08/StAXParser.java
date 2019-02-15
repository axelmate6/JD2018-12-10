package by.it.kushnerov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class StAXParser {

    private StringBuilder xmlTxt;
    private StringBuilder elementTxt;
    private String tab;

    public static void main(String[] args) {
        StAXParser parser = new StAXParser();
        String xmlFile = System.getProperty("user.dir")+"src/by/it/kushnerov/jd02_07/users+att+xsd.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (Reader reader = new BufferedReader(new FileReader(xmlFile))){
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);
            parser.process(xmlStreamReader);
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void process(XMLStreamReader xml) throws XMLStreamException {
        xmlTxt = new StringBuilder();
        elementTxt = new StringBuilder();
        tab="";
        while(xml.hasNext()){
            int type = xml.next();
            switch (type){
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("START_DOCUMENT");
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("END_DOCUMENT");
                case XMLStreamConstants.START_ELEMENT:
                    xmlTxt.append(tab).append("<").append(xml.getLocalName());
                    int attCount = xml.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = xml.getAttributeLocalName(i);
                        String value = xml.getAttributeValue(i);
                        String attText = String.format(" %s=\"%S\"", name, value);
                        xmlTxt.append(attText);
                    }
                    tab = tab.concat("\t");

                    xmlTxt.append(">\n");
                    System.out.println("START_ELEMENT");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println("CHARACTERS");
            }
        }
    }
}
