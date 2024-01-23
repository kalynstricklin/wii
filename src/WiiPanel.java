import motej.CalibrationDataReport;
import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WiiPanel extends JPanel  {

    JButton connectButton;
    Mote mote;
    MoteFinderHandler moteFinderHandler;
//    PairWii pairWii;
//    private boolean[] leds = new boolean[] { false, false, false, false};

    public WiiPanel(){
        setBackground(Color.GRAY);
        connectButton = new JButton("CONNECT WII");
        connectButton.setBackground(Color.white);
        connectButton.addActionListener(e -> new MoteFinderHandler().findMote());
//        connectButton.addActionListener(e -> new PairWii().findMote());
        add(connectButton);

    }
    public Action findAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mote = moteFinderHandler.findMote();
//            mote.addIrCameraListener();
//            mote.enableIrCamera();
            mote.disableIrCamera();
            mote.setReportMode(ReportModeRequest.DATA_REPORT_0x36);

            if(mote != null){
                while (mote.getStatusInformationReport() == null){
                    System.out.println("Waiting for status report");
                    try{
                        Thread.sleep(101);
                    }catch (InterruptedException e1){
                        e1.printStackTrace();
                    }
                }
                System.out.println(mote.getStatusInformationReport());

                while(mote.getCalibrationDataReport() == null){
                    System.out.println("Waiting fot calibration report");
                    try{
                        Thread.sleep(101);
                    }catch (InterruptedException e2){
                        e2.printStackTrace();
                    }
                }
                System.out.println(mote.getCalibrationDataReport());
                CalibrationDataReport cali = mote.getCalibrationDataReport();
//                (cali.getZeroX() + cali.getGravityX());
//                (cali.getZeroY() + cali.getGravityY());
//                (cali.getZeroZ() + cali.getGravityZ());
                mote.addAccelerometerListener(new AccelerometerListener<Mote>() {
                    @Override
                    public void accelerometerChanged(AccelerometerEvent<Mote> event) {
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
                                if(coreButtonEvent.isButtonAPressed() && coreButtonEvent.isButtonBPressed()){
                                    System.out.println("AB");
                                }
                                else if (coreButtonEvent.isButtonAPressed()){
                                    System.out.println("BUTTON_A");
                                }
                                else if (coreButtonEvent.isButtonBPressed()){

                                    System.out.println("BUTTON_B");
                                }
                                else if (coreButtonEvent.isButtonPlusPressed()){

                                    System.out.println("BUTTON_PLUS");
                                }
                                else if (coreButtonEvent.isButtonMinusPressed()){

                                    System.out.println("BUTTON_MINUS");
                                }
                                else if (coreButtonEvent.isButtonHomePressed()){

                                    System.out.println("BUTTON_HOME");
                                }
                                else if (coreButtonEvent.isDPadLeftPressed()){

                                    System.out.println("D_PAD_LEFT");
                                }
                                else if (coreButtonEvent.isDPadRightPressed()){

                                    System.out.println("D_PAD_RIGHT");
                                }
                                else if (coreButtonEvent.isDPadUpPressed()){

                                    System.out.println("D_PAD_UP");
                                }
                                else if (coreButtonEvent.isDPadDownPressed()){

                                    System.out.println("D_PAD_DOWN");
                                }
                                else if (coreButtonEvent.isButtonOnePressed()){

                                    System.out.println("BUTTON_ONE");
                                }
                                else if (coreButtonEvent.isButtonTwoPressed()){

                                    System.out.println("BUTTON_TWO");
                                }
                                else if (coreButtonEvent.isNoButtonPressed()){

                                    System.out.println("NONE");
                                }
                            }
                        });
                    }
                });
            }
        }
    };


}
