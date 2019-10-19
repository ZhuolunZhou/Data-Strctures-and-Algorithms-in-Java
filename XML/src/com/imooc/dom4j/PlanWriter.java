package com.imooc.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanWriter {
	public void writePlan() {
		String file = "/Users/zhuolunzhou/eclipse-workspace/XML/src/teachingPlan.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Element course = root.addElement("course");
			Element courseName = course.addElement("course-name");
			courseName.setText("打酱油");
			course.addElement("class-hour").setText("24");
			course.addElement("exam-form").setText("随堂");
			Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			document.write(writer);
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
