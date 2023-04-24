import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;

class Client{
  // A function that gets data from the FDA Food database by name and creates a food object
  public static Food getFoodByName(String name) throws IOException, InterruptedException {
      String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=DEMO_KEY&query=" + name;
      uri += "&dataType=Branded&pageSize=25&pageNumber=1&sortBy=dataType.keyword&sortOrder=asc&api_key=";
      uri += System.getenv("apiKey");
      // Create an HttpClient object
      HttpClient client = HttpClient.newHttpClient();
  
      // Create an HttpRequest object with the given endpoint and query parameter
      HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(uri))
              .build();
  
      // Send the request and get the response as a string
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
  
      // Parse the response string as a JSON object
      JSONObject json = new JSONObject(response.body());
  
      // Get the first food item from the JSON array of foods
      JSONObject foodItem = json.getJSONArray("foods").getJSONObject(0);
  
      // Get the nutrient values from the JSON object of foodNutrients
      JSONArray foodNutrients = foodItem.getJSONArray("foodNutrients");
  
      // Initialize the nutrient variables with default values
      double calories = 0.0;
      double fat = 0.0;
      double carbohydrates = 0.0;
      double sodium = 0.0;
  
      // Loop through the foodNutrients array and assign the nutrient values based on the nutrientId
      for (int i = 0; i < foodNutrients.length(); i++) {
          JSONObject nutrient = foodNutrients.getJSONObject(i);
          int nutrientId = nutrient.getInt("nutrientId");
          switch (nutrientId) {
              case 1008: // Calories
                  calories = nutrient.getDouble("value");
                  break;
              case 1004: // Fat
                  fat = nutrient.getDouble("value");
                  break;
              case 1005: // Carbohydrates
                  carbohydrates = nutrient.getDouble("value");
                  break;
              case 1093: // Sodium
                  sodium = nutrient.getDouble("value");
                  break;
              default:
                  break;
          }
      }
  
      // Create a food object with the name and the nutrient values
      Food food = new Food(name, calories, fat, carbohydrates, sodium);
  
      // Return the food object
      return food;
  
  }
  
}