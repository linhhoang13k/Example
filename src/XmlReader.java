package edu.learning.codefights.testdome;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlReader {
    public static Collection<Integer> getIdsByMessage(String xmlStr, String message) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlStr)));
            NodeList nodeList = document.getElementsByTagName("message");

            return IntStream.range(0, nodeList.getLength())
                    .mapToObj(nodeList::item)
                    .filter(node -> node.getTextContent().equals(message))
                    .map(node -> Integer.valueOf(node.getParentNode().getAttributes().getNamedItem("id").getNodeValue()))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?>\n" +
                "<log>\n" +
                "    <entry id = \"1\">" +
                "        <message>Application started</message>\n" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n" +
                "    <entry id = \"2\">" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n" +
                "    <entry id = \"3\">" +
                "        <message>Application ended</message>\n" +
                "    </entry>\n" +
                "</log>";

        Collection<Integer> results = XmlReader.getIdsByMessage(xml, "Application ended");

        for (int i : results) {
            System.out.print(i + " ");
        }
    }
}