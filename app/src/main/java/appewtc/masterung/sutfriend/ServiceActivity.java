package appewtc.masterung.sutfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    }   // Main Method

}   // Main Class
