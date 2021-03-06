package roxanac.trainer;

import roxanac.person.Person;


import java.util.*;

public class Trainer extends Person {
    public String specialization;
    public Integer yearsOfExperience;
    Map<String, Integer> feedbackList = new Hashtable<>();
    public Trainer(){
    }

    public Trainer(String firstName, String lastName, int age, String gender, String email, String specialization, Integer yearsOfExperience) {
        super(firstName, lastName, age, gender, email);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Trainer(String specialization, int yearsOfExperience, HashMap<String, Integer> feedbackList) {
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.feedbackList = feedbackList;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if(yearsOfExperience> this.yearsOfExperience)
            this.yearsOfExperience = yearsOfExperience;
    }

    public Map<String, Integer> getFeedbackList() {
        return feedbackList;
    }

    public void printDetails(){
        System.out.println("Trainer first name:" + this.getFirstName());
        System.out.println("Trainer last name:" + this.getLastName());
        System.out.println("Specialization:" + this.getSpecialization());
        System.out.println("Years of experience:" + this.getYearsOfExperience());
        System.out.println("Feedback:" + this.getFeedbackList());

    }

    public void addFeedback(String name, Integer feedback){
        if(feedback <= 10 && feedback >= 0)
            feedbackList.put(name, feedback);

    }

    public float calculateHighiestAverageFeedbackTrainer(){
        int average = 0;
        int count = 0;
        float result;
        Set entrySet = feedbackList.entrySet();
        Iterator it = entrySet.iterator();

        while(it.hasNext())
        {
            Map.Entry feedbackValue = (Map.Entry)it.next();
            count ++;
            average = average +  (int)feedbackValue.getValue();
        }
        result = (float)average/count;
        return  result;
    }

}
