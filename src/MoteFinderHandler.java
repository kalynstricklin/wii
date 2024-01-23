import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class MoteFinderHandler implements MoteFinderListener {
    Mote mote;
    private static final long MESSAGE_DELAY =10000;

    public MoteFinderHandler(){
        mote = null;
    }
    @Override
    public void moteFound(Mote mote) {
        this.mote = mote;
    }
    public Mote findMote(){
        MoteFinder moteFinder = MoteFinder.getMoteFinder();
        moteFinder.addMoteFinderListener(this);
        moteFinder.startDiscovery();
        long lastTimedMsg = 0;
        while(mote == null){
            long currentTime = System.currentTimeMillis();
            if((currentTime-lastTimedMsg)>= MESSAGE_DELAY){
                lastTimedMsg = currentTime;

            }
            try{
                Thread.sleep(100);
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
        }

        moteFinder.stopDiscovery();
        return mote;
    }
}
