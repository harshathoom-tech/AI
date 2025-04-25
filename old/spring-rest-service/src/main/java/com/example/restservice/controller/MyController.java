import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        List<Item> items = myService.fetchItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = myService.saveItem(item);
        return ResponseEntity.status(201).body(savedItem);
    }

     @GetMapping("/weather")
    public ResponseEntity<String> getWeather(@RequestParam String city) {
        String apiKey = "your_api_key"; // Replace with your actual API key
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, apiKey);
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}