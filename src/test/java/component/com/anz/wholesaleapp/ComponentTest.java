package component.com.anz.wholesaleapp;

import com.anz.wholesaleapp.WholesaleAppApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = WholesaleAppApplication.class)
@ActiveProfiles("test")
public @interface ComponentTest {
}
