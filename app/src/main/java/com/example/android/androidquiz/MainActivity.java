package com.example.android.androidquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private List<Question> questions = new ArrayList<>();  // All questions
    private TextView questionTextView;                          // question to show
    private EditText answerInput;
    private Button lifeButton;
    private Button scoreButton;
    private Button showAnswerButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private ImageView imageView;
    private boolean answerAccess = true;
    private int life = 2;
    private int count = 0;                    // index of question
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = (TextView) findViewById(R.id.question);
        lifeButton = (Button) findViewById(R.id.life);
        showAnswerButton = (Button) findViewById(R.id.answer_button);
        scoreButton = (Button) findViewById(R.id.score);
        lifeButton.setText(life + "");
        radioButton1 = (RadioButton) findViewById(R.id.answer1);
        radioButton2 = (RadioButton) findViewById(R.id.answer2);
        radioButton3 = (RadioButton) findViewById(R.id.answer3);
        radioButton4 = (RadioButton) findViewById(R.id.answer4);
        checkBox1 = (CheckBox) findViewById(R.id.answer_check1);
        checkBox2 = (CheckBox) findViewById(R.id.answer_check2);
        checkBox3 = (CheckBox) findViewById(R.id.answer_check3);
        checkBox4 = (CheckBox) findViewById(R.id.answer_check4);
        answerInput = (EditText) findViewById(R.id.answer_input);
        imageView = (ImageView) findViewById(R.id.imageView);
        scoreButton.setText(score + "");

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("SCORE");
            scoreButton.setText(score + "");
            setScoreImage();
            life = savedInstanceState.getInt("LIFE");
            lifeButton.setText(life + "");
            count = savedInstanceState.getInt("COUNT");
            answerAccess = savedInstanceState.getBoolean("ANSWER");
            if (!answerAccess) {
                showAnswerButton.setClickable(false);
                showAnswerButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_visibility_off_black_24dp), null, null);
            }
        }
        initializeQuestions();
        showNewQuestion();


    }

    /* This method will populate the questions list with all quiz questions */
    private void initializeQuestions() {
        questions.add(new Question(Constants.question1, Constants.correctAnswers1, Constants.wrongAnswers1));
        questions.add(new Question(Constants.question2, Constants.correctAnswers2, Constants.wrongAnswers2));
        questions.add(new Question(Constants.question3, Constants.correctAnswers3, null));
        questions.add(new Question(Constants.question4, Constants.correctAnswers4, null));
        questions.add(new Question(Constants.question5, Constants.correctAnswers5, Constants.wrongAnswers5));
        questions.add(new Question(Constants.question6, Constants.correctAnswers6, Constants.wrongAnswers6));
        questions.add(new Question(Constants.question7, Constants.correctAnswers7, Constants.wrongAnswers7));
        questions.add(new Question(Constants.question8, Constants.correctAnswers8, Constants.wrongAnswers8));
        questions.add(new Question(Constants.question9, Constants.correctAnswers9, Constants.wrongAnswers9));

    }

    /* This method will display a new question with it answers on the screen */
    private void showNewQuestion() {
        uncheck();
        // if the current question has a single answer, the correct answer, use editText for answer
        if (questions.get(count).getAnswers().size() == 1) {
            questionTextView.setText(questions.get(count).getQuestion());
            setVisibility(false, false);

        } else {
            // if the current question has a single correct answer (but also has wrong questions)
            // use radio buttons for answers
            if (questions.get(count).getCorrectAnswers().size() < 2) {
                questionTextView.setText(questions.get(count).getQuestion());
                radioButton1.setText(questions.get(count).getAnswers().get(0));
                radioButton2.setText(questions.get(count).getAnswers().get(1));
                radioButton3.setText(questions.get(count).getAnswers().get(2));
                radioButton4.setText(questions.get(count).getAnswers().get(3));
                setVisibility(true, false);

            }
            // use check boxes for answers
            else {
                questionTextView.setText(questions.get(count).getQuestion());
                checkBox1.setText(questions.get(count).getAnswers().get(0));
                checkBox2.setText(questions.get(count).getAnswers().get(1));
                checkBox3.setText(questions.get(count).getAnswers().get(2));
                checkBox4.setText(questions.get(count).getAnswers().get(3));
                setVisibility(false, true);
            }
        }
    }

    /* This method will uncheck the boxes, preparing for next question*/
    public void uncheck() {
        radioButton1.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        radioButton4.setChecked(false);
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        answerInput.setText("");
    }


    /* This method will show/hide the views */
    public void setVisibility(boolean radioButtons, boolean checkBox) {
        if (radioButtons) {
            radioButton1.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
            radioButton3.setVisibility(View.VISIBLE);
            radioButton4.setVisibility(View.VISIBLE);
            checkBox1.setVisibility(View.GONE);
            checkBox2.setVisibility(View.GONE);
            checkBox3.setVisibility(View.GONE);
            checkBox4.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
            answerInput.setVisibility(View.GONE);
        } else {
            if (checkBox) {
                radioButton1.setVisibility(View.GONE);
                radioButton2.setVisibility(View.GONE);
                radioButton3.setVisibility(View.GONE);
                radioButton4.setVisibility(View.GONE);
                checkBox1.setVisibility(View.VISIBLE);
                checkBox2.setVisibility(View.VISIBLE);
                checkBox3.setVisibility(View.VISIBLE);
                checkBox4.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                answerInput.setVisibility(View.GONE);
            } else {
                checkBox1.setVisibility(View.GONE);
                checkBox2.setVisibility(View.GONE);
                checkBox3.setVisibility(View.GONE);
                checkBox4.setVisibility(View.GONE);
                radioButton1.setVisibility(View.GONE);
                radioButton2.setVisibility(View.GONE);
                radioButton3.setVisibility(View.GONE);
                radioButton4.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                // this question has an image
                int resourceId = getResources().getIdentifier("image" + count, "drawable",
                        getPackageName());
                imageView.setImageResource(resourceId);
                answerInput.setVisibility(View.VISIBLE);
            }
        }
    }


    public void onRadioButtonClicked(View view) {
        // only one radio button can be checked at a time
        uncheck();
        ((RadioButton) view).setChecked(true);
    }

    // change the score button image depending on score
    public void setScoreImage() {
        if (score == 2) {
            scoreButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_sentiment_dissatisfied_black_24dp), null, null);
        }
        if (score == 4) {
            scoreButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_sentiment_neutral_black_24dp), null, null);
        }
        if (score == 6) {
            scoreButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_sentiment_satisfied_black_24dp), null, null);
        }
        if (score == 8) {
            scoreButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp), null, null);

        }
    }


    public void onCorrectAnswer() {
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        score++;
        setScoreImage();
        scoreButton.setText(score + "");
    }

    public void onWrongAnswer() {
        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
        life--;
        lifeButton.setText(life + "");
        lifeButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_favorite_border_black_24dp), null, null);
    }


    public void onNextClick(View view) {
        if (answerInput.getVisibility() == View.VISIBLE) {
            if (answerInput.getText().length() > 0) {
                // is the answer correct?
                if (answerInput.getText().toString().equalsIgnoreCase(questions.get(count).getCorrectAnswers().get(0))) {
                    onCorrectAnswer();
                } else {
                    onWrongAnswer();
                }
                showNewQuestionIfNeeded();
            } else {
                Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show();
            }
        } else {
            // save the checked answers for compare
            List<String> choice = new ArrayList<>();

            if (radioButton1.getVisibility() == View.VISIBLE) {
                if (radioButton1.isChecked()) {
                    choice.add(radioButton1.getText().toString());
                }
                if (radioButton2.isChecked()) {
                    choice.add(radioButton2.getText().toString());
                }
                if (radioButton3.isChecked()) {
                    choice.add(radioButton3.getText().toString());
                }
                if (radioButton4.isChecked()) {
                    choice.add(radioButton4.getText().toString());
                }
            } else {
                if (checkBox1.getVisibility() == View.VISIBLE) {
                    if (checkBox1.isChecked() && checkBox1.getVisibility() == View.VISIBLE) {
                        choice.add(checkBox1.getText().toString());
                    }
                    if (checkBox2.isChecked() && checkBox2.getVisibility() == View.VISIBLE) {
                        choice.add(checkBox2.getText().toString());
                    }
                    if (checkBox3.isChecked() && checkBox3.getVisibility() == View.VISIBLE) {
                        choice.add(checkBox3.getText().toString());
                    }
                    if (checkBox4.isChecked() && checkBox4.getVisibility() == View.VISIBLE) {
                        choice.add(checkBox4.getText().toString());
                    }
                }
            }
            if (choice.size() == 0) {
                Toast.makeText(this, "Please choose an answer", Toast.LENGTH_SHORT).show();
            } else {
                if (listEqualsNoOrder(choice, questions.get(count).getCorrectAnswers())) {
                    onCorrectAnswer();
                } else {
                    onWrongAnswer();
                }
                showNewQuestionIfNeeded();
            }
        }

    }

    /* This method will return true if the user answer is the same with coreect answer */
    public static <T> boolean listEqualsNoOrder(List<T> l1, List<T> l2) {
        final Set<T> s1 = new HashSet<>(l1);
        final Set<T> s2 = new HashSet<>(l2);
        return s1.equals(s2);
    }

    private void showNewQuestionIfNeeded() {
        if (life == 0) {
            Toast.makeText(this, "You lose! :(", Toast.LENGTH_LONG).show();
            finish();
        } else {
            //
            if (count < questions.size() - 1) {
                count++;
                showNewQuestion();
            } else {                                 // no more questions
                Toast.makeText(this, "Score = " + score + "\nWell done!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    /* This method will check the correct answers */
    public void showAnswer(View view) {
        if (answerAccess) {
            if (answerInput.getVisibility() == View.VISIBLE) {
                answerInput.setText(questions.get(count).getCorrectAnswers().get(0));
            } else {
                if (radioButton1.getVisibility() == View.VISIBLE) {
                    if (radioButton1.getText().equals(questions.get(count).getCorrectAnswers().get(0))) {
                        radioButton1.setChecked(true);
                    }
                    if (radioButton1.getText().equals(questions.get(count).getCorrectAnswers().get(0))) {
                        radioButton1.setChecked(true);
                    }
                    if (radioButton1.getText().equals(questions.get(count).getCorrectAnswers().get(0))) {
                        radioButton1.setChecked(true);
                    }
                    if (radioButton1.getText().equals(questions.get(count).getCorrectAnswers().get(0))) {
                        radioButton1.setChecked(true);
                    }
                }
                if (checkBox1.getVisibility() == View.VISIBLE) {
                    if (questions.get(count).getCorrectAnswers().contains(checkBox1.getText().toString())) {
                        checkBox1.setChecked(true);
                    }
                    if (questions.get(count).getCorrectAnswers().contains(checkBox2.getText().toString())) {
                        checkBox2.setChecked(true);
                    }
                    if (questions.get(count).getCorrectAnswers().contains(checkBox3.getText().toString())) {
                        checkBox3.setChecked(true);
                    }
                    if (questions.get(count).getCorrectAnswers().contains(checkBox4.getText().toString())) {
                        checkBox4.setChecked(true);
                    }
                }
            }
            answerAccess = false;
            showAnswerButton.setClickable(false);
            showAnswerButton.setCompoundDrawablesWithIntrinsicBounds(null, getDrawable(R.drawable.ic_visibility_off_black_24dp), null, null);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("SCORE", score);
        outState.putInt("LIFE", life);
        outState.putInt("COUNT", count);
        outState.putBoolean("ANSWER", answerAccess);
        uncheck();
        super.onSaveInstanceState(outState);
    }


}
