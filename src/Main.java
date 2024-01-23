//import com.intel.bluetooth.BlueCoveConfigProperties;

import com.intel.bluetooth.BlueCoveConfigProperties;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static WiiFrame wiiFrame;

    private static ArrayList<Mote> motes= new ArrayList<Mote>();

    public static void main(String[] args) {

        System.setProperty(BlueCoveConfigProperties.PROPERTY_JSR_82_PSM_MINIMUM_OFF, "true");
//        wiiFrame = new WiiFrame();

//        MoteFinderListener listener = new MoteFinderListener() {
//            @Override
//            public void moteFound(Mote mote) {
//                System.out.println("mote found: "+ mote.getBluetoothAddress());
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
//        for(Mote m: motes){
//            m.disconnect();
//        }


        //00:21:BD:79:81:C0

//        MoteFinderListener listener = new MoteFinderListener() {
//            @Override
//            public void moteFound(Mote mote) {
//                System.out.println("Found wii mote: "+ mote.getBluetoothAddress());
//                mote.rumble(2000l);
//
//            }
//        };
//        MoteFinder finder = MoteFinder.getMoteFinder();
//        finder.addMoteFinderListener(listener);
//        finder.startDiscovery();
//        try {
//            Thread.sleep(3000l);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        Mote mote = null;

//        Thread wiiThread = new Thread(){
//
//        }

        /* find wii remote*/
        PairWii pairWii = new PairWii();

        System.out.println("finding wii remote");
        pairWii.findMote();

        /*add wii remote from array of motes*/
        Mote mote = pairWii.motes.get(0);

        if (mote != null){
            System.out.println("mote is not null");
            /* adding button and accel to mote found*/
            WiiRemote wiiRemote = new WiiRemote(mote);


        }
//        //        finder.stopDiscovery();


//            try {
//                Thread.sleep(60001);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                mote.disconnect();
//            }

    }
}