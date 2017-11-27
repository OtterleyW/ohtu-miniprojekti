package data_access;

import domain.Kirja;
import domain.Lukuvinkki;
import domain.StubKirja;

import java.util.ArrayList;

public class StubKirjaDAO implements KirjaDAO {

    @Override
    public ArrayList<Lukuvinkki> getAll() {
        ArrayList<Lukuvinkki> list = new ArrayList<>();
        list.add(new StubKirja());
        list.add(new StubKirja());
        list.add(new StubKirja());
        list.add(new StubKirja());
        list.add(new StubKirja());
        list.add(new StubKirja());
        return list;
    }

    @Override
    public void save(Kirja kirja) {
        //Not yet done(täytyi vaihtaa kommentiksi, jotta testit toimivat)
    }

    @Override
    public void markRead(String id, boolean luettu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
