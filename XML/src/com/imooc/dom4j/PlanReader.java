package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PlanReader {
	public void readPlan() {
		String file = "/Users/zhuolunzhou/eclipse-workspace/XML/src/teachingPlan.xml";
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			List<Element> courses = root.elements("course");
			for (Element course : courses) {
				System.out.println(course.element("course-name").getText());
				System.out.println(course.element("class-hour").getText());
				System.out.println(course.element("exam-form").getText());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PlanWriter pw = new PlanWriter();
		pw.writePlan();
		PlanReader pr = new PlanReader();
		pr.readPlan();
	}
}
