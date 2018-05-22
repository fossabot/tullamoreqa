package com.gkenna.tullamoreqa.domain.service;


import com.gkenna.tullamoreqa.domain.Answer;
import com.gkenna.tullamoreqa.domain.Question;
import com.gkenna.tullamoreqa.domain.Tag;
import com.gkenna.tullamoreqa.domain.User;
import com.gkenna.tullamoreqa.domain.repositories.AnswerRepository;
import com.gkenna.tullamoreqa.domain.repositories.QuestionRepository;
import com.gkenna.tullamoreqa.domain.repositories.UserRepository;
import com.gkenna.tullamoreqa.domain.service.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public void addQuestion() {
        User gavin = new User();
        gavin.setUsername("Gavin");

        User bob = new User();
        bob.setUsername("Bob");

        User alice = new User();
        alice.setUsername("Alice");

        userRepository.save(gavin);
        userRepository.save(bob);
        userRepository.save(alice);

        Question q = new Question();
        q.setUser(gavin);

        Question qq = new Question();
        qq.setUser(alice);

        Answer a = new Answer();
        a.setUser(alice);
        a.setQuestion(q);

        Answer b = new Answer();
        b.setUser(bob);
        b.setQuestion(q);

        Answer c = new Answer();
        c.setUser(gavin);
        c.setQuestion(qq);

        Set<Answer> answers = new HashSet<Answer>();
        answers.add(a);
        answers.add(b);

        q.setAnswers(answers);

        qq.setAnswers(Collections.singleton(c));

        questionRepository.save(q);
        answerRepository.saveAll(answers);

        questionRepository.save(qq);
        answerRepository.save(c);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Question question) {

    }

    @Override
    public void deleteQuestion(long id) {

    }

    @Override
    public void editQuestion(Question question) {

    }

    @Override
    public boolean doesQuestionExist(Question question) {
        return false;
    }

    @Override
    public boolean doesQuestionExist(long id) {
        return false;
    }

    @Override
    public Question getQuestion(long id) {
        return null;
    }

    @Override
    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question[] findQuestionsByTitle(String title) {
        return new Question[0];
    }

    @Override
    public Question[] findQuestionsAskedByUser(User user) {
        return new Question[0];
    }

    @Override
    public Question[] findQuestionsAnsweredByUser(User user) {
        return new Question[0];
    }

    @Override
    public Question[] findQuestionsByTag(Tag tag) {
        return new Question[0];
    }
}