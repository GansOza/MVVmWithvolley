package anew.gans.mvvmwithvolley.remote;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySinglton {

    private static VolleySinglton instance;
    private RequestQueue requestQueue;
    private Context context;

    public VolleySinglton(Context context) {
        this.context = context;

        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySinglton getInstance(Context context){

        if (instance == null){
        instance = new VolleySinglton(context);
        }
        return instance;
    }


    public RequestQueue getRequestQueue()
    {

        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }



    public <T> void addToRequestQueue(Request<T> request)
    {
        getRequestQueue().add(request);
    }

}
