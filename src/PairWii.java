import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class PairWii implements MoteFinderListener {

    MoteFinder finder;
    Mote mote;
   
    @Override
    public void moteFound(Mote mote) {
        //logger.info("Remote found notification");
        this.mote = mote;
        finder.removeMoteFinderListener(this);

    }
    public Mote findRemote(){
        if (finder == null) {
            finder = MoteFinder.getMoteFinder();
            finder.addMoteFinderListener(this);
        }
        finder.startDiscovery();
        return mote;
    }
}
