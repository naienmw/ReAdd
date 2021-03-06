package markus.readd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import markus.readd.R;

public class MainActivity extends AppCompatActivity {

    public int rot_Angle;
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] favoriteTVShows ={"The Office", "Breaking Bad", "The Help",
                "Walking Dead", "Twin Peaks", "Freaks and Geeks", "Orphan Black", "Breakding Bad", "The 400", "Life on Mars", "Orphan Black", "Breakding Bad", "The 400", "Life on Mars"};



        //final ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        // favoriteTVShows);


        //final ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.row_layout,R.id.textView1,
        //favoriteTVShows);

        //final ListAdapter theAdapter = new my_adapter(this,R.layout.row_layout_2,R.id.textView2, favoriteTVShows); //ansich cool weil so eingestellt werden kann welches Layout, aber die textviews überlappen ja nicht im Layout..
        final ListAdapter theAdapter = new my_adapter(this, favoriteTVShows);

        ListView theListView = (ListView) findViewById(R.id.theListView);

        theListView.setAdapter(theAdapter);

       /* SharedPreferences myStorage = this.getSharedPreferences("my_prefs",MODE_WORLD_READABLE);
        SharedPreferences.Editor prefsEdit = myStorage.edit();
        prefsEdit.putInt("Angle",rot_Angle);
        prefsEdit.commit();*/
        final Intent second_activity = new Intent(this, Second_Activity.class);
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                second_activity.putExtra("Angle",rot_Angle);
                String tvShowPicked = "You Selected " +
                        String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
                startActivityForResult(second_activity, 1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                rot_Angle = data.getIntExtra("angle", 0);
            }
        }
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
