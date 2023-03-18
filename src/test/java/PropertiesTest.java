import com.duke.boot.MainApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = MainApplication.class)
public class PropertiesTest {

    @Value("${datasource.password:}")
    private String password;

    @Test
    public void test() {
        log.info("datasource.password : {}", password);
    }

}
