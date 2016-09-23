package appewtc.masterung.sutfriend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private ImageView imageView;
    private TextView nameTextView, addressTextView,
            phoneTextView, genderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView4);
        nameTextView = (TextView) findViewById(R.id.textView11);
        genderTextView = (TextView) findViewById(R.id.textView12);
        addressTextView = (TextView) findViewById(R.id.textView13);
        phoneTextView = (TextView) findViewById(R.id.textView14);

        //Show Image
        Picasso.with(this)
                .load(getIntent().getStringExtra("Image"))
                .resize(200,200)
                .into(imageView);

        //Show Text
        nameTextView.setText(getIntent().getStringExtra("Name"));
        genderTextView.setText(getIntent().getStringExtra("Gender"));
        addressTextView.setText(getIntent().getStringExtra("Address"));
        phoneTextView.setText(getIntent().getStringExtra("Phone"));

    }   // Main Method

    public void clickBack(View view) {
        finish();
    }

}   // Main Class
