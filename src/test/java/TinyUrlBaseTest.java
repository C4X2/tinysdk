import com.software.tinyurl.core.auth.cred.BasicTinyUrlCredentials;
import com.software.tinyurl.core.auth.cred.TinyUrlCredentials;
import com.software.tinyurl.core.auth.providers.StaticCredentialsProvider;
import com.software.tinyurl.core.model.exception.UnauthorizedCreateException;
import com.software.tinyurl.core.model.request.CreateTinyUrlRequest;
import com.software.tinyurl.core.model.response.CreateTinyUrlResponse;
import com.software.tinyurl.core.services.DefaultTinyUrlCoreAPI;
import com.software.tinyurl.core.services.TinyUrlCoreAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TinyUrlBaseTest {

    @Test
    public void createTest() {
        CreateTinyUrlRequest ct = CreateTinyUrlRequest.builder()
                .url("http://google.com")
                .description("Inital Test Case")
                .tags("search,alphabet")
                .expiresAt(null)
                .build();


        String expected = getResourceAsText("createRequestTest1.json");
        String actual = ct.toJson();
        assertEquals(expected, actual);

        TinyUrlCoreAPI api = DefaultTinyUrlCoreAPI.create();
        CreateTinyUrlResponse rt = api.create(ct);
        assert(rt.getCode() == 200);


        StaticCredentialsProvider scp = new StaticCredentialsProvider(new TinyUrlCredentials() {
            @Override
            public String getAPIKey() {
                return null;
            }

            @Override
            public String getBearerToken() {
                return null;
            }
        });
        TinyUrlCoreAPI api2 = DefaultTinyUrlCoreAPI.create(scp);
        assertThrows(UnauthorizedCreateException.class, (Executable) api2.create(ct));
    }

    @Test
    public void createTest2() {
        CreateTinyUrlRequest ct = CreateTinyUrlRequest.builder()
                .url("https://www.theatlantic.com/magazine/archive/2025/03/american-geographic-social-mobility/681439/")
                .description("Test Case 2")
                .tags("journalism,news,theatlantic")
                .expiresAt(null)
                .build();

        TinyUrlCredentials tc = new BasicTinyUrlCredentials("tGtGZ0SVUfuwO0RwsAW4tCEBOeErUaF27j8cJrTWmUXLOjKcBwynU9Mmrho2", "tGtGZ0SVUfuwO0RwsAW4tCEBOeErUaF27j8cJrTWmUXLOjKcBwynU9Mmrho2");
        StaticCredentialsProvider scp = new StaticCredentialsProvider(tc);
        TinyUrlCoreAPI api = DefaultTinyUrlCoreAPI.create(scp);
        CreateTinyUrlResponse rt = api.create(ct);
        assert(rt.getCode() == 200);

    }

    private String getResourceAsText(String path) {
        String expected = "";
        try {
            File f = new File(this.getClass().getClassLoader().getResource(path).toURI());
            FileReader fr = new FileReader(f);
            int n = fr.read();
            while (n != -1) {
                expected += (char) n;
                n = fr.read();
            }
        } catch (Exception e) {
        }
        return expected;
    }
}
