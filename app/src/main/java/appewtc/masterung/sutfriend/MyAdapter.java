package appewtc.masterung.sutfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 9/23/2016 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] nameStrings, genderStrings, imageStrings;
    private ImageView imageView;
    private TextView nameTextView, genderTextView;

    public MyAdapter(Context context, String[] nameStrings, String[] genderStrings, String[] imageStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.genderStrings = genderStrings;
        this.imageStrings = imageStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        //Bind Widget
        imageView = (ImageView) view1.findViewById(R.id.imageView3);
        nameTextView = (TextView) view1.findViewById(R.id.textView9);
        genderTextView = (TextView) view1.findViewById(R.id.textView10);

        //Show Text
        nameTextView.setText(nameStrings[i]);
        genderTextView.setText(genderStrings[i]);

        //Show Image
        Picasso.with(context).load(imageStrings[i]).resize(150,150).into(imageView);


        return view1;
    }
}   // Main Class
