import com.intel.bluetooth.BlueCoveConfigProperties;
import motej.CalibrationDataReport;
import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
        System.setProperty(BlueCoveConfigProperties.PROPERTY_JSR_82_PSM_MINIMUM_OFF, "true");
//        System.setProperty("bluecove.stack", "widcomm");
        System.setProperty(BlueCoveConfigProperties.PROPERTY_STACK, "winsock");

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());

        PairWii pairWii = new PairWii();
        Mote mote = pairWii.findMote();
        if (mote != null) {
            while (mote.getStatusInformationReport() == null) {
                System.out.println("Waiting for status report");
                try {
                    Thread.sleep(101);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.println(mote.getStatusInformationReport());

            while (mote.getCalibrationDataReport() == null) {
                System.out.println("Waiting fot calibration report");
                try {
                    Thread.sleep(101);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            System.out.println(mote.getCalibrationDataReport());
            CalibrationDataReport cali = mote.getCalibrationDataReport();

            mote.addAccelerometerListener(new AccelerometerListener<Mote>() {
                @Override
                public void accelerometerChanged(AccelerometerEvent<Mote> evt) {
                    System.out.println(evt.getX() + " : " + evt.getY() + " : " + evt.getZ());
//                        accelerometerPanel.accelerometerValueChanged(evt.getX(), evt.getY(), evt.getZ());
                    //						accx = evt.getX();
                    // 						accy = evt.getY();
                    // 						accz = evt.getZ();
                }
            });

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

            try {
                Thread.sleep(60001);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                mote.disconnect();
            }


        }
    }
}