package main;

import java.sql.Time;


import ws.WebService;

public class Test {

	public static void main(String[] args) {
		
	WebService ws= new WebService();
	
	Time date = new Time(0);
	
 	ws.ViajesTerminados(date,date);
	System.out.println(date);
	
	}
	

}
 