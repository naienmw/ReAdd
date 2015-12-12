package markus.readd;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Second_Activity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Integer rot = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);


        Intent i = getIntent();

        rot = i.getIntExtra("Angle",0);

        Button theButton = (Button) findViewById(R.id.freaking_button);

        theButton.setRotation(rot);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    public void test2(View view) {



        Toast.makeText(Second_Activity.this, "Hallo!", Toast.LENGTH_SHORT).show();



        rot = rot + 10;

        Intent intent = new Intent();
        intent.putExtra("angle",rot);
        setResult(1,intent);
        finish();
    }

}
