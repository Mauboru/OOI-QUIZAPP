package tecno.maub.tec.quizapp.models;

import java.util.*;

public class Question {
    private final String statement;
    private final String correctAnswer;
    private final String[] othersAlternatives;
    private final ArrayList<String> allsAlternatives;

    public Question(String statement, String correctAnswer, String[] othersAlternatives,
            ArrayList<String> allsAlternatives) {
        this.statement = statement;
        this.correctAnswer = correctAnswer;
        this.othersAlternatives = othersAlternatives;
        this.allsAlternatives = new ArrayList<>();

        for (String alternative : othersAlternatives) {
            allsAlternatives.add(alternative);
        }
        this.allsAlternatives.add(correctAnswer);
        Collections.shuffle(allsAlternatives);
    }

    public String getStatement() {
        return statement;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getOthersAlternatives() {
        return othersAlternatives;
    }

    public List<String> getAllsAlternatives() {
        return Collections.unmodifiableList(allsAlternatives);
    }

    @Override
    public String toString() {
        return "Question [statement=" + statement + ", correctAnswer=" + correctAnswer + ", othersAlternatives="
                + Arrays.toString(othersAlternatives) + ", allsAlternatives=" + allsAlternatives + "]";
    }
}