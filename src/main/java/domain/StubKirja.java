package domain;

public class StubKirja implements Lukuvinkki {

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }

    public String toString() {
        String s = "minä olen testiolio " +"\n" +
                "Lorem ipsum dolor sit amet, jne jne jne.";
        return s;
    }

    @Override
    public int getLuettu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
