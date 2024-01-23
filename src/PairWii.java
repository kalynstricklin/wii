import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import javax.swing.*;
import java.util.ArrayList;


public class PairWii {
    Mote mote;
    boolean[] remoteLEDs = new boolean[4];
    ArrayList<Mote> motes = new ArrayList<>();

    public PairWii() {
        remoteLEDs[0] = false;
        remoteLEDs[1] = true;
        remoteLEDs[2] = false;
        remoteLEDs[3] = false;
//        this.mote = mote;
//        MoteFinderListener listener = new MoteFinderListener() {
//            @Override
//            public void moteFound(Mote mote) {
//                System.out.println("mote found: " + mote.getBluetoothAddress());
//                mote.rumble(2000L);
//
//                motes.add(mote);
//            }
//        };
//        MoteFinder finder = MoteFinder.getMoteFinder();
//        finder.addMoteFinderListener(listener);
//
//        System.out.println("starting discovery");
//        finder.startDiscovery();
//
//        System.out.println("Putting thread to sleep..");
//        try {
//            Thread.sleep(30000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        System.out.println("Stopping discovery..");
//        finder.stopDiscovery();
//        for (Mote m : motes) {
//            m.disconnect();
//        }
    }


//    public void moteFound(Mote mote){
//        this.mote = mote;
//    }
    public void findMote(){
        MoteFinderListener listener = new MoteFinderListener() {
            @Override
            public void moteFound(Mote mote) {
                System.out.println("mote found: " + mote.getBluetoothAddress());
                mote.rumble(2000L);
                mote.setPlayerLeds(remoteLEDs);
                motes.add(mote);


            }
        };
        MoteFinder finder = MoteFinder.getMoteFinder();
        finder.addMoteFinderListener(listener);

        System.out.println("starting discovery");
        System.out.println("press the sync button on the back of the remote near the batteries OR hold down together buttons 1,2");
        finder.startDiscovery();

        System.out.println("Putting thread to sleep..");
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//        System.out.println("Stopping discovery..");
//        finder.stopDiscovery();

//        for (Mote m : motes) {
//            m.disconnect();
//        }
    }

//
//    @Override
//    public void moteFound(Mote mote) {
//        //logger.info("Remote found notification");
//        this.device = mote;
//        mote.disableIrCamera();
//        finder.removeMoteFinderListener(this);
//
//    }


}