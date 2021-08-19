package ru.otus.gpbu.pse.homework03.domain;

public class Answer {
    private final String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()){
            return false;
        }

        Answer other = (Answer) obj;

        return this.answer.equals(other.answer);
    }

    @Override
    public int hashCode() {
        return this.answer.hashCode();
    }

    @Override
    public String toString(){
        return answer;
    }

}
