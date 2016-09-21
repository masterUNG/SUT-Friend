package appewtc.masterung.sutfriend;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class SignUpActivity extends AppCompatActivity {

    //Explicit การประกาศตัวแปร
    private EditText nameEditText, addressEditText,
            phoneEditText, userEditText, passwordEditText;
    private String nameString, addressString, phoneString,
            userString, passwordString, genderString, imageString,
            imagePathString, imageNameString;
    private RadioButton maleRadioButton, femaleRadioButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        addressEditText = (EditText) findViewById(R.id.editText2);
        phoneEditText = (EditText) findViewById(R.id.editText3);
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        maleRadioButton = (RadioButton) findViewById(R.id.radioButton);
        femaleRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        imageView = (ImageView) findViewById(R.id.imageView);

        //ImageView Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 1);

            }   // onClick
        });


    }   // Main Method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1) && (resultCode == RESULT_OK)) {

            Log.d("SutFriendV1", "Result ==> Success");

            //Find Path of Image
            Uri uri = data.getData();
            imagePathString = myFindPath(uri);


        }   // if

    }   // onActivityResult

    private String myFindPath(Uri uri) {

        String strResult = null;

        String[] strings = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);

        if () {

        } else {

        }



        return strResult;
    }

    public void clickSignUpSign(View view) {

        // Get Value From Edit Text
        nameString = nameEditText.getText().toString().trim();
        addressString = addressEditText.getText().toString().trim();
        phoneString = phoneEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("") || addressString.equals("") ||
                phoneString.equals("") || userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(this, R.drawable.doremon48,
                    "มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");
            myAlert.myDialog();
        } else if (!(maleRadioButton.isChecked() || femaleRadioButton.isChecked())) {
            //Non Check
            MyAlert myAlert = new MyAlert(this, R.drawable.nobita48,
                    "ยังไม่เลือก Gender", "กรุณาเลือก Gender");
            myAlert.myDialog();
        }


    }   // clickSign


}   // Main Class





