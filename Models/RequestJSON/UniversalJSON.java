package BusinessGenie.app.Bossex.Models.RequestJSON;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

class UniversalJson
{
    String uID;
    RequestJson requestJSON;
    UniversalJson(String uID,RequestJson requestJSON)
    {
        this.uID=uID;
        this.requestJSON=requestJSON;
    }
    HashMap<String, String> toJson() throws JsonProcessingException {
        HashMap<String, String> json = new HashMap<>();
        json.put("UID",uID);
        json.put("RequestDateTime", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).toString());
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(requestJSON);
        json.put("RequestJSON",jsonString);
        return json;
    }
}
class RequestJson
{
    String requestType;
    List<Parameter> parameterList;
    RequestJson(String requestType,List<Parameter> parameterList)
    {
        this.requestType=requestType;
        this.parameterList=parameterList;
    }
    HashMap toJson()
    {
        HashMap json = new HashMap<>();
        json.put("RequestType",requestType);
        json.put("ParameterList",parameterList);
        return json;
    }
}
