import junit.framework.TestCase;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestR5_Statistics extends TestCase {

    public void testIdleDoctors() throws NoSuchDoctor, NoSuchPatient{

        Clinic c = new Clinic();

        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");
        c.addDoctor("Gloria", "Marri", "MRRGLR76E43V456Y", 231, "Brain");
        c.addDoctor("Federico", "Marri", "MRRFDR76E33V436Z", 233, "Orthopedy");
        c.addDoctor("Sergio","Meri","STGSFIJ",1234,"Eye");

        c.addDoctor("Andrea","Vigi","VGINRA34R12A123E",1235,"Ear");

        c.addPatient("Marco", "Bagli", "BGLMRC67B54C432E");

        c.assignPatientToDoctor("BGLMRC67B54C432E", 1235);

        Collection<Doctor> cd = c.idleDoctors();
        List<Doctor> ld = new LinkedList<>(cd);

        assertEquals(4, cd.size());

        assertEquals("Federico", ld.get(0).getFirst());
        assertEquals("Gloria", ld.get(1).getFirst());
        assertEquals("Mario", ld.get(2).getFirst());
        assertEquals("Sergio", ld.get(3).getFirst());

    }

    public void testBusyDoctors() throws NoSuchDoctor, NoSuchPatient{

        Clinic c = new Clinic();

        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");
        c.addDoctor("Gloria", "Marri", "MRRGLR76E43V456Y", 231, "Brain");
        c.addDoctor("Federico", "Marri", "MRRFDR76E33V436Z", 233, "Orthopedy");
        c.addDoctor("Sergio","Meri","STGSFIJ",1234,"Eye");

        c.addDoctor("Andrea","Vigi","VGINRA34R12A123E",1235,"Ear");

        c.addPatient("Marco", "Bagli", "BGLMRC67B54C432E");
        c.addPatient("Stefano", "Negri" , "NGRSTF21R43C345F");
        c.addPatient("Stefania", "Stella" , "STFSTL32E34E456F");
        c.addPatient("Simone", "Valenti" , "VLNSMN56T21A345T");
        c.addPatient("Giovanna", "Laterra" , "LTRGVN43E21A456T");
        c.addPatient("Pier", "Certi" , "CRTPRI12A23D450K");

        c.assignPatientToDoctor("BGLMRC67B54C432E", 1235);
        c.assignPatientToDoctor("STFSTL32E34E456F", 233);
        c.assignPatientToDoctor("NGRSTF21R43C345F", 2);
        c.assignPatientToDoctor("CRTPRI12A23D450K", 231);
        c.assignPatientToDoctor("LTRGVN43E21A456T", 231);
        c.assignPatientToDoctor("VLNSMN56T21A345T", 233);

        Collection<Doctor> cd = c.busyDoctors();
        List<Doctor> ld = new LinkedList<>(cd);

        assertEquals(2, cd.size());

        assertEquals("Federico", ld.get(0).getFirst());
        assertEquals("Gloria", ld.get(1).getFirst());

    }

    public void testDoctorsByNumPatients() throws NoSuchDoctor, NoSuchPatient{

        Clinic c = new Clinic();

        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");
        c.addDoctor("Gloria", "Marri", "MRRGLR76E43V456Y", 231, "Brain");
        c.addDoctor("Federico", "Marri", "MRRFDR76E33V436Z", 233, "Orthopedy");
        c.addDoctor("Sergio","Meri","STGSFIJ",1234,"Eye");

        c.addDoctor("Andrea","Vigi","VGINRA34R12A123E",1235,"Ear");

        c.addPatient("Marco", "Bagli", "BGLMRC67B54C432E");
        c.addPatient("Stefano", "Negri" , "NGRSTF21R43C345F");
        c.addPatient("Stefania", "Stella" , "STFSTL32E34E456F");
        c.addPatient("Simone", "Valenti" , "VLNSMN56T21A345T");
        c.addPatient("Giovanna", "Laterra" , "LTRGVN43E21A456T");
        c.addPatient("Pier", "Certi" , "CRTPRI12A23D450K");
        c.addPatient("Eshmat", "Toshmatov" , "BBNBRS94E15Z259W");

        c.assignPatientToDoctor("BGLMRC67B54C432E", 1235);
        c.assignPatientToDoctor("STFSTL32E34E456F", 233);
        c.assignPatientToDoctor("NGRSTF21R43C345F", 2);
        c.assignPatientToDoctor("CRTPRI12A23D450K", 231);
        c.assignPatientToDoctor("BBNBRS94E15Z259W", 233);
        c.assignPatientToDoctor("LTRGVN43E21A456T", 231);
        c.assignPatientToDoctor("VLNSMN56T21A345T", 233);

        Collection<String> cp = c.doctorsByNumPatients();
        List<String> lp = new LinkedList<>(cp);

        assertEquals(5, lp.size());

        assertEquals("  3: Federico Marri", lp.get(0));
        assertEquals("  2: Gloria Marri", lp.get(1));
        assertEquals("  1: Mario Rossi", lp.get(2));
        assertEquals("  1: Andrea Vigi", lp.get(3));
        assertEquals("  0: Sergio Meri", lp.get(4));

    }

    public void testCountPatientsBySpecialization() throws NoSuchDoctor, NoSuchPatient{

        Clinic c = new Clinic();

        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");
        c.addDoctor("Gloria", "Marri", "MRRGLR76E43V456Y", 231, "Brain");
        c.addDoctor("Federico", "Marri", "MRRFDR76E33V436Z", 233, "Orthopedy");
        c.addDoctor("Sergio","Meri","STGSFIJ",1234,"Eye");

        c.addDoctor("Andrea","Vigi","VGINRA34R12A123E",1235,"Ear");

        c.addPatient("Marco", "Bagli", "BGLMRC67B54C432E");
        c.addPatient("Stefano", "Negri" , "NGRSTF21R43C345F");
        c.addPatient("Stefania", "Stella" , "STFSTL32E34E456F");
        c.addPatient("Simone", "Valenti" , "VLNSMN56T21A345T");
        c.addPatient("Giovanna", "Laterra" , "LTRGVN43E21A456T");
        c.addPatient("Pier", "Certi" , "CRTPRI12A23D450K");

        c.assignPatientToDoctor("BGLMRC67B54C432E", 1235);
        c.assignPatientToDoctor("STFSTL32E34E456F", 233);
        c.assignPatientToDoctor("NGRSTF21R43C345F", 2);
        c.assignPatientToDoctor("CRTPRI12A23D450K", 231);
        c.assignPatientToDoctor("LTRGVN43E21A456T", 231);
        c.assignPatientToDoctor("VLNSMN56T21A345T", 233);

        Collection<String> cp = c.countPatientsPerSpecialization();
        List<String> lp = new LinkedList<>(cp);

        assertEquals(5, lp.size());

        assertEquals("  2 Brain", lp.get(0));
        assertEquals("  2 Orthopedy", lp.get(1));
        assertEquals("  1 Ear", lp.get(2));
        assertEquals("  1 Heart", lp.get(3));
        assertEquals("  0 Eye", lp.get(4));

    }

}
