package BusinessGenie.app.Bossex.Models.RequestJSON;

import java.util.HashMap;
public class ApiHeaderModel
{
    String authorization;
    String contentType;
    ApiHeaderModel(String authorization,String contentType)
    {
        this.authorization=authorization;
        this.contentType=contentType;
    }
    HashMap<String, String> toJson()
    {
        HashMap<String, String> json = new HashMap<>();
        json.put("Authorization",authorization);
        json.put("Content-Type",contentType);
        return json;
    }
}

