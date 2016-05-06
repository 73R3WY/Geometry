package jeremypacabis.geometry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jeremy Patrick on 4/18/2016.
 * Author: Jeremy Patrick G. Pacabis
 */
public class RectangleResults extends Activity {
    private TextView WIDTH_in, LENGTH_in, AREA_out, PERIMETER_out;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangleresults);

        init();
        displayResults();
    }

    private void init() {
        mIntent = getIntent();

        WIDTH_in = (TextView) findViewById(R.id.in_WIDTH);
        LENGTH_in = (TextView) findViewById(R.id.in_LENGTH);
        AREA_out = (TextView) findViewById(R.id.out_AREA);
        PERIMETER_out = (TextView) findViewById(R.id.out_PERIMETER);
    }

    private void displayResults() {
        WIDTH_in.setText(WIDTH_in.getText().toString() + mIntent.getIntExtra("DATA_WIDTH", 69) + " units.");
        LENGTH_in.setText(LENGTH_in.getText().toString() + mIntent.getIntExtra("DATA_LENGTH", 69) + " units.");
        AREA_out.setText(AREA_out.getText().toString() + mIntent.getIntExtra("DATE_AREA", 69) + " square units.");
        PERIMETER_out.setText(PERIMETER_out.getText().toString() + mIntent.getIntExtra("DATA_PERIMETER", 69) + " units.");
    }
}
