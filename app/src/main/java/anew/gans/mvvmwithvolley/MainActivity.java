package anew.gans.mvvmwithvolley;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import anew.gans.mvvmwithvolley.adapter.CustomAdapter;
import anew.gans.mvvmwithvolley.databinding.ActivityMainBinding;
import anew.gans.mvvmwithvolley.presenter.PresenterFun;
import anew.gans.mvvmwithvolley.remote.data.DataManager;
import anew.gans.mvvmwithvolley.remote.data.DataValues;
import anew.gans.mvvmwithvolley.viewmodel.UserModel;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding activityMainBinding;
    private DataManager dataManger;
    private ListView listView;
    private CustomAdapter customAdapter;
    private ArrayList<UserModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //     setContentView(R.layout.activity_main);


        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        dataManger = new DataManager(this);
        listView = (ListView)findViewById(R.id.listview);
        activityMainBinding.setPresenter(new PresenterFun() {
            @Override
            public void getJSONData() {

         dataManger.sendVolleyRequest(MainActivity.this, new DataValues() {
                    @Override
                    public void setJsonDataResponse(JSONObject response) {

                        UserModel userModel;
                        arrayList = new ArrayList<>();


                        try{


                            JSONArray jsonArray = response.getJSONArray("students");

                            for(int i =0 ; i <jsonArray.length() ;i++)
                            {

                                JSONObject user = jsonArray.getJSONObject(i);

                                String firstname = user.getString("firstname");
                                String lastname = user.getString("lastname");
                                String age = user.getString("age");
                                userModel = new UserModel(firstname,lastname,age);
                                arrayList.add(userModel);
                            }


                            customAdapter = new CustomAdapter(MainActivity.this,arrayList);
                            listView.setAdapter(customAdapter);



                        }
                        catch (JSONException jsonDataResponse)
                        {

                        }





                    }

                    @Override
                    public void setVolleyError(VolleyError volleyError) {

                    }
                });






            }
        });


    }

    void showData(String msg )
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();


    }

}