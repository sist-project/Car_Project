package com.sist.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 * 		JAXB (XML �±�, Ŭ������ => ���ε�)
 * 		JAXP (XML���� �ʿ��� ������ �о� ���δ�)
 * 			  �����͸� ������ ��� : dom (����, ����, �߰�, �б�)
 * 			  �����͸� �б� ���� : sax => Mybatis, spring
 */
import java.util.*;
public class XMLParser extends DefaultHandler {
	
	public ArrayList<String> list = new ArrayList<String>();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try {
			if(qName.equals("context:component-scan")) {
				String pack = attributes.getValue("package-base");
				System.out.println(pack);
				list.add(pack);
			}
		} catch (Exception e) {}
		
	}
	
}