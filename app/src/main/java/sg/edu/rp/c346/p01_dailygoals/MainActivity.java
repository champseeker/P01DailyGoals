package sg.edu.rp.c346.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3;
    EditText etRe;
    Button btnOk;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = findViewById(R.id.button);
        etRe = findViewById(R.id.etReflection);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String[] checkedButtonsId = {"c1", "c2", "c3"};
        for (String i: checkedButtonsId) {
            int j = prefs.getInt(i, 0);
            if (j != 0) {
                RadioButton rbc = findViewById(j);
                rbc.setChecked(true);
            }
        }
        etRe.setText(prefs.getString("rj", ""));

        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();

                if(selectedButtonId1 == -1 || selectedButtonId2 == -1 || selectedButtonId3 == -1 || etRe.equals("")){
                    Toast.makeText(MainActivity.this, "Please make sure that all options are selected and filled", Toast.LENGTH_SHORT).show();
                }else {

                    RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);
                    RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                    RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                    SharedPreferences.Editor myEdit = prefs.edit();
                    myEdit.putString("rb1", rb1.getText().toString());
                    myEdit.putString("rb2", rb2.getText().toString());
                    myEdit.putString("rb3", rb3.getText().toString());
                    myEdit.putString("reflection", etRe.getText().toString());
                    myEdit.commit();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);

                }

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        SharedPreferences sh = getSharedPreferences("info", MODE_APPEND);
        String rb1 = sh.getString("rb1", "");
        String rb2 = sh.getString("rb2", "");
        String rb3 = sh.getString("rb3", "");
        String reflection = sh.getString("reflection", "");

        if (rb1.equals("Yes")) {
            rg1.check(R.id.radioButton);
        }else {
            rg1.check(R.id.radioButton2);
        }

        if (rb2.equals("Yes")) {
            rg2.check(R.id.radioButton3);
        }else {
            rg2.check(R.id.radioButton4);
        }

        if (rb3.equals("Yes")) {
            rg3.check(R.id.radioButton5);
        }else {
            rg3.check(R.id.radioButton6);
        }

        etRe.setText(reflection);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("info", MODE_APPEND);
        String rb1 = sh.getString("rb1", "");
        String rb2 = sh.getString("rb2", "");
        String rb3 = sh.getString("rb3", "");
        String reflection = sh.getString("reflection", "");

        if (rb1.equals("Yes")) {
            rg1.check(R.id.radioButton);
        }else {
            rg1.check(R.id.radioButton2);
        }

        if (rb2.equals("Yes")) {
            rg2.check(R.id.radioButton3);
        }else {
            rg2.check(R.id.radioButton4);
        }

        if (rb3.equals("Yes")) {
            rg3.check(R.id.radioButton5);
        }else {
            rg3.check(R.id.radioButton6);
        }

        etRe.setText(reflection);

    }
}
