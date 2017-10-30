package org.opencv.face;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;

/**
 * Created by ddx on 2017/8/12.
 */

public class DetectionBasedTracker {
    public DetectionBasedTracker(String cascadeName, int minFaceSize) {
        mNativeObj = nativeCreateObject(cascadeName, minFaceSize);
    }

    public void start() {
        nativeStart(mNativeObj);
    }

    public void stop() {
        nativeStop(mNativeObj);
    }

    public void setMinFaceSize(int width,int height) {
        nativeSetFaceSize(mNativeObj, width,height);
    }

    public void detect(Mat imageGray, MatOfRect faces) {
        nativeDetect(mNativeObj, imageGray.getNativeObjAddr(), faces.getNativeObjAddr());
    }

    public void release() {
        nativeDestroyObject(mNativeObj);
        mNativeObj = 0;
    }

    private long mNativeObj = 0;

    private static native long nativeCreateObject(String cascadeName, int minFaceSize);

    private static native void nativeDestroyObject(long thiz);

    private static native void nativeStart(long thiz);

    private static native void nativeStop(long thiz);

    private static native void nativeSetFaceSize(long thiz, int width,int height);

    private static native void nativeDetect(long thiz, long inputImage, long faces);

}
