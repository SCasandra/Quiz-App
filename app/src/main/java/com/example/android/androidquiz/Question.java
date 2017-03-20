package com.example.android.androidquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Casi on 23.02.2017.
 */

public class Question {
    private String question;
    private List<String> correctAnswers;
    private List<String> answers = new ArrayList<>();

    /**
     * Create a new {@link Question} object.
     *
     * @param question       is the string resource for the question
     * @param correctAnswer1 is the string resource for the first correct answer associated with this question
     * @param correctAnswer2 is the string resource for the second correct answer associated with this question
     * @param correctAnswer3 is the string resource for the third correct answer associated with this question
     * @param wrongAnswer1   is the string resource for the first wrong answer associated with this question
     * @param wrongAnswer2   is the string resource for the second wrong answer associated with this question
     * @param wrongAnswer3   is the string resource for the third wrong answer associated with this question
     */
    public Question(String question, String correctAnswer1, String correctAnswer2, String correctAnswer3,
                    String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.question = question;

        // always must know the correct answer(s)
        correctAnswers = new ArrayList<>();

        if (!correctAnswer1.equals("null")) {
            correctAnswers.add(correctAnswer1);
        }
        if (!correctAnswer2.equals("null")) {
            correctAnswers.add(correctAnswer2);
        }
        if (!correctAnswer3.equals("null")) {
            correctAnswers.add(correctAnswer3);
        }
        if (!wrongAnswer1.equals("null")) {
            answers.add(wrongAnswer1);
        }
        if (!wrongAnswer2.equals("null")) {
            answers.add(wrongAnswer2);
        }
        if (!wrongAnswer3.equals("null")) {
            answers.add(wrongAnswer3);
        }

        answers.addAll(correctAnswers);
        // the answers must be shuffle, to be ensure that the user know the answer, not the position of the correct answer ;)
        Collections.shuffle(answers);
    }

    /**
     * Return the correct answers of the question
     */
    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * Return the question string resource
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Return the answers of the question
     */
    public List<String> getAnswers() {
        return answers;
    }


}
