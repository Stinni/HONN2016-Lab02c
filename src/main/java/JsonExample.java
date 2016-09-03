/**
 * Forritið JsonExample (JsonExample.java)
 * skrifar Json streng út í skrá og les skránna aftur
 *
 * @author Kristinn Heiðar Freysteinsson
 * @version 1, 03.09.16
 */
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.Iterator;

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

    public static void readJson()
    {
        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("title");
            System.out.println(name);

            long accommodates = (Long) jsonObject.get("accommodates");
            System.out.println("Accommodates: " + accommodates);

            long bedrooms = (Long) jsonObject.get("bedrooms");
            System.out.println("Bedrooms: " + bedrooms);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("amenities");
            System.out.println("Amenities:");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readJson();
    }
}
