package sg.edu.rp.c346.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnReturn = (Button) findViewById(R.id.button);

        SharedPreferences sh = getSharedPreferences("info", MODE_APPEND);
        String rb1 = sh.getString("rb1", "");
        String rb2 = sh.getString("rb2", "");
        String rb3 = sh.getString("rb3", "");
        String reflection = sh.getString("reflection", "");

        TextView tv1 = findViewById(R.id.textView1);

        tv1.setText("Read up on materials before class: " + rb1
                + "\n\nArrive on time so as not to miss important part of the lesson: " + rb2
                + "\n\nAttempt the problem myself: " + rb3
                + "\n\nReflection: " + reflection);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                return;

            }
        });

    }

}
