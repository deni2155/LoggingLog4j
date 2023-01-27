package ru.scrooge.xmlparser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /*SAX
        * https://mkyong.com/java/how-to-read-xml-file-in-java-jdom-example
        */
        /*
        * https://coderlessons.com/tutorials/java-tekhnologii/izuchite-java-xml/java-xml-kratkoe-rukovodstvo
        */

        //создаю объект DocumentBuilder
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //указываю на использование пространства имён в xml-документе
        factory.setNamespaceAware(true);
        DocumentBuilder builder=factory.newDocumentBuilder();
        //получаю путь к xml-файлу и выполняю парсинг
        Document doc=builder.parse(new File("/home/dreamer/NetBeansProjects/xml/acknowledgment.xml"));
        //выполняю нормализацию файла, что убрать лишние переносы строк
        doc.getDocumentElement().normalize();
        //получаю префикс xml-файла
        String prefix=doc.getDocumentElement().getPrefix()+":";

        //
        //Объявляю переменные
        //
        //корневой элемент
        Element root=null;
        //список узлов
        NodeList nList=null;
        NodeList nList1=null;
        //конкретный узел
        Node nNode=null;
        Node nNode1=null;
        Element eElement=null;
        //
        //Квитанция
        //
        //получаю корневой элемент xml
        root=doc.getDocumentElement();
        if(root.hasAttribute(prefix+"version")){
            String xmlVersion=root.getAttribute(prefix+"version");
            System.out.println("Версия xml:"+xmlVersion);
        }
        else {
            System.out.println("Версия xml не указана");
        }

        //
        //тип пакета и uid пакета
        //
        //nList=doc.getElementsByTagName(prefix+"header");
//        for(int i=0;i<nList.getLength();i++){
//            nNode=nList.item(i);
//            System.out.println("\nCurrent element");
//            System.out.print(nNode.getNodeName());
//        }
        nList=(NodeList) root;
        for(int i=0;i<nList.getLength();i++){
            nNode=nList.item(i);
            if(nNode.getNodeName().equals(prefix+"header") && nNode.getNodeType()==Node.ELEMENT_NODE){
                //System.out.println(nNode.getNodeName());
                //если есть вложенные аттрибуты
                if(nNode.hasAttributes()){
                    eElement=(Element)nNode;
                    if(eElement.hasAttribute(prefix+"uid")){
                        System.out.println("Uid пакета:"+eElement.getAttribute(prefix+"uid"));
                    }
                    if(eElement.hasAttribute(prefix+"type")){
                        System.out.println("Тип пакета:"+eElement.getAttribute(prefix+"type"));
                    }
                    
                }
//                if(nNode.hasChildNodes()){
                    nList1=eElement.getElementsByTagName("");
                        for(int j=0;j<nList1.getLength();j++){
                            nNode1=nList1.item(j);
                            System.out.println(nNode1.getNodeName());
                        }
//                }
            }
        }
    }
}
