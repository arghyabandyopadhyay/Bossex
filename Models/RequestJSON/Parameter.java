package BusinessGenie.app.Bossex.Models.RequestJSON;

import java.util.HashMap;

public class Parameter
{
    String pKey;
    String pValue;
    Parameter(String pKey,String pValue)
    {
        this.pKey=pKey;
        this.pValue=pValue;
    }
    HashMap<String, String> toJson()
    {
        HashMap<String, String> json = new HashMap<>();
        json.put("P_Key",pKey);
        json.put("P_Value",pValue);
        return json;
    }
}

