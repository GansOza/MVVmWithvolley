package anew.gans.mvvmwithvolley.remote.data;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface DataValues {
    public void setJsonDataResponse(JSONObject response);
    public void setVolleyError(VolleyError volleyError);

}
