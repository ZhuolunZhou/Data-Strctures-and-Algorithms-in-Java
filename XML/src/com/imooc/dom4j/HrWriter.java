package com.imooc.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class HrWriter {
	public void writeXml() {
		String file = "/Users/zhuolunzhou/eclipse-workspace/XML/src/hr.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Element employee = root.addElement("employee");
			employee.addAttribute("no", "0000000");
			Element name = employee.addElement("name");
			name.setText("擎天柱");
			employee.addElement("age").setText("1000");
			employee.addElement("salary").setText("3600");
			Element department = employee.addElement("department");
			Element dname = department.addElement("dname");
			dname.setText("外星部");
			Element address = department.addElement("address");
			address.setText("XX宇宙-ZZZ");
			Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			document.write(writer);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
