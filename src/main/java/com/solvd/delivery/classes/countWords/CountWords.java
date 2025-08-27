package com.solvd.delivery.classes.countWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountWords {
    private static final Logger logger = LoggerFactory.getLogger(CountWords.class);

    public static void main(String[] args) {
        File output = new File("src/main/resources/com/solvd/delivery/classes/countWords/output.txt");

        try(InputStream inputStream = CountWords.class.getClassLoader().getResourceAsStream("com/solvd/delivery/classes/countWords/input.txt")) {
            if(inputStream == null) {
                throw new FileNotFoundException("File not found");
            } 
            String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            content = content.replaceAll("[^a-zA-Z\\s]", " ");

            String[] words = StringUtils.split(content);
            Map<String, Integer> countingWord = new TreeMap<>();
            for(String word: words) {
                if(countingWord.containsKey(word)) {
                    int count = countingWord.get(word);
                    countingWord.put(word, count+1);
                } else {
                    countingWord.put(word, 1);
                }
            }
            StringBuilder result = new StringBuilder();
            result.append("-----Word count-----\n");

            // for(Map.Entry<String, Integer> entry: countingWord.entrySet()) {
            //     result.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
            // }
            countingWord.forEach((string, integer) -> result.append(string).append(" - ").append(integer).append("\n"));
            
            if(!output.exists()) {
                output.createNewFile();
                logger.info("Output file created.");
            }

            FileUtils.writeStringToFile(output, result.toString(), StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            logger.error("Error");
        }
    }
}
