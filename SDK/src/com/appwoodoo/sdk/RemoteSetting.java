package com.appwoodoo.sdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class RemoteSetting {

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public static ArrayList<RemoteSetting> parseJSON(String jsonString) {
		if (jsonString == null) {
			return null;
		}

		ArrayList<RemoteSetting> woodoos = new ArrayList<RemoteSetting>();

		try {

			JSONObject json = new JSONObject(jsonString);
			System.out.println("KEYS!");
			
			if (json.has("settings")) {

				JSONArray names = json.getJSONObject("settings").names();
				
				for (int i=0; i<names.length(); i++) {
					RemoteSetting woodoo = new RemoteSetting();
					woodoo.setKey( names.getString(i) );
					woodoo.setValue( json.getJSONObject("settings").optString( woodoo.getKey() ) );

					woodoos.add(woodoo);
				}

			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return woodoos;
	}
	
}
