import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Doctor extends Person implements Comparable<Doctor> {
    private String specialization;
    private int id;
    private List<Person> patient_list = new LinkedList<Person>();
    public Doctor(String first, String last, String ssn, int id, String specialization) {
        super(first, last, ssn);
        this.specialization = specialization;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getSpecialization(){
        return this.specialization;
    }

    public Collection<Person> getPatients() {
        return patient_list;
    }

    public void addPatient(Person patient){
        patient_list.add(patient);
    }

    @Override
    public int compareTo(Doctor d) {
        return this.getFirst().compareTo(d.getFirst());
    }
}
