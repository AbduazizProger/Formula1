import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Clinic {
    private Map<String, Person> patient_list = new HashMap<String, Person>();
    private Map<Integer, Doctor> doctor_list = new HashMap<Integer, Doctor>();

    public void addPatient(String first, String last, String ssn) {
        Person newPatient = new Person(first, last, ssn);
        patient_list.put(ssn, newPatient);
    }

    public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
        Doctor doctor = new Doctor(first, last, ssn, docID, specialization);
        addPatient(first, last, ssn);
        doctor_list.put(docID, doctor);
    }

    public Person getPatient(String ssn) throws NoSuchPatient {
        // TODO Auto-generated method stub
        return patient_list.get(ssn);
    }

    public Doctor getDoctor(int docID) throws NoSuchDoctor {
        // TODO Auto-generated method stub
        return doctor_list.get(docID);
    }

    public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
        Doctor doc = doctor_list.get(docID);
        Person patient = patient_list.get(ssn);
        patient.setDoctor(doc);
        doc.addPatient(patient);
    }

    /**
     * returns the collection of doctors that have no patient at all, sorted in alphabetic order.
     */
    Collection<Doctor> idleDoctors(){
        List<Doctor> doctors = new LinkedList<Doctor>();
        for (Doctor doc: doctor_list.values()) {
            if (doc.getPatients().size() == 0) {
                doctors.add(doc);
            }
        }
        Collections.sort(doctors);
        return doctors;
    }

    /**
     * returns the collection of doctors that a number of patients larger than the average.
     */
    Collection<Doctor> busyDoctors(){
        List<Doctor> doctors = new LinkedList<>();
        int sum = 0;
        for (Doctor doc: doctor_list.values()) {
            sum += doc.getPatients().size();
        }
        int average = sum / doctor_list.size();
        for (Doctor doc: doctor_list.values()) {
            if (doc.getPatients().size() > average) {
                doctors.add(doc);
            }
        }
        Collections.sort(doctors);
        return doctors;
    }

    /**
     * returns list of strings
     * containing the name of the doctor and the relative number of patients
     * with the relative number of patients, sorted by decreasing number.<br>
     * The string must be formatted as "<i>### : ID SURNAME NAME</i>" where <i>###</i>
     * represent the number of patients (printed on three characters).
     */
    Collection<String> doctorsByNumPatients(){
        List<Doctor> doctors = new LinkedList<Doctor>();
        for (Doctor doc: doctor_list.values()) {
            int i = 0;
            for (i = 0; i < doctors.size(); i++) {
                if (doc.getPatients().size() > doctors.get(i).getPatients().size()) {
                    break;
                }
            }
            doctors.add(i, doc);
        }
        List<String> num_patient = new LinkedList<String>();
        for (Doctor doc: doctors) {
            num_patient.add(String.format("%3d", doc.getPatients().size()) + ": " + doc.getFirst() + " " + doc.getLast());
        }
        return num_patient;
    }

    /**
     * computes the number of
     * patients per (their doctor's) specialization.
     * The elements are sorted first by decreasing count and then by alphabetic specialization.<br>
     * The strings are structured as "<i>### - SPECIALITY</i>" where <i>###</i>
     * represent the number of patients (printed on three characters).
     */
    public Collection<String> countPatientsPerSpecialization(){
        TreeMap<String, Integer> spec_num = new TreeMap<String, Integer>();
        for (Doctor doc: doctor_list.values()) {
            if (spec_num.containsKey(doc.getSpecialization())) {
                spec_num.put(doc.getSpecialization(), spec_num.get(doc.getSpecialization()) + doc.getPatients().size());
            } else {
                spec_num.put(doc.getSpecialization(), doc.getPatients().size());
            }
        }
        List<String> result_list = new LinkedList<String>();
        for (String spec: spec_num.keySet()) {
            int i = 0;
            for (i = 0; i < result_list.size(); i++) {
                if (spec_num.get(spec) > Integer.parseInt(result_list.get(i).substring(0, 3).strip())) {
                    break;
                }
            }
            result_list.add(i, String.format("%3d", spec_num.get(spec)) + " " + spec);
        }
        return result_list;
    }

    public void loadData(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ";");
            if (line.startsWith("P;")) {
                st.nextToken();
                addPatient(st.nextToken(), st.nextToken(), st.nextToken());
            } else if (line.startsWith("M;")) {
                st.nextToken();
                int id = Integer.parseInt(st.nextToken());
                addDoctor(st.nextToken(), st.nextToken(), st.nextToken(), id, st.nextToken());
            }
        }
        br.close();
    }
}
