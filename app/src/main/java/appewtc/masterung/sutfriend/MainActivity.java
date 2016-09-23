package appewtc.masterung.sutfriend;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText6);
        passwordEditText = (EditText) findViewById(R.id.editText7);

    }   // Main Method

    private class SynchronizeData extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private static final String urlJSON = "http://swiftcodingthai.com/Sut/get_data_master.php";

        public SynchronizeData(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("SutFriendV3", "e doInBack ==> " + e.toString());
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("SutFriendV3", "JSON ==> " + s);


        }   // onPost

    }   //SynData Class

    public void clickSignIn(View view) {

        //Get Value from Edit Text
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(this, R.drawable.doremon48,
                    "Have Space", "Please Fill All Every Blank");
            myAlert.myDialog();

        } else {
            //No Space
            SynchronizeData synchronizeData = new SynchronizeData(this);
            synchronizeData.execute();

        }


    }   // clickSignIn

    //Get Event From Click Button
    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   // Main Class นี่คือ คลาสหลัก
