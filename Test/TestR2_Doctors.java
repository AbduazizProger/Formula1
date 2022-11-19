import junit.framework.TestCase;

public class TestR2_Doctors extends TestCase {

    public void testCreatePatients() {

        Clinic c = new Clinic();

        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");

        Doctor d = new Doctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");
        Doctor d1 = null;
        try {
            d1 = c.getDoctor(2);
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

    public void testDoctorAsPerson() {

        Clinic c = new Clinic();
        c.addDoctor("Mario", "Rossi", "MRARSS56T12L435F",2,"Heart");

        Person p = new Person("Mario", "Rossi", "MRARSS56T12L435F");

        Person p1 = null;
        try {

            p1 = c.getPatient("MRARSS56T12L435F");

            assertEquals(p1.getFirst(), p.getFirst());
            assertEquals(p1.getLast(), p.getLast());
            assertEquals(p1.getSSN(), p.getSSN());

        } catch (Exception e) {


            assertTrue("no patient created",p1!=null);

        }

    }

    public void testNoSuchDoctor() {

        Clinic c = new Clinic();

        try {

            c.getDoctor(2);

        } catch (Exception e) {

            assertTrue(e instanceof NoSuchDoctor);
        }

    }
}
