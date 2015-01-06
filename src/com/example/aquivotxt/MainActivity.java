package com.example.aquivotxt;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;


public class MainActivity extends Activity{
	
	//private File arquivo = new File("drawable-ldpi/arquivo.txt");
	private String latitude_string;
	private String longitude_string;
	private double latitude;
	private double longitude;
	private String name;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("text ", "antes do try");
		Log.i("text", "" + getFilesDir().getPath());
		
		try {
			Log.i("text ", "depois do try");
				 
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("arquivo.txt")));
			while (br.ready()) {
			//lê a proxima linha
			String linha = br.readLine();
			if(linha.indexOf("lat") > -1){
				Log.i("sript", linha);
				Log.i("sript", "" + linha.indexOf(": "));
				
				Log.i("sript", "" + ((linha.length()-1) - (linha.indexOf(": "))));
				latitude_string = linha.substring(linha.indexOf(": ")+2, linha.length()-1);
				Log.i("sript", latitude_string);
			}else if (linha.indexOf("lng") > -1){
				Log.i("sript", linha);
				longitude_string = linha.substring(linha.indexOf(": ")+2, (linha.length()));
				Log.i("sript", longitude_string);
			}else if(linha.indexOf("name") > -1){
				Log.i("sript", linha);
				name = linha.substring(linha.indexOf(": ")+3, (linha.length()-2));
				Log.i("sript", name);
			}
			
			
			}
			 
			br.close();
			 
			} catch (IOException ex) {
			ex.printStackTrace();
			}
		
		
		/*FileOutputStream fos; 
		try { 
			fos = openFileOutput("arquivo.txt", Context.MODE_PRIVATE); 
			fos.write(testString.getBytes()); 
			fos.close(); } 
		catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
			} 
		File file = getBaseContext().getFileStreamPath("arquivo.txt"); 
		if (file.exists()) { 
			FileInputStream fis; 
			try { 
				fis = openFileInput("arquivo.txt"); 
				fis.read(readString.getBytes()); 
				fis.close(); 
				} catch (IOException e) { 
					e.printStackTrace(); 
					} //Object txtDate;
					//((Object) txtDate).setText(String.valueOf(readString)); 
		} else { // more code } }
		}
	        */
	     
	}
}
