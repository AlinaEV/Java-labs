/**
 * Created by Алина on 02.10.2016.
 */
import com.google.gson.Gson;

public class Task {
    
    public static void main(String[] args) {

            Person object1 = new Person(5, 10);

            Gson gson = new Gson();
            String json = gson.toJson(object1);
            Person object2 = gson.fromJson(json, Person.class);

            Object result = object1.equals(object2);

            System.out.println(result);

    }
}
