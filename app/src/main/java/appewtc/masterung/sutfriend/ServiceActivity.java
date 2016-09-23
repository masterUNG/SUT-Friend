package appewtc.masterung.sutfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ListView listView;
    private String loginString;
    private String[] nameStrings, imageStrings, genderStrings,
            addressStrings, phoneStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Bind Widget
        textView = (TextView) findViewById(R.id.textView8);
        listView = (ListView) findViewById(R.id.listView);

        //Get Value From Intent
        loginString = getIntent().getStringExtra("Login");
        nameStrings = getIntent().getStringArrayExtra("Name");
        imageStrings = getIntent().getStringArrayExtra("Image");
        genderStrings = getIntent().getStringArrayExtra("Gender");
        addressStrings = getIntent().getStringArrayExtra("Address");
        phoneStrings = getIntent().getStringArrayExtra("Phone");

        //Show Text
        textView.setText("Welcome " + loginString);

        //Show ListView
        MyAdapter myAdapter = new MyAdapter(this, nameStrings, genderStrings, imageStrings);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ServiceActivity.this, DetailActivity.class);
                intent.putExtra("Image", imageStrings[i]);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Address", addressStrings[i]);
                intent.putExtra("Phone", phoneStrings[i]);
                intent.putExtra("Gender", genderStrings[i]);
                startActivity(intent);

            }   // onItemClick
        });


    }   // Main Method

}   // Main Class
