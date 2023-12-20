import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class PairWii implements MoteFinderListener {

    MoteFinder finder;
    Mote mote;
    Object lock = new Object();
    @Override
    public void moteFound(Mote mote) {
        //logger.info("Remote found notification");
        this.mote = mote;
        finder.removeMoteFinderListener(this);
        synchronized (lock){
            lock.notifyAll();
        }
    }
    public Mote findRemote(){
        if (finder == null) {
            finder = MoteFinder.getMoteFinder();
            finder.addMoteFinderListener(this);
        }
        finder.startDiscovery();
        try{
            synchronized (lock){
                lock.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return mote;
    }
}
