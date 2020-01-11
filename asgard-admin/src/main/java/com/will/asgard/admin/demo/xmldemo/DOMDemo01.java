package com.will.asgard.admin.demo.xmldemo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by WillMao on 18-12-6
 */
public class DOMDemo01 {
	private static String baseRelativePath = "target/classes/";

	public static void main(String[] args) throws Throwable {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		String fileName = "domdemo.xml";
		Document document = builder.parse(getRelativePath(fileName));
		NodeList nodeList = document.getElementsByTagName("linkman");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			System.out.println(e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
		}
	}

	private static String getRelativePath(String fileName) {
		return baseRelativePath + fileName;
	}
}
