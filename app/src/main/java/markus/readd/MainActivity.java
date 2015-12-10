package markus.readd;

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
//ist das behindertttttttttttttttttttttttt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String tvShowPicked = "You Selected " +
                        String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
