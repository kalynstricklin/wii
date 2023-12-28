import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

import javax.bluetooth.RemoteDevice;
import java.util.ArrayList;
import java.util.List;

public class PairWii implements MoteFinderListener{
    Mote mote;
    Object lock = new Object();
    MoteFinder finder;

    public PairWii(){
//        MoteFinderListener listener = new MoteFinderListener() {
//            @Override
//            public void moteFound(Mote mote) {
//                System.out.println("Wii Remote Found: "+ mote.getBluetoothAddress());
//                mote.rumble(20001);
//                motes.add(mote);
//            }
//        };
//        MoteFinder finder = MoteFinder.getMoteFinder();
//        finder.addMoteFinderListener(listener);
//        System.out.println("Starting wii remote discovery");
//        finder.startDiscovery();
//
//        System.out.println("Thread sleeping");
//        try {
//            Thread.sleep(300001);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("stopping discovery");
//        finder.stopDiscovery();
//
//        for(Mote m: motes){
//            m.disconnect();
//        }
    }

    @Override
    public void moteFound(Mote mote) {
        System.out.println("Wii remote found");
        this.mote = mote;
        synchronized (lock){
            lock.notifyAll();
        }
    }

    public Mote findMote(){
        if(finder==null){
            finder = MoteFinder.getMoteFinder();
            finder.addMoteFinderListener(this);
        }
        System.out.println("Starting discovery");
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

//    MoteFinder finder;
//    Mote device;
//
//    @Override
//    public void moteFound(Mote mote) {
//        //logger.info("Remote found notification");
//        this.device = mote;
//        mote.disableIrCamera();
//        finder.removeMoteFinderListener(this);
//
//    }
//    public Mote findRemote(){
//        if (device == null) {
//            finder = MoteFinder.getMoteFinder();
//        }
//        finder.addMoteFinderListener(this);
//        finder.startDiscovery();
//
//        return device;
//    }
}