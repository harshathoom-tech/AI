import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestServiceApplicationTests {

    @Autowired
    private MyController myController;

    @Autowired
    private MyService myService;

    @Test
    void contextLoads() {
        assertThat(myController).isNotNull();
        assertThat(myService).isNotNull();
    }

    @Test
    void testGetItems() {
        ResponseEntity<?> response = myController.getItems();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        // Additional assertions can be added based on expected response
    }

    @Test
    void testCreateItem() {
        Item newItem = new Item("Sample Item");
        ResponseEntity<?> response = myController.createItem(newItem);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
        // Additional assertions can be added based on expected response
    }
}