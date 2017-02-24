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

    public Question(String question, List<String> correctAnswers, List<String> wrongAnswers) {
        this.question = question;
        this.correctAnswers = correctAnswers;
        try {
            answers.addAll(wrongAnswers);
        } catch (Exception e) {
        }
        answers.addAll(correctAnswers);
        Collections.shuffle(answers);
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }


}
