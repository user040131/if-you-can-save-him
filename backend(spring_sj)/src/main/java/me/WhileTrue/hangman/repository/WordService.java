package me.WhileTrue.hangman.repository;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class WordService {
    private List<String> animals4 = List.of("lion", "bear", "frog", "crab", "wolf", "swan", "deer", "boar", "mole", "goat");
    private List<String> countries4 = List.of("peru", "iran", "mali", "laos", "cuba", "oman", "chile", "spain", "italy", "india");
    private List<String> foods4 = List.of("rice", "pear", "beef", "corn", "milk", "tuna", "soup", "kiwi", "cake", "taco");
    private List<String> tech4 = List.of("java", "node", "code", "html", "data", "byte", "ajax", "wifi", "ping", "hash");

    private List<String> animals5 = List.of("horse", "tiger", "eagle", "camel", "koala", "panda", "rhino", "gecko", "sheep", "shark");
    private List<String> countries5 = List.of("korea", "japan", "china", "nepal", "kenya", "ghana", "chile", "spain", "italy", "brazil");
    private List<String> foods5 = List.of("bread", "apple", "pizza", "ramen", "mango", "lemon", "onion", "grape", "sushi", "pasta");
    private List<String> tech5 = List.of("login", "stack", "array", "input", "query", "cache", "linux", "token", "proxy", "batch");

    private List<String> animals6 = List.of("jaguar", "monkey", "donkey", "rabbit", "salmon", "walrus", "otters", "falcon", "baboon", "parrot");
    private List<String> countries6 = List.of("france", "sweden", "poland", "canada", "belize", "israel", "bhutan", "norway", "mexico", "brazil");
    private List<String> foods6 = List.of("butter", "banana", "donut", "kimchi", "waffle", "burger", "salmon", "pepper", "cereal", "pickle");
    private List<String> tech6 = List.of("docker", "github", "spring", "object", "script", "module", "socket", "packet", "domain", "client");

    private List<List<String>> easy = List.of(animals4, countries4, foods4, tech4);
    private List<List<String>> medium = List.of(animals5, countries5, foods5, tech5);
    private List<List<String>> hard = List.of(animals6, countries6, foods6, tech6);

    private List<List<List<String>>> all = List.of(easy, medium, hard);

    static int randomIndex = (int)(Math.random()*10);
    static int randomTopic = (int)(Math.random()*4);
    public String getRandomWord(int level){
        String answer =  all.get(level).get(randomTopic).get(randomIndex);
        return answer;
    }
    public String getRandomTopic(){
        switch (randomTopic){
            case 0: return "animal";
            case 1: return "country";
            case 2: return "food";
            case 3: return "tech";
            default: return "error";
        }
    }
}
