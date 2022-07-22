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
		 * 1- Bir kiþinin doðum tarihi
		 * 2- Uygulama içinde kullanýlan zamanlar
		 * 3- Uygulama içinde yapýlan iþlemler bir þekilde kayýtr altýna alýnýr.
		 * bu kayýt altýna alma ve güncelleme iþlemleri veri tabanlarýnda ayrýca
		 * programdan baðýmsýz þekilde tutulur. Kullanýlmasý tavsiye olunur.
		 * --> CreateTime   // timestamp -> 22/07/2022 09:44:15.158 -> long
		 * --> UpdateTime   // timestamp -> 
		 */
		/**
		 * Date date = new Date(); // üzerinde çalýþmak biraz zor.
		 * LocalDateTime -> bunu tercih ediyoruz.
		 * DÝKKAT!!!!!!!
		 * bulunduðumuz ülke +3saat þeklinde zaman dilimi farkýna sahiptir.
		 * Eðer-> sunucularýnýz londra gibi bir lokasyonda olsa idi ne olacaktý.
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
		 * Kullanýcý arayüzünden, kullanýcý trafýnda tarihler girilebilir. ancak bazen
		 * standart ya da o uygulama için zorunlu tarih aralýklarý olabilir. 5-7-14 gün v.s.
		 * 
		 */
		System.out.println("14 gün sonrasý...: "+localDate.plusDays(14).toString());
		System.out.println("4 hafta sonrasý...: "+localDate.plusWeeks(4).toString());
		System.out.println("6 ay sonrasý...: "+localDate.plusMonths(6).toString());
		
		System.out.println("2 ay önce...: "+localDate.minusMonths(2));
		
		//---------------------------------------------------------------------------------
		
		/**
		 * gün, ay, yýl, v.s
		 */
		Period period = Period.ofDays(5);
		localDate.plus(period);
		///----------------------------------------------------
		System.out.println("********* PERIOD Kullanýmý  *****************");
		localDate = LocalDate.of(2020, 1,1);
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		System.out.println("8 gün eklenen hali....: "+localDate.plusDays(8));
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		System.out.println("5 gün eklenemiþ hali..: "+localDate.plus(period));
		System.out.println("Mevcut zaman..........: "+localDate.toString());
		
		/**
		 * Bir method un ya da bir kod bloðunun çalýþma zamanýný ölçmek istiyorsunuz nasýl yapýlabilir????
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
		System.out.println("Geçen zaman milisaniye..........: "+ (end1-start1));
		System.out.println("Geçen zaman nanosaniye..........: "+ (end2-start2));
		Duration duration = Duration.between(instant_start, instant_end);
		System.out.println("Geren zaman isteðe baðlý Ms.....: "+duration.toMillis());
		System.out.println("Geren zaman isteðe baðlý Ns.....: "+duration.toNanos());
		/**
		 * Part ne için kullanýlýr.?????
		 */
		System.out.println("Geren zaman isteðe baðlý Ns.....: "+duration.toNanosPart());
		
		
		Long time = new Date().getTime();
		time += MyDateTime.SAAT;
		
		
	}//Main
}//Class
