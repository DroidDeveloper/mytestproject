package com.example.test.testproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.testproject.adapters.MyRecyclerViewAdapter;
import com.example.test.testproject.pojo.MyPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonRequestCode extends Activity {
    
    RecyclerView recyclerView;
    LinearLayoutManager linear;

    String url="http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

    ArrayList<MyPojo> mData=new ArrayList<>();

    MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_request_code);
        
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        linear=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        
        fetchResponseData();


        
        
        
    }

    private void fetchResponseData() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonarray) {
                for (int i = 0; i < jsonarray.length(); i++) {
                    try {
                        JSONObject jsonObject = jsonarray.getJSONObject(i);
                        MyPojo pojo=new MyPojo();
                        pojo.setmName(jsonObject.optString("name"));
                        pojo.setmAge(jsonObject.optString("age"));
                        pojo.setmGrade(jsonObject.optString("grade"));
                        mData.add(pojo);
                        Log.d("JsonResult",mData.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                mAdapter=new MyRecyclerViewAdapter(mData);
                recyclerView.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonRequestCode.this,"Unable to fetch data",Toast.LENGTH_LONG).show();
            }
        });
  requestQueue.add(request);

    }
}
