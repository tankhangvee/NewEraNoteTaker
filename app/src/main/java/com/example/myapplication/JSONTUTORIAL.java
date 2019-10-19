package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONTUTORIAL extends AppCompatActivity {

    private TextView tvdisplay;
    private Button btngetname,btngetcourse,btngetage,btngetbook,btngetlibraryId,btnborrowbook,btnstatus,btngetfriendinfo;
    private String myjsonobject = "{\n" +
            "  \"studentName\": \"Tan Khang Vee\",\n" +
            "  \"CourseName\": \"DIT\",\n" +
            "  \"Age\": \"19\",\n" +
            "  \"borrowedbooks\": [\n" +
            "    \"aaa\",\n" +
            "    \"bbb\",\n" +
            "    \"ccc\",\n" +
            "    \"ddd\"\n" +
            "  ],\n" +
            "  \"libraryProfile\": {\n" +
            "    \"libraryId\": \"123\",\n" +
            "    \"numberofBorrowedBooks\": \"3\",\n" +
            "    \"allowedToEnter\": \"true\"\n" +
            "  }\n" +
            "}";
    private JSONObject myjson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsontutorial);
        findViews();
        setListeners();
        preparejson();
    }

    private void findViews(){
        btngetname = findViewById(R.id.btngn);
        btngetcourse = findViewById(R.id.btngc);
        btngetage = findViewById(R.id.btnga);
        tvdisplay = findViewById(R.id.tv);
        btngetbook = findViewById(R.id.btnb);
        btngetlibraryId = findViewById(R.id.btnid);
        btnborrowbook = findViewById(R.id.btnbb);
        btnstatus = findViewById(R.id.btns);
        btngetfriendinfo = findViewById(R.id.btnf);
    }

    private void setListeners(){
        btngetname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = myjson.getString("studentName");
                    tvdisplay.setText(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btngetcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String course = myjson.getString("CourseName");
                    tvdisplay.setText(course);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btngetage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String age = myjson.getString("Age");
                    tvdisplay.setText(age);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btngetbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray booksarray = new JSONArray(myjson.getString("borrowedbooks"));
                    String result = " ";
                    for(int i=0; i<booksarray.length(); i++){
                        String bookname = booksarray.getString(i);
                        result += bookname + "\n";
                    }
                    tvdisplay.setText(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btngetlibraryId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject libraryJsonObject = new JSONObject(myjson.getString("libraryProfile"));
                    String libraryId = libraryJsonObject.getString("libraryId");
                    tvdisplay.setText(libraryId);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnborrowbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btngetfriendinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray friendsArray = myjson.getJSONArray("friends");
                    for(int i=0; i<friendsArray.length(); i++){

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void preparejson(){
        try {
            myjson = new JSONObject(myjsonobject);
        } catch (JSONException e) {

        }
    }
}
