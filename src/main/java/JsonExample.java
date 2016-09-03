/**
 * Forritið JsonExample (JsonExample.java)
 * skrifar út Json streng
 *
 * @author Kristinn Heiðar Freysteinsson
 * @version 1, 03.09.16
 */
import org.json.simple.*;
import java.io.FileWriter;
import java.io.IOException;

public class JsonExample {
    public static JSONObject writeJson()
    {
        JSONObject obj = new JSONObject();
        obj.put("title", "Luxury 1 Bedroom Condo Downtown");
        obj.put("accommodates", new Integer(2));
        obj.put("bedrooms", new Integer(1));

        JSONArray list = new JSONArray();
        list.add("Kitchen");
        list.add("Internet");
        list.add("TV");

        obj.put("amenities", list);

        try
        {

            FileWriter file = new FileWriter("test.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return obj;
    }

    public static void main(String[] args) {
        writeJson();
    }
}
