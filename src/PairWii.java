import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import javax.swing.*;
import java.util.ArrayList;


public class PairWii implements MoteFinderListener {
    Mote mote;
    boolean[] remoteLEDs = new boolean[4];
    ArrayList<Mote> motes = new ArrayList<>();

    public PairWii() {
        remoteLEDs[0] = true;
        remoteLEDs[1] = false;
        remoteLEDs[2] =false;
        remoteLEDs[3] =false;
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


    public void moteFound(Mote mote){
        this.mote = mote;
    }
    public void findMote(){
        MoteFinderListener listener = new MoteFinderListener() {
            @Override
            public void moteFound(Mote mote) {
                System.out.println("mote found: " + mote.getBluetoothAddress());
                motes.add(mote);
                mote.rumble(2000L);
                mote.setPlayerLeds(remoteLEDs);

            }
        };
        MoteFinder finder = MoteFinder.getMoteFinder();
        finder.addMoteFinderListener(listener);

        System.out.println("starting discovery");
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
//        if(finder==null){
//            finder = MoteFinder.getMoteFinder();
//            finder.addMoteFinderListener(this);
//        }
//        System.out.println("Starting discovery in findMote");
//        finder.startDiscovery();
//        try{
//            synchronized (lock){
//                lock.wait();
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return mote;
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


    public void getButtons(){
        mote.addCoreButtonListener(new CoreButtonListener() {

            @Override
            public void buttonPressed(CoreButtonEvent coreButtonEvent) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if (coreButtonEvent.isButtonAPressed() && coreButtonEvent.isButtonBPressed()) {
                            System.out.println("AB");

                        } else if (coreButtonEvent.isButtonAPressed()) {
                            System.out.println("BUTTON_A");

                        } else if (coreButtonEvent.isButtonBPressed()) {
                            System.out.println("BUTTON_B");

                        } else if (coreButtonEvent.isButtonPlusPressed()) {
                            System.out.println("BUTTON_PLUS");

                        } else if (coreButtonEvent.isButtonMinusPressed()) {
                            System.out.println("BUTTON_MINUS");

                        } else if (coreButtonEvent.isButtonHomePressed()) {
                            System.out.println("BUTTON_HOME");

                        } else if (coreButtonEvent.isDPadLeftPressed()) {
                            System.out.println("D_PAD_LEFT");

                        } else if (coreButtonEvent.isDPadRightPressed()) {
                            System.out.println("D_PAD_RIGHT");

                        } else if (coreButtonEvent.isDPadUpPressed()) {
                            System.out.println("D_PAD_UP");

                        } else if (coreButtonEvent.isDPadDownPressed()) {
                            System.out.println("D_PAD_DOWN");

                        } else if (coreButtonEvent.isButtonOnePressed()) {
                            System.out.println("BUTTON_ONE");

                        } else if (coreButtonEvent.isButtonTwoPressed()) {
                            System.out.println("BUTTON_TWO");

                        } else if (coreButtonEvent.isNoButtonPressed()) {
                            System.out.println("NONE");
                        }
                    }
                });
            }
        });
    }
}