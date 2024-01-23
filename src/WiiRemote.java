import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.Mote;
import motej.request.ReportModeRequest;

public class WiiRemote {
    private final Mote mote;
    private final AccelerometerListener accelerometerListener;
    private final CoreButtonListener coreButtonListener;
    private final int[] motion= {0,0,0};
    String button = "none";
    public WiiRemote(Mote mote){
        this.mote = mote;
        accelerometerListener = new AccelerometerListener() {

            @Override
            public void accelerometerChanged(AccelerometerEvent event) {
                motion[0] = event.getX();
                motion[1] = event.getY();
                motion[2] = event.getZ();
            }
        };
        coreButtonListener = new CoreButtonListener() {
            @Override
            public void buttonPressed(CoreButtonEvent coreButtonEvent) {

                if (coreButtonEvent.isButtonAPressed() && coreButtonEvent.isButtonBPressed()) {
                            System.out.println("AB");
                            button = "AB";

                    } else if (coreButtonEvent.isButtonAPressed()) {
                        System.out.println("BUTTON_A");
                        button = "A";

                    } else if (coreButtonEvent.isButtonBPressed()) {
                        System.out.println("BUTTON_B");
                        button = "B";

                    } else if (coreButtonEvent.isButtonPlusPressed()) {
                        System.out.println("BUTTON_PLUS");
                        button = "PLUS";

                    } else if (coreButtonEvent.isButtonMinusPressed()) {
                        System.out.println("BUTTON_MINUS");
                        button = "MINUS";

                    } else if (coreButtonEvent.isButtonHomePressed()) {
                        System.out.println("BUTTON_HOME");
                        button = "HOME";

                    } else if (coreButtonEvent.isDPadLeftPressed()) {
                        System.out.println("D_PAD_LEFT");
                        button = "LEFT";

                    } else if (coreButtonEvent.isDPadRightPressed()) {
                        System.out.println("D_PAD_RIGHT");
                        button = "RIGHT";

                    } else if (coreButtonEvent.isDPadUpPressed()) {
                        System.out.println("D_PAD_UP");
                        button = "UP";

                    } else if (coreButtonEvent.isDPadDownPressed()) {
                        System.out.println("D_PAD_DOWN");
                        button = "DOWN";

                    } else if (coreButtonEvent.isButtonOnePressed()) {
                        System.out.println("BUTTON_ONE");
                        button = "ONE";

                    } else if (coreButtonEvent.isButtonTwoPressed()) {
                        System.out.println("BUTTON_TWO");
                        button = "TWO";

                    } else if (coreButtonEvent.isNoButtonPressed()) {
                        System.out.println("NONE");
                        button = "NONE";
                    }

            }
        };
        mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
        mote.addCoreButtonListener(coreButtonListener);
        mote.addAccelerometerListener(accelerometerListener);
    }

    public String getButton(){
    return button;
    }
}
