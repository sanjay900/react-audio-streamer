
package com.reactlibrary;

import android.media.audiofx.Visualizer;
import android.util.Base64;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Arrays;

public class RNMemesModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Visualizer v;

  public RNMemesModule(final ReactApplicationContext reactContext) {
    super(reactContext);

    this.reactContext = reactContext;
      }
  @ReactMethod
  public void beginRecording() {
      this.v = new Visualizer(0);
      this.v.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
      this.v.setDataCaptureListener(new Visualizer.OnDataCaptureListener() {
          @Override
          public void onWaveFormDataCapture(Visualizer visualizer, byte[] waveform, int samplingRate) {
              String data = Base64.encodeToString(waveform,0);
              reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                      .emit("audio", data);
          }

          @Override
          public void onFftDataCapture(Visualizer visualizer, byte[] fft, int samplingRate) {

          }
      },16000, true, false);
  }
  @Override
  public String getName() {
    return "RNMemes";
  }
}