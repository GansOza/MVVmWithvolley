package anew.gans.mvvmwithvolley.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import anew.gans.mvvmwithvolley.MainActivity;
import anew.gans.mvvmwithvolley.R;
import anew.gans.mvvmwithvolley.databinding.UserModelBinding;
import anew.gans.mvvmwithvolley.viewmodel.UserModel;


public class CustomAdapter extends BaseAdapter {

    private ArrayList<UserModel> arrayList;
    private Context context;
    private UserModelBinding userModelBinding;

    public CustomAdapter(Context context, ArrayList<UserModel> arrayList)
    {

        this.context = context;
        this.arrayList = arrayList;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {


        if(convertview == null)
        {

            convertview = LayoutInflater.from(context).inflate(R.layout.innerlayout,null);
            userModelBinding = DataBindingUtil.bind(convertview);
            convertview.setTag(userModelBinding);
        }
        else
        {
            userModelBinding = (UserModelBinding)convertview.getTag();
        }

        userModelBinding.setUsermodel(arrayList.get(position));


        return userModelBinding.getRoot();




    }





}