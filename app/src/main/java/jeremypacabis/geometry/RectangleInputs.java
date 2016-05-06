package jeremypacabis.geometry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jeremy Patrick on 4/18/2016.
 * Author: Jeremy Patrick G. Pacabis
 */
public class RectangleInputs extends Activity implements View.OnClickListener {
    private EditText WIDTH_IN, LENGTH_IN;
    private Button CALCULATE;
    private int width, length, area, perimeter;
    private Intent resultsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectanglein);

        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRectangleCalc:
                width = Integer.parseInt(WIDTH_IN.getText().toString().equals("") ? "0" : WIDTH_IN.getText().toString());
                length = Integer.parseInt(LENGTH_IN.getText().toString().equals("") ? "0" : LENGTH_IN.getText().toString());
                area = width * length;
                perimeter = (2 * width) + (2 * length);

                // to view the inputs in the Android Monitor, uncomment the next line
                // Log.d("WEW", "Data:\nWidth: " + width + "\nLength: " + length);

                resultsIntent = new Intent(this, RectangleResults.class);
                resultsIntent.putExtra("DATA_WIDTH", width);
                resultsIntent.putExtra("DATA_LENGTH", length);
                resultsIntent.putExtra("DATA_PERIMETER", perimeter);
                resultsIntent.putExtra("DATE_AREA", area);
                startActivity(resultsIntent);
                break;
        }
    }

    private void init() {
        WIDTH_IN = (EditText) findViewById(R.id.input_txt_WIDTH);
        LENGTH_IN = (EditText) findViewById(R.id.input_txt_LENGTH);
        CALCULATE = (Button) findViewById(R.id.btnRectangleCalc);

        CALCULATE.setOnClickListener(this);
    }
}
