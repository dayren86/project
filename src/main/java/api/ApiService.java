package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;

import java.io.IOException;

public abstract class ApiService {

    public Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public String getJsoup(String URL) throws IOException {
        String text = Jsoup
                .connect(URL)
                .timeout(5000)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        return text;
    }
}
