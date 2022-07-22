package com.muhammet;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.muhammet.constants.MyDateTime;

public class Runner {

	public static void main(String[] args) {
		
		/**
		 * 1- Bir ki�inin do�um tarihi
		 * 2- Uygulama i�inde kullan�lan zamanlar
		 * 3- Uygulama i�inde yap�lan i�lemler bir �ekilde kay�tr alt�na al�n�r.
		 * bu kay�t alt�na alma ve g�ncelleme i�lemleri veri tabanlar�nda ayr�ca
		 * programdan ba��ms�z �ekilde tutulur. Kullan�lmas� tavsiye olunur.
		 * --> CreateTime   // timestamp -> 22/07/2022 09:44:15.158 -> long
		 * --> UpdateTime   // timestamp -> 
		 */
		/**
		 * Date date = new Date(); // �zerinde �al��mak biraz zor.
		 * LocalDateTime -> bunu tercih ediyoruz.
		 * D�KKAT!!!!!!!
		 * bulundu�umuz �lke +3saat �eklinde zaman dilimi fark�na sahiptir.
		 * E�er-> sunucular�n�z londra gibi bir lokasyonda olsa idi ne olacakt�.
		 * Long datetime = 1658470958622; 
		 */
		
		System.out.println(new Date().getTime());
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());

		//---------------------------------------------------
		
		LocalDate localDate = LocalDate.of(2020, 6, 6);
		localDate = LocalDate.of(2020,Month.AUGUST , 6);
		System.out.println(localDate.toString());
		LocalTime localTime = LocalTime.of(15, 30, 2, 159);
		System.out.println(localTime.toString());
		ZonedDateTime zonedDateTime = ZonedDateTime.of(2000, 11, 6, 19, 0, 25, 140, ZoneId.of("Asia/Istanbul"));
		System.out.println(zonedDateTime.toString());
		//-----------------------------------------------------
		
		/**
		 * Kullan�c� aray�z�nden, kullan�c� traf�nda tarihler girilebilir. ancak bazen
		 * standart ya da o uygulama i�in zorunlu tarih aral�klar� olabilir. 5-7-14 g�n v.s.
		 * 
		 */
		System.out.println("14 g�n sonras�...: "+localDate.plusDays(14).toString());
		System.out.println("4 hafta sonras�...: "+localDate.plusWeeks(4).toString());
		System.out.println("6 ay sonras�...: "+localDate.plusMonths(6).toString());
		
		System.out.println("2 ay �nce...: "+localDate.minusMonths(2));
		
		//---------------------------------------------------------------------------------
		
		/**
		 * g�n, ay, y�l, v.s
		 */
		Period period = Period.ofDays(5);
		localDate.plus(period);
		///----------------------------------------------------
		System.out.println("********* PERIOD Kullan�m�  *****************");
		localDate = LocalDate.of(2020, 1,1);
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		System.out.println("8 g�n eklenen hali....: "+localDate.plusDays(8));
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		System.out.println("5 g�n eklenemi� hali..: "+localDate.plus(period));
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		
		/**
		 * Bir method un ya da bir kod blo�unun �al��ma zaman�n� �l�mek istiyorsunuz nas�l yap�labilir????
		 * 
		 */
		
		 
		Long start1= System.currentTimeMillis();
		Long start2 = System.nanoTime();
		Instant instant_start = Instant.now();
		int toplama=0;
		for(int i=0;i<2_000_000_000;i++) {
			toplama++;
		}
		System.out.println("Toplam.....: "+ toplama);	
		Instant instant_end = Instant.now(); 
		Long end1= System.currentTimeMillis();
		Long end2 = System.nanoTime();
		System.out.println("Ge�en zaman milisaniye..........: "+ (end1-start1));
		System.out.println("Ge�en zaman nanosaniye..........: "+ (end2-start2));
		Duration duration = Duration.between(instant_start, instant_end);
		System.out.println("Geren zaman iste�e ba�l� Ms.....: "+duration.toMillis());
		System.out.println("Geren zaman iste�e ba�l� Ns.....: "+duration.toNanos());
		/**
		 * Part ne i�in kullan�l�r.?????
		 */
		System.out.println("Geren zaman iste�e ba�l� Ns.....: "+duration.toNanosPart());
		
		
		Long time = new Date().getTime();
		time += MyDateTime.SAAT;
		
		
	}//Main
}//Class
