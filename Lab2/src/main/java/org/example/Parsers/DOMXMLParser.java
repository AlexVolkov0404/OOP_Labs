package org.example.Parsers;

import org.example.Models.Gun;
import org.example.Models.TTC;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMXMLParser extends XMLParser {
    @Override
    public List<Gun> parse(String xmlPath) {
        List<Gun> list = new ArrayList<>();

        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(xmlPath));
            doc.getDocumentElement().normalize();

            NodeList gunsList = doc.getElementsByTagName(Gun.GUN);
            for (int GunIndex = 0; GunIndex < gunsList.getLength(); ++GunIndex) {
                Element element = (Element) gunsList.item(GunIndex);
                list.add(parseGun(element));
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private Gun parseGun(Element element) {
        Gun gun = new Gun();
        gun.setId(Integer.parseInt(element.getAttribute(Gun.ID)));
        gun.setModel(element.getElementsByTagName(Gun.MODEL).item(0).getTextContent());
        gun.setHandy(element.getElementsByTagName(Gun.HANDY).item(0).getTextContent());
        gun.setOrigin(element.getElementsByTagName(Gun.ORIGIN).item(0).getTextContent());

        TTC ttc = parseTTC(element);
        gun.setTtc(ttc);

        gun.setMaterial(element.getElementsByTagName(Gun.MATERIAL).item(0).getTextContent());

        return gun;
    }

    private TTC parseTTC(Element element) {
        TTC ttc = new TTC();

        ttc.setFiringRange(element.getElementsByTagName(TTC.FIRING_RANGE).item(0).getTextContent());
        ttc.setSightingRange(Integer.parseInt(element.getElementsByTagName(TTC.SIGHTING_RANGE).item(0).getTextContent()));
        ttc.setMagazine(Boolean.parseBoolean(element.getElementsByTagName(TTC.MAGAZINE).item(0).getTextContent()));
        ttc.setSight(Boolean.parseBoolean(element.getElementsByTagName(TTC.SIGHT).item(0).getTextContent()));

        return ttc;
    }
}
