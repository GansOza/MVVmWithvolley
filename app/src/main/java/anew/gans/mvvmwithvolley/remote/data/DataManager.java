package anew.gans.mvvmwithvolley.remote.data;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import anew.gans.mvvmwithvolley.remote.APICALL;
import anew.gans.mvvmwithvolley.remote.VolleySinglton;

public class DataManager {

    public Context context;
    public DataManager(Context context)
    {
        this.context = context;
    }


    public void sendVolleyRequest(Context context, final DataValues dataValues)
    {
   JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(APICALL.BASEURL,
           new JSONObject(), new Response.Listener<JSONObject>() {
       @Override
       public void onResponse(JSONObject response) {

       //    showData(response.toString());
       dataValues.setJsonDataResponse(response);
       }
   }, new Response.ErrorListener() {
       @Override
       public void onErrorResponse(VolleyError error) {
           //showData(error.toString());
           dataValues.setVolleyError(error);
       }
   }

   );

        VolleySinglton.getInstance(context).addToRequestQueue(JsonObjectRequest);

    }
    private void showData(String msg) {
        Toast.makeText(context,"output"+msg,Toast.LENGTH_SHORT).show();
    }
}
