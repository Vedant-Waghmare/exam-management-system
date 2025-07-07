package vedant;

import java.util.ArrayList;


public class QuestionDB {
	Question q;
	ArrayList<Question>Qlist;
	private ExamDBMSservice eds;
	
public QuestionDB() {
		super();
		// TODO Auto-generated constructor stub
		eds=new ExamDBMSservice ();
		Qlist = eds.findAll();
	}

boolean add(Question q)	
{
	if(eds.add(q))
	{
		Qlist.add(q);
		return true;
	}
	return false;
}//add

void remove(Question q)	
{
	    eds.remove(q);
		Qlist.remove(q);
}//remove

Question findByQuestion(String target)	
{
		for (int i = 0; i < Qlist.size(); i++) {
			Question q = Qlist.get(i);
			if(q.getQ().toLowerCase().indexOf(target)!=-1)
				return q;
		}//for
		return null;
}//findByQuestion

int size()
{
	return Qlist.size();
}//size

Question get(int i)
{
	return Qlist.get(i);
}//get

void showAll()
{
	int i;
	for(i=0;i<Qlist.size();i++)
	{
		Question q = Qlist.get(i);
		System.out.println(q);
	}//for
}//showAll
}
