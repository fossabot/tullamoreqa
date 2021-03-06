/*
 * Copyright (c) 2018. Gavin Kenna
 */

package com.gkenna.tullamoreqa.domain;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AnswerTest {

    @InjectMocks
    private final Answer validAnswer;

    @InjectMocks
    private final Answer fullyFormedAnswer;

    @InjectMocks
    private final Answer invalidAnswer;

    private final String validBody = "Answer Body";
    private final String validBodyTwo = "Another Answer Body";

    @Mock
    private Question mockedQuestion;

    @Mock
    private Question mockedQuestionTwo;

    @Mock
    private User mockedUser;

    public AnswerTest() {
        MockitoAnnotations.initMocks(this);
        validAnswer = new Answer(mockedQuestion, mockedUser, validBody);
        invalidAnswer = new Answer(null, null, null);
        fullyFormedAnswer = new Answer(mockedQuestion, mockedUser, validBody);

        fullyFormedAnswer.setChosenAnswer(true);
        fullyFormedAnswer.setDownvotes(100);
        fullyFormedAnswer.setUpvotes(200);
    }

    @Test
    public void getQuestionValid() {
        assert validAnswer.getQuestion().equals(mockedQuestion);
    }

    @Test
    public void setQuestion() {
        validAnswer.setQuestion(mockedQuestionTwo);
        assert validAnswer.getQuestion().equals(mockedQuestionTwo);
        assert !validAnswer.getQuestion().equals(mockedQuestion);
        validAnswer.setQuestion(mockedQuestion);
        assert validAnswer.getQuestion().equals(mockedQuestion);
        assert !validAnswer.getQuestion().equals(mockedQuestionTwo);
    }

    @Test
    public void getBody() {
        assert validAnswer.getBody().equals(this.validBody);
    }

    @Test
    public void setBody() {
        validAnswer.setBody(validBodyTwo);
        assert validAnswer.getBody().equals(this.validBodyTwo);
        assert !validAnswer.getBody().equals(this.validBody);
        validAnswer.setBody(validBody);
    }

    @Test
    public void isChosenAnswer() {
        assert !validAnswer.isChosenAnswer();
        assert fullyFormedAnswer.isChosenAnswer();
    }

    @Test
    public void setChosenAnswer() {
        validAnswer.setChosenAnswer(true);
        assert validAnswer.isChosenAnswer();
        validAnswer.setChosenAnswer(false);
    }

    @Test
    public void getUpvotes() {
        assert validAnswer.getUpvotes() == 0;
        assert fullyFormedAnswer.getUpvotes() == 200;
    }

    @Test
    public void setUpvotes() {
        validAnswer.setUpvotes(50);
        assert validAnswer.getUpvotes() == 50;
        validAnswer.setUpvotes(0);
        assert validAnswer.getUpvotes() == 0;
    }

    @Test
    public void getDownvotes() {
        assert validAnswer.getDownvotes() == 0;
        assert fullyFormedAnswer.getDownvotes() == 100;
    }

    @Test
    public void setDownvotes() {
        validAnswer.setDownvotes(50);
        assert validAnswer.getDownvotes() == 50;
        validAnswer.setDownvotes(0);
        assert validAnswer.getDownvotes() == 0;
    }

    @Test
    public void getScore() {
        assert validAnswer.getScore() == 0;
        assert fullyFormedAnswer.getScore() == 100;

        validAnswer.setUpvotes(40);
        assert validAnswer.getScore() == 40;
        validAnswer.setDownvotes(60);
        assert validAnswer.getScore() == -20;

        validAnswer.setDownvotes(0);
        validAnswer.setUpvotes(0);
    }

    @Test
    public void compareEquals() {
        assert validAnswer != fullyFormedAnswer;
        assert validAnswer != invalidAnswer;
        assert fullyFormedAnswer != invalidAnswer;

        assert validAnswer == validAnswer;
        assert fullyFormedAnswer == fullyFormedAnswer;
        assert invalidAnswer == invalidAnswer;

        assert !validAnswer.equals(fullyFormedAnswer);
        assert !validAnswer.equals(invalidAnswer);
        assert !fullyFormedAnswer.equals(invalidAnswer);

        assert fullyFormedAnswer.equals(fullyFormedAnswer);
        assert validAnswer.equals(validAnswer);
        assert invalidAnswer.equals(invalidAnswer);
    }

    @Test
    public void compareHashcodes() {
        assert validAnswer.hashCode() != fullyFormedAnswer.hashCode();
        assert validAnswer.hashCode() != invalidAnswer.hashCode();
        assert fullyFormedAnswer.hashCode() != invalidAnswer.hashCode();
        assert validAnswer.hashCode() == validAnswer.hashCode();
        assert fullyFormedAnswer.hashCode() == fullyFormedAnswer.hashCode();
        assert invalidAnswer.hashCode() == invalidAnswer.hashCode();
    }
}