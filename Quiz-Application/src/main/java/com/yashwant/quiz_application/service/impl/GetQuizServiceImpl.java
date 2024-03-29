package com.yashwant.quiz_application.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashwant.quiz_application.dtos.CreateQuizDto;
import com.yashwant.quiz_application.entity.CreateQuiz;
import com.yashwant.quiz_application.entity.Question;
import com.yashwant.quiz_application.repository.CreateQuizRepo;
import com.yashwant.quiz_application.service.GetQuizService;
import com.yashwant.quiz_application.util.GetQuizRequest;
import com.yashwant.quiz_application.util.GetQuizResponse;
import com.yashwant.quiz_application.util.Quiz_Questions;

@Service
public class GetQuizServiceImpl implements GetQuizService {
	
	@Autowired
	private CreateQuizRepo quizRepo;
	
	@Autowired
	private CreateQuizServiceImpl quizService;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public GetQuizResponse getQuiz(GetQuizRequest request) {
		// TODO Auto-generated method stub
		
		String quizid = request.getQuizId();
		String slot = request.getSlot();
		String classNumber = request.getClassNumber();
		
		CreateQuizDto quiz1 = quizService.getQuizById(quizid);
		CreateQuiz quiz = mapper.map(quiz1, CreateQuiz.class);
		
		GetQuizResponse response = new GetQuizResponse();
		response.setClassNumber(classNumber);
		response.setInstruction(quiz.getInstructions());
		response.setQuizId(quiz.getQuizId());
		response.setSlot(quiz.getSlot());
		response.setTotalQuestion(quiz.getTotalQuestions());
		List<Question>questions = quiz.getQuestions();
		List<Quiz_Questions>question = new ArrayList<>();
		for(Question qes : questions)
		{
			Quiz_Questions que = new Quiz_Questions();
			que.setQuestionId(qes.getQuestionId());
			que.setQuestionTitle(qes.getQuestionTitle());
			que.setOption1(qes.getOption1());
			que.setOption2(qes.getOption2());
			que.setOption3(qes.getOption3());
			que.setOption4(qes.getOption4());
			question.add(que);

		}
		Collections.shuffle(question);
		response.setQuestions(question);
		return response;
	}

}
