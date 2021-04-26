package Answer;

import java.io.Serializable;

public class Answer implements Serializable {

    private String stringAnswer;
    private AnswerStatus answerStatus;
    private Object objectAnswer;


    public Answer(String stringAnswer, AnswerStatus answerStatus) {
        this.stringAnswer = stringAnswer;
        this.answerStatus = answerStatus;
    }

    public Answer(Object objectAnswer, AnswerStatus answerStatus) {
        this.answerStatus = answerStatus;
        this.objectAnswer = objectAnswer;
    }

    public void printAnswer(){
        System.out.println(stringAnswer);
    }

    public String getStringAnswer() {
        return stringAnswer;
    }

    public AnswerStatus getAnswerStatus() {
        return answerStatus;
    }

    public Object getObjectAnswer() {
        return objectAnswer;
    }
}