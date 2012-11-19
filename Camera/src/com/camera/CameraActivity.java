package com.camera;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class CameraActivity extends Activity {

	private Camera mCamera;
	private CameraView mPreview;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_camera_surface_view);
		

		// checkCameraHardware(null);

		// Create an instance of Camera
		mCamera = getCameraInstance();

		// Create our Preview view and set it as the content of our activity.
		mPreview = new CameraView(this, mCamera);
		RelativeLayout main = (RelativeLayout) findViewById(R.id.main_view);
		
		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		FrameLayout row1 = (FrameLayout) findViewById(R.id.row1);
		int mWidth = 720;
		int mHeight = 1280;
		preview.addView(mPreview);
		row1.addView(new ColorBars(this, mWidth, mHeight, 0xFFFF0000, 0xFFAA0000, 0xAAFF0000, 0xFFFF0000));
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		releaseCamera(); // release the camera immediately on pause event
	}

	/** Check if this device has a camera */
	@SuppressWarnings("unused")
	private boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA)) {
			// this device has a camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}

	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(); // attempt to get a Camera instance
		} catch (Exception e) {
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}

	private void releaseCamera() {
		if (mCamera != null) {
			mCamera.release(); // release the camera for other applications
			mCamera = null;
		}
	}

}