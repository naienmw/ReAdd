package markus.readd;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import markus.readd.R;

class my_adapter extends ArrayAdapter<String> {

    private int myResourcexml;
    private int mytextViewID;
    private Context myContext;
    private String[] myList;

    public my_adapter(Context context, String[] values) {
        super(context, R.layout.row_layout_2,values);
    }
    /*public my_adapter(Context context, @LayoutRes int resource, @IdRes int textViewResourceId,
                      String[] list) {
        super(context,resource,textViewResourceId,list);
        myResourcexml = resource;
        mytextViewID = textViewResourceId;
        myContext = context;
        myList = list;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater theInflater = LayoutInflater.from(getContext());

        //View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);
        View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);

        String tvShow = getItem(position);

        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);

        theTextView.setText(tvShow);

        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);

        theImageView.setImageResource(R.drawable.arrow);

        return theView;
    }
};
