package org.api;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {

	public static void main(String[] args) throws IOException, ParseException {

		File file = new File(
				"C:\\Users\\sabas\\OneDrive\\Documents\\SampleCucumberMavenProject\\src\\test\\resources\\TestSample.json");
		FileReader reader = new FileReader(file);

		JSONParser parser = new JSONParser();
		Object parse = parser.parse(reader);

		JSONObject obj = (JSONObject) parse;
		String string = obj.get("total").toString();
		System.out.println(string);
		Object object = obj.get("data");
		// Convert these Object to array

		JSONArray arr = (JSONArray) object;
		Object object2 = arr.get(2);
		// Convert object2 to jsonobject

		JSONObject o = (JSONObject) object2;
		String string2 = o.get("id").toString();
		System.out.println(string2);

		String string3 = o.get("first_name").toString();
		System.out.println(string3);

		String str = "java programm";
		// reverse the programm --> op-> mmargorp avaj
		String output = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			output = output + str.charAt(i);

		}

		System.out.println(output);
	}

}
