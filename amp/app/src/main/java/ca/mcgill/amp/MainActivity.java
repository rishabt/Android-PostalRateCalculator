package ca.mcgill.amp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity.*;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerOptionCountry;
    private Spinner spinnerOptionItemType;
    private Spinner spinnerOptionCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        populateSpinners();
    }

    private void populateSpinners () {

        // Grab all the views
        spinnerOptionCountry = (Spinner) findViewById(R.id.locations_spinner);
        spinnerOptionItemType = (Spinner) findViewById(R.id.types_spinner);
        spinnerOptionCategory = (Spinner) findViewById(R.id.category_spinner);
        // Use default spinner adapters to populate each spinner with array from strings.xml

        ArrayAdapter<CharSequence> adapterSpinnerCountry = ArrayAdapter.createFromResource(
                this,
                R.array.locations_array, android.R.layout.simple_spinner_item
        );
        adapterSpinnerCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionCountry.setAdapter(adapterSpinnerCountry);

        ArrayAdapter<CharSequence> adapterSpinnerItemType = ArrayAdapter.createFromResource(
                this,
                R.array.types_array, android.R.layout.simple_spinner_item
        );
        adapterSpinnerItemType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionItemType.setAdapter(adapterSpinnerItemType);

        ArrayAdapter<CharSequence> adapterSpinnerCatagory = ArrayAdapter.createFromResource(
                this,
                R.array.category_array, android.R.layout.simple_spinner_item
        );
        adapterSpinnerCatagory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptionCategory.setAdapter(adapterSpinnerCatagory);

    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
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

    public void onCalculateClick(View view)
    {
        spinnerOptionCountry = (Spinner) findViewById(R.id.locations_spinner);
        spinnerOptionItemType = (Spinner) findViewById(R.id.types_spinner);
        spinnerOptionCategory = (Spinner) findViewById(R.id.category_spinner);

        String type = spinnerOptionItemType.getSelectedItem().toString();
        String category = spinnerOptionCategory.getSelectedItem().toString();

        String country =spinnerOptionCountry.getSelectedItem().toString();

        double weight = 0;
        EditText ed = (EditText)findViewById(R.id.editWeight);
        String text =ed.getText().toString();
        if(text.length()>0)
            weight= Double.parseDouble(text);

        double length=0;
        EditText l = (EditText)findViewById(R.id.editLength);
        String len =l.getText().toString();
        if(len.length()>0)
            length= Double.parseDouble(len);

        double width=0;
        EditText w = (EditText)findViewById(R.id.editWidth);
        String wid =w.getText().toString();
        if(len.length()>0)
            width= Double.parseDouble(wid);

        double height=0;
        EditText h = (EditText)findViewById(R.id.editHeight);
        String hei =h.getText().toString();
        if(len.length()>0)
            height= Double.parseDouble(hei);



        Item item=null;
        if(type.equals("Stamps in booklets/coils/panes"))
        {
            item = Item.REGULAR_STAMPS;
        }
        else if(type.equals("Meter or Postal Indicia")){
            item = Item.REGULAR_METERPOSTALINDICA;
        }
        else if(type.equals("Stamp(s)")){
            item = Item.REGULAR_SINGLESTAMP;
        }

        double cost= new PostalCalculator(height,length,width,weight,item,country).calculate();

        TextView costDisplay = (TextView)findViewById(R.id.editRate);
        if(cost == -1 || cost == -2)
            costDisplay.setText("invalid parameters");
        else if (cost == -3)
            costDisplay.setText("invalid size");
        else
            costDisplay.setText(Double.toString(cost));

    }
}
