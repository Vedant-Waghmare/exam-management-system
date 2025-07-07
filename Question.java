package vedant;

import java.util.Objects;

public class Question {
	private String q, o1, o2, o3, o4, answer;
	private int QuestionID;
	
public Question() {
	super();
	// TODO Auto-generated constructor stub
}
	
	public Question(String q, String o1, String o2, String o3, String o4, String answer) {
		super();
		this.q = q;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.answer = answer;
	}
	public Question(int questionID, String q, String o1, String o2, String o3, String o4, String answer) {
		super();
		this.q = q;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.answer = answer;
		QuestionID = questionID;
	}

	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public String getO1() {
		return o1;
	}
	public void setO1(String o1) {
		this.o1 = o1;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public String getO3() {
		return o3;
	}
	public void setO3(String o3) {
		this.o3 = o3;
	}
	public String getO4() {
		return o4;
	}
	public void setO4(String o4) {
		this.o4 = o4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}

	@Override
	public String toString() {
		return "Question ~ "+q +  "\n\nA. "+o1 + "\nB. "+o2 + "\nC. "+o3 +"\nD. "+o4 ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(QuestionID, answer, o1, o2, o3, o4, q);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return QuestionID == other.QuestionID && Objects.equals(answer, other.answer) && Objects.equals(o1, other.o1)
				&& Objects.equals(o2, other.o2) && Objects.equals(o3, other.o3) && Objects.equals(o4, other.o4)
				&& Objects.equals(q, other.q);
	}
	
}
