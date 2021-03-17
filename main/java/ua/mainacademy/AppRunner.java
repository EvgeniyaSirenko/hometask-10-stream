package ua.mainacademy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AppRunner {
	public static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {
		String text = "Charlie Jennifer Charlie Bob Charlie Charlie Bob Jennifer Alice Alice";
		
		//Arrays.stream(text.split(" "))
		
		List<String> list = Arrays.asList(text.split(" "));
		LOG.info(String.format("Full list is: %s", list));
		//my personal easier task for practise
		List<String> sorted = list.stream().filter(s -> !s.equals("Jennifer")).collect(Collectors.toList());
		LOG.info(String.format("Result without Jennifer: %s", sorted));
		//home task #7
		LOG.info("Result for home task #7: ");
		list.stream()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Entry -> Entry.getKey(), Entry -> Entry.getValue(), (e1, e2) -> e1, LinkedHashMap::new))
				.forEach((key, value) -> LOG.info(key + " - " + value + "; "));
	}
}
