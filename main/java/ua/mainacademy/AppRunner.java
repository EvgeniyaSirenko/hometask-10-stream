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
		
		List<String> list = Arrays.asList(text.split(" "));
		LOG.info(String.format("Full list: %s", list));
		
		//my personal easier task for practise #1
		List<String> sorted = list.stream().filter(s -> !s.equals("Jennifer")).collect(Collectors.toList());
		LOG.info(String.format("Result without Jennifer: %s", sorted));
		
		//my personal easier task for practise #2
		List<String> sorted2 = list.stream()
				.sorted().collect(Collectors.toList());
		LOG.info(String.format("Result sorted by names: %s", sorted2));
		
		//result for home task
		LOG.info("Result for home task #7: ");
		list.stream()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
				.collect(Collectors.toMap(Entry -> Entry.getKey(), Entry -> Entry.getValue(), (e1, e2) -> e1, LinkedHashMap::new))
				.forEach((key, value) -> LOG.info(key + " - " + value + "; "));
	}
}
