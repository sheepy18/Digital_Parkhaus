package classes;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParkhausDecorator extends Decorator {

    public ParkhausDecorator(Parkhaus park) {
        setParkhaus(park);
    }

    @Override
    public void toXmlFile() {
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(getParkhaus());
        try {
            Files.write(Paths.get("ParkhausXML.txt"), xml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Parkhaus fromXMLToParkhaus() {
        Parkhaus result = new Parkhaus();
        try {
            XStream xStream = new XStream(new StaxDriver());
            result = (Parkhaus) xStream.fromXML(new File("ParkhausXML.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
