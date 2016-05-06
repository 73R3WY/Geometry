package jeremypacabis.geometry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Jeremy Patrick on 4/18/2016.
 * Author: Jeremy Patrick G. Pacabis
 */
public class MenuActivity extends Activity implements View.OnClickListener {
    private Button RECTANGLE, SQUARE, CIRCLE, EXIT;
    private Intent startActivityIntent;
    private Class className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        init(); // initialize buttons
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRectangle:
                startThisActivity("RectangleInputs");
                break;
            case R.id.btnSquare:
                Toast.makeText(this, "Square Activity not defined yet, please define...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCircle:
                Toast.makeText(this, "Circle Activity not defined yet, please define...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnExit:
                finish();
                break;
        }

    }

    private void init() {
        RECTANGLE = (Button) findViewById(R.id.btnRectangle);
        SQUARE = (Button) findViewById(R.id.btnSquare);
        CIRCLE = (Button) findViewById(R.id.btnCircle);
        EXIT = (Button) findViewById(R.id.btnExit);

        RECTANGLE.setOnClickListener(this);
        SQUARE.setOnClickListener(this);
        CIRCLE.setOnClickListener(this);
        EXIT.setOnClickListener(this);
    }

    private void startThisActivity(String activity) {
        try {
            className = Class.forName("jeremypacabis.geometry." + activity);
            startActivityIntent = new Intent(MenuActivity.this, className);
            startActivity(startActivityIntent);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
}
