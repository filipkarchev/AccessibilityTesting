package eu.fbk.gauss.accesibilitytesting;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import java.util.List;

public class MyAccessibilityService extends AccessibilityService {
    private final String LOG_CAT = "MyAccessibilityService";


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i(LOG_CAT, "ACC::onAccessibilityEvent: " + event.getEventType());

        final int eventType = event.getEventType();
//        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
//        if (rootInActiveWindow != null) {
//            Log.i(LOG_CAT, "ACC::rootInActiveWindow: " + event.getEventType());
//
//
//        }

        //getRootInActiveWindow();
        String eventText = null;
        AccessibilityNodeInfo nodeInfo;
        switch(eventType) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                nodeInfo = event.getSource();
                Log.i(LOG_CAT, "ACC::Content Changed: " + nodeInfo);
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                nodeInfo = event.getSource();
                Log.i(LOG_CAT, "ACC::onAccessibilityEvent: nodeInfo=" + nodeInfo);
                if (nodeInfo == null) {
                    return;
                }

                runTest1(nodeInfo);

                runTest2(nodeInfo);

                clearTests(nodeInfo);
                break;
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
                nodeInfo = event.getSource();
                Log.i(LOG_CAT, "ACC::onAccessibilityEvent: nodeInfo");
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
                break;
        }

    }

    private void clearTests(AccessibilityNodeInfo nodeInfo) {
        List<AccessibilityNodeInfo> listButtonClear = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonClear");
        for (AccessibilityNodeInfo node : listButtonClear) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

    }


    private void runTest1(AccessibilityNodeInfo nodeInfo) {
        //Press button 2
        List<AccessibilityNodeInfo> listButton2 = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonTwo");
        for (AccessibilityNodeInfo node : listButton2) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }


        //Press button +
        List<AccessibilityNodeInfo> listButtonPlus = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonAdd");
        for (AccessibilityNodeInfo node : listButtonPlus) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

        //Press button 5
        List<AccessibilityNodeInfo> listButton5 = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonFive");
        for (AccessibilityNodeInfo node : listButton5) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

        //Press button =
        List<AccessibilityNodeInfo> listButtonEquals = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonEqual");
        for (AccessibilityNodeInfo node : listButtonEquals) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }


        //Press button =
        List<AccessibilityNodeInfo> listTextViewResult = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/infoTextView");
        if(listTextViewResult.size()>0)
        {
            AccessibilityNodeInfo node = listTextViewResult.get(0);
            Log.i(LOG_CAT,"ACC::Text is: " + node.getText());

            if("2+5 = 7".equals(node.getText()))
            {
                Toast.makeText(this, "AccessibilityService Test1: SUCCESS!!!", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "AccessibilityService Test1: FAIL!!!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void runTest2(AccessibilityNodeInfo nodeInfo) {
        //Press button 3
        List<AccessibilityNodeInfo> listButton3 = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonThree");
        for (AccessibilityNodeInfo node : listButton3) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }


        //Press button *
        List<AccessibilityNodeInfo> listButtonMultiply = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonMultiply");
        for (AccessibilityNodeInfo node : listButtonMultiply) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

        //Press 44
        List<AccessibilityNodeInfo> listButton4 = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonFour");
        for (AccessibilityNodeInfo node : listButton4) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);

            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

        //Press button =
        List<AccessibilityNodeInfo> listButtonEquals = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/buttonEqual");
        for (AccessibilityNodeInfo node : listButtonEquals) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }

        //Press button =
        List<AccessibilityNodeInfo> listTextViewResult = nodeInfo
                .findAccessibilityNodeInfosByViewId("eu.fbk.calc:id/infoTextView");
        if(listTextViewResult.size()>0)
        {
            AccessibilityNodeInfo node = listTextViewResult.get(0);
            Log.i(LOG_CAT,"ACC::Text is: " + node.getText());

            if("3*44 = 132".equals(node.getText()))
            {
                Toast.makeText(this, "AccessibilityService Test2: SUCCESS!!!", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "AccessibilityService Test2: FAIL!!!", Toast.LENGTH_SHORT).show();
            }
        }


    }




    @Override
    public void onInterrupt() {
    }

}
