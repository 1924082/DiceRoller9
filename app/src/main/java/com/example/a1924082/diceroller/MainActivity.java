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

import java.util.ArrayList;
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

    public void dicebreaker(View view){

        TextView viewlist = (TextView)this.findViewById(R.id.vl);

        ArrayList<String> randomquestions = new ArrayList<>();
        randomquestions.add("1) If you could go anywhere in the world, where would you go?");
        randomquestions.add("2) If you were stranded on a desert island, what three things would you want to take with you?");
        randomquestions.add("3) If you could eat only one food for the rest of your life, what would that be?");
        randomquestions.add("4) If you won a million dollars, what is the first thing you would buy?");
        randomquestions.add("5) If you could spaned the day with one fictional character, who would it be?");
        randomquestions.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");



        Random rand = new Random();

        int numberOfElements = 1;



        for (int i = 0; i < numberOfElements; i++) {

            int ri = rand.nextInt(randomquestions.size());
            String randElement = randomquestions.get(ri);
            viewlist.setText(randElement);

        }

    }
}
