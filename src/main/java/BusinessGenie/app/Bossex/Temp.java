package BusinessGenie.app.Bossex;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;

import java.nio.file.Paths;
import java.time.Duration;


//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
class Temp
{
    public static void main(String [] args)
    {
        //inline will store the JSON data streamed in string format
        String inline = "";
        try
        {
//            String body="{\n" +
//                    "\"guid\": \"5a969842-7fe1-485b-bc4e-6944f5d98d53\",\n" +
//                    "\"companyGUID\": \"acdfbb30-dcdd-42d8-abad-0385aacf6d9d\",\n" +
//                    "\"RequestDateTime\":\"2020-08-28T20:47:53.901628+05:30\",\n" +
//                    "\"RequestJSON\":\"{\\\"RequestType\\\":\\\"Active Sale Point\\\",\\\"ParameterList\\\":null}\"\n" +
//                    "}";
//            //post("",body);
//            URL url = new URL("http://api.codeplayers.in/api/registerRequest");
//            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            //Set the request to GET or POST as per the requirements
//            //conn.setRequestMethod("POST");
//
//            //Use the connect method to create the connection bridge
//            conn.connect();
//            //Get the response status of the Rest API
//            int responsecode = conn.getResponseCode();
//            System.out.println("Response code is: " +responsecode);
//
//            //Iterating condition to if response code is not 200 then throw a runtime exception
//            //else continue the actual process of getting the JSON data
//            if(responsecode != 200)
//                throw new RuntimeException("HttpResponseCode: " +responsecode);
//            else
//            {
//                //Scanner functionality will read the JSON data from the stream
//                Scanner sc = new Scanner(url.openStream());
//                while(sc.hasNext())
//                {
//                    inline+=sc.nextLine();
//                }
//                System.out.println("\nJSON Response in String format");
//                System.out.println(inline);
//                //Close the stream when reading the data has been finished
//                sc.close();
//            }
            // Host url

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://openjdk.java.net/"))
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            HttpRequest request1 = HttpRequest.newBuilder()
                    .uri(URI.create("http://openjdk.java.net/"))
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("[\n" +
                            "  {\n" +
                            "    \"\": \"\"\n" +
                            "  },\n" +
                            "  {\n" +
                            "    \"\": \"\"\n" +
                            "  }\n" +
                            "]"))
                    .build();
            HttpResponse<String> response1 =client.send(request1, HttpResponse.BodyHandlers.ofString());
            System.out.println(response1.statusCode());
            System.out.println(response1.body());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


//    public static void post(String completeUrl, String body) {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(completeUrl);
//        httpPost.setHeader("Content-type", "application/json");
//        try {
//            HttpEntity stringEntity = new HttpEntity(body);
//            httpPost.getRequestLine();
//            httpPost.setEntity(stringEntity);
//
//            httpClient.execute(httpPost);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
