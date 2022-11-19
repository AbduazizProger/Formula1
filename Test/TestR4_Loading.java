import junit.framework.TestCase;

public class TestR4_Loading extends TestCase {

    public void testLoadCorrectFile() throws Exception {

        Clinic c = new Clinic();
        c.loadData("correct_file.txt");

        Person p = new Person("Mario","Rossi","MRSDWIRFJSD");

        Person p1 = null;
        try {
            p1 = c.getPatient("MRSDWIRFJSD");
            assertEquals(p1.getFirst(), p.getFirst());
            assertEquals(p1.getLast(), p.getLast());
            assertEquals(p1.getSSN(), p.getSSN());
        } catch (NoSuchPatient e) {

            assertTrue("no patient created",p1!=null);
        }

        Doctor d = new Doctor("Sergio","Meri","STGSFIJ",1234,"Heart");

        Doctor d1 = null;
        try {
            d1 = c.getDoctor(1234);
            assertEquals(d1.getFirst(), d.getFirst());
            assertEquals(d1.getLast(), d.getLast());
            assertEquals(d1.getSSN(), d.getSSN());
            assertEquals(d1.getId(), d.getId());
            assertEquals(d1.getSpecialization(), d.getSpecialization());
        } catch (NoSuchDoctor e) {
            d = null;
            assertTrue("createDriver() returned null", d1 != null);
        }


    }

    public void testLoadWrong() throws Exception {

        Clinic c = new Clinic();
        c.loadData("wrong_file.txt");

        Person p = new Person("Mario","Rossi","MRSDWIRFJSD");

        Person p1 = null;
        try {
            p1 = c.getPatient("MRSDWIRFJSD");
            assertEquals(p1.getFirst(), p.getFirst());
            assertEquals(p1.getLast(), p.getLast());
            assertEquals(p1.getSSN(), p.getSSN());
        } catch (NoSuchPatient e) {

            assertTrue("no patient created",p1!=null);
        }

        Doctor d = new Doctor("Sergio","Meri","STGSFIJ",1234,"Heart");

        Doctor d1 = null;
        try {
            d1 = c.getDoctor(1234);
            assertEquals(d1.getFirst(), d.getFirst());
            assertEquals(d1.getLast(), d.getLast());
            assertEquals(d1.getSSN(), d.getSSN());
            assertEquals(d1.getId(), d.getId());
            assertEquals(d1.getSpecialization(), d.getSpecialization());
        } catch (NoSuchDoctor e) {
            d = null;
            assertTrue("createDriver() returned null", d1 != null);
        }


    }

}
