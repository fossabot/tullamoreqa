/*
 * Copyright (c) 2018. Gavin Kenna
 */

package com.gkenna.tullamoreqa.core.api.services;

import com.gkenna.tullamoreqa.domain.Question;
import com.gkenna.tullamoreqa.domain.Tag;
import com.gkenna.tullamoreqa.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    void addQuestion(Question question);

    void deleteQuestion(Question question);

    Question deleteQuestion(long id);

    Question updateQuestion(Long questionId, Question input);

    boolean doesQuestionExist(Question question);

    boolean doesQuestionExist(long id);

    Question getQuestion(long id);

    Iterable<Question> getAllQuestions();

    Question[] findQuestionsByTitle(String title);

    Question[] findQuestionsAskedByUser(User user);

    Question[] findQuestionsAnsweredByUser(User user);

    Question[] findQuestionsByTag(Tag tag);

}
