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
//    public static WiiFrame wiiFrame;
    private static ArrayList<Mote> motes= new ArrayList<Mote>();

    public static void main(String[] args) {

        System.setProperty(BlueCoveConfigProperties.PROPERTY_JSR_82_PSM_MINIMUM_OFF, "true");

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
        PairWii pairWii = new PairWii();
        System.out.println("finding wii remote");
        pairWii.findMote();

        Mote mote = pairWii.mote;
//        pairWii.moteFound(mote);
        if (mote != null){
            System.out.println("mote is not null");
            System.out.println("adding core button listener");

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
//        //        finder.stopDiscovery();

//        if (mote != null) {
//            while (mote.getStatusInformationReport() == null) {
//                System.out.println("Waiting for status report");
//                try {
//                    Thread.sleep(101);
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            System.out.println(mote.getStatusInformationReport());
//
//            while (mote.getCalibrationDataReport() == null) {
//                System.out.println("Waiting fot calibration report");
//                try {
//                    Thread.sleep(101);
//                } catch (InterruptedException e2) {
//                    e2.printStackTrace();
//                }
//            }
//            System.out.println(mote.getCalibrationDataReport());
//            CalibrationDataReport cali = mote.getCalibrationDataReport();
//
//            mote.addAccelerometerListener(new AccelerometerListener<Mote>() {
//                @Override
//                public void accelerometerChanged(AccelerometerEvent<Mote> evt) {
//                    System.out.println(evt.getX() + " : " + evt.getY() + " : " + evt.getZ());
////                        accelerometerPanel.accelerometerValueChanged(evt.getX(), evt.getY(), evt.getZ());
//                    //						accx = evt.getX();
//                    // 						accy = evt.getY();
//                    // 						accz = evt.getZ();
//                }
//            });
//

//
//            try {
//                Thread.sleep(60001);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                mote.disconnect();
//            }
//
//
//        }
    }
}