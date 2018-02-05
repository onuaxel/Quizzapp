package com.example.android.quizzapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    int score = 0;

    //This method will give feedback case answer is correct
    public void correctAnswer (int resource) {
        TextView questionName1 = findViewById(resource);
        questionName1.setTextColor(0xFF00FF00);
        questionName1.setTextSize(20);
        score +=1;
    }

    private void wrongAnswer (int resource){
        TextView questionName = findViewById(resource);
        questionName.setTextColor(0xFF0000FF);
        questionName.setTextSize(25);
    }





    public void checkAnswers (View view) {

        String text = " ";


        //Control question 1
        //Make input from answer checkbox to boolean data
        boolean answ1Quest1 = ((CheckBox) findViewById(R.id.checkbox1_question1)).isChecked();
        boolean answ2Quest1 = ((CheckBox) findViewById(R.id.checkbox2_question1)).isChecked();
        boolean answ3Quest1 = ((CheckBox) findViewById(R.id.checkbox3_question1)).isChecked();
        boolean answ4Quest1 = ((CheckBox) findViewById(R.id.checkbox4_question1)).isChecked();
        if (answ1Quest1 && answ2Quest1 && answ3Quest1 && !answ4Quest1 ) {
            correctAnswer(R.id.question_name1);
            text = text + getString(R.string.feedBackQ1Correct);

        } else {
            wrongAnswer(R.id.question_name1);
            text = text +getString(R.string.feedBackQ1NotCorrect);
        }

        //Control question 2
        RadioButton radioButtonQ2A2 = findViewById(R.id.radio2_q2);
        RadioButton radioButtonQ2A1 = findViewById(R.id.radio1_q2);
        RadioButton radioButtonQ2A3 = findViewById(R.id.radio3_q2);
        if (radioButtonQ2A2.isChecked()) {
            correctAnswer(R.id.question_name2);
            text = text + getString(R.string.feedBackQ2Correct);
        }
        else if (radioButtonQ2A1.isChecked() || radioButtonQ2A3.isChecked()) {
            wrongAnswer(R.id.question_name2);
            text = text +getString(R.string.feedBackQ2NotCorrect);
        } else {
            wrongAnswer(R.id.question_name2);
            text = text +getString(R.string.feedBackQ2NotCorrect);
        }


        //Control question 3
        boolean answ1Quest3 = ((CheckBox) findViewById(R.id.checkbox1_question3)).isChecked();
        boolean answ2Quest3 = ((CheckBox) findViewById(R.id.checkbox2_question3)).isChecked();
        boolean answ3Quest3 = ((CheckBox) findViewById(R.id.checkbox3_question3)).isChecked();
        if (answ1Quest3 && !answ2Quest3 && !answ3Quest3){
            correctAnswer(R.id.question_name3);
            text = text + getString(R.string.feedBackQ3Correct);
        }
        else {
            wrongAnswer(R.id.question_name3);
            text = text + getString(R.string.feedBackQ3NotCorrect);
        }

        // Find if the user has seen concrete around him/her
        EditText questin4 = findViewById(R.id.q4_textinput);
        String answer4 = questin4.getText().toString();
        if (answer4.length()>0){
            correctAnswer(R.id.question_name4);
            text = text +getString(R.string.feedBackQ4Pos);

        }
        else {
            wrongAnswer(R.id.question_name4);
            text = text + getString(R.string.feedBackQ4Neg);
        }
        String points = "You got "+score +" of 3!\n";
        text = points + text;


        //Give feedback in a toast form.
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();





    }
}
