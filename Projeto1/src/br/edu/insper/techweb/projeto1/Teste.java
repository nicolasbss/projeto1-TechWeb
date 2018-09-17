package br.edu.insper.techweb.projeto1;
import java.util.Calendar;


public class Teste {
	 
	    public static void main(String[] args) {
	        Calendar c = Calendar.getInstance();
	        System.out.println(c.get(Calendar.HOUR_OF_DAY));
	        System.out.println(c.get(Calendar.MINUTE));
	        System.out.println(c.get(Calendar.SECOND));
	        System.out.println(c.get(Calendar.DAY_OF_MONTH));
	        System.out.println(c.get(Calendar.MONTH));
	        System.out.println(c.get(Calendar.YEAR));    
	        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
	        
	    }
	}
