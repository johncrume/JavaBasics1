import java.util.List;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;

import java.time.Year;
import java.time.Month;
import java.time.YearMonth;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ChronoField;
import java.util.Locale;

/*
Java Basics 5
Assignment 1
John Crume
9/7/2021
*/
public class Assignment1 {
	/*
	 * 1. Basic lambdas. Make an array containing a few Strings. Sort it by
	 * 
	 * • length (i.e., shortest to longest) (Hint: this exact solution was shown in
	 * the lecture)
	 */
	
	public void sortByLength(String [] arr){
		
		Arrays.sort(arr, (str1,str2) -> str1.length() - str2.length());
	}
	
	/*
	 * • reverse length (i.e., longest to shortest) (Hint: minor variation of the
	 * first bullet)
	 * 
	 */
	public void sortByReverseLength(String [] arr) {
		Arrays.sort(arr, (str1,str2) -> str2.length() - str1.length());
	}
	
	/*
	 * • alphabetically by the first character only (Hint: charAt(0) returns the
	 * numeric code for the first character)
	 * 
	 */
	public void sortAlphabetically(String [] arr) {
		Arrays.sort(arr, (str1,str2) -> str1.charAt(0) - str2.charAt(0));
	}
	
	/*
	 * • Strings that contain “e” first, everything else second. For now, put the
	 * code directly in the lambda.
	 * 
	 */
	public void sortByE(String [] arr) {
		 Arrays.sort(arr, Comparator.comparingInt(a -> (a.contains("e") ? 0 : 1)));
	}
	
	/*
	 * Redo the previous problem, but use a static helper method so that your lambda
	 * looks like this: Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
	 * 
	 */
	
	public void yourmethod(String [] arr){
		
		Arrays.sort(arr,Comparator.comparingInt(a->helperMethod(a)));
			
		
		
	}
	
	public static int helperMethod(String a) {
		
		if(a.contains("e")) {
			return 1;
		}else { return 0;}
		
	}
	
	
	/*
	 * 2. Using Java 8 features write a method that returns a comma separated string
	 * based on a given list of integers. Each element should be preceded by the
	 * letter 'e' if the number is even, and preceded by the letter 'o' if the
	 * number is odd. For example, if the input list is (3,44), the output should be
	 * 'o3,e44'.
	 * 
	 */
	
	public String getString(List<Integer> list) {
		return list.stream()
				.map(i -> i % 2 == 0 ? "e" + i : "o" + i)
				.collect(Collectors.joining(","));
	}

	
	/*
	 * 3. Given a list of Strings, write a method that returns a list of all strings
	 * that start with the letter 'a' (lower case) and have exactly 3 letters. TIP:
	 * Use Java 8 Lambdas and Streams API's.
	 * 
	 */
	public List<String> search(List<String> list){
		return list.stream().filter(s-> s.startsWith("a")).filter(s-> s.length() ==3).collect(Collectors.toList());
	}
	
	/*
	 *  Date-Time API
	 * 
	 * 1. Which class would you use to store your birthday in years, months, days,
	 * seconds, and nanoseconds? The LocalDateTime Class
	 * 
	 * 2. Given a random date, how would you find the date of the previous Thursday? 
	 * You can use TemporalAdjuster.previous(DayOfWeek.THURSDAY). The previous() method returns the previous
	 * day of the week adjuster, which adjusts the date to the first occurrence of the specified day before the
	 * date being adjusted. 
	 * 
	 * 3. What is the difference between a ZoneId and a ZoneOffset?
	 * The ZoneOffset class tracks the absolute offset from Greenwich/UTC. The ZonId class uses ZoneRules to determine
	 * how an offset varies for a specific time of year and region.
	 * 
	 * 4. How would you convert an Instant to a ZonedDateTime? How would you convert
	 * a ZonedDateTime to an Instant? You can convert an Instant to a ZoneDateTime by using the ZopneDateTime.ofInstant method.
	 * You can use the toInstant() method in the ChronoZineDateTime interface to convert from a ZonedDateTime
	 * to an Instant.
	 */
	
	
	/*
	 * 5. Write an example that, for a given year, reports the length of each month
	 * within that year.
	 */
	public void monthsInYear(int year) {
		try {
			@SuppressWarnings("unused")
			Year myYear =Year.of(year);
		} catch(DateTimeException ex) {
			System.out.println(year+" is not a valid year.");
			throw ex;
		}
		
		System.out.println("For the year "+ year+":");
		for(Month month: Month.values()) {
			YearMonth yM = YearMonth.of(year, month);
			System.out.println(month+" : "+yM.lengthOfMonth());
		}
		
		
	}

	/*
	 * 6. Write an example that, for a given month of the current year, lists all of
	 * the Mondays in that month.
	 */
	public void listMondays(Month month) {
		
			
		Locale usLocale = new Locale("en","US");
		
		System.out.println("For the month of "+month.getDisplayName(TextStyle.FULL, usLocale));
		LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month dateMonth = date.getMonth();
		while(dateMonth == month) {
			System.out.println();
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			dateMonth = date.getMonth();
		}
	}
	
	
	/*
	 * 7. Write an example that tests whether a given date occurs on Friday the
	 * 13th.
	 */

	
	public boolean testFridayTheThirteenth(TemporalAccessor date) {
		
		if(date.get(ChronoField.DAY_OF_MONTH)==13 && date.get(ChronoField.DAY_OF_WEEK)==5) {
			return true;
		}else {
			return false;
		}
		
	}
}
