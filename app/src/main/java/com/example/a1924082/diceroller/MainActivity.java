package com.example.a1924082.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText userinput;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void dicebutton(View view) {


        TextView tv = (TextView)this.findViewById(R.id.numberTextView);
        TextView pointview = (TextView)this.findViewById(R.id.pv);
        userinput = (EditText) findViewById(R.id.ui);


        Random r = new Random();

        int number = r.nextInt(6) + 1;


        tv.setText(Integer.toString(number));

        int guess= Integer.parseInt(userinput.getText().toString());



        if (guess < 1 || guess > 6) {

            Toast.makeText(this, "Enter between 1 and 6!", Toast.LENGTH_SHORT).show();

        } else if (guess == number) {

            Toast.makeText(this, "CONGRATULATIONS!", Toast.LENGTH_SHORT).show();
            points = points + 1;
            pointview.setText(Integer.toString(points));
        }


    }
}
