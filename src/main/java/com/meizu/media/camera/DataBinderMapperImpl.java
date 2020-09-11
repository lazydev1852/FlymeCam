package com.meizu.media.camera;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.meizu.media.camera.databinding.CameraBindingImpl;
import com.meizu.media.camera.databinding.CameraSimplifyBindingImpl;
import com.meizu.media.camera.databinding.CountDownToCaptureBindingImpl;
import com.meizu.media.camera.databinding.DelayInflateOneBindingImpl;
import com.meizu.media.camera.databinding.DelayInflateTwoBindingImpl;
import com.meizu.media.camera.databinding.FaceViewBindingImpl;
import com.meizu.media.camera.databinding.MzArBindingImpl;
import com.meizu.media.camera.databinding.MzArContainerBindingImpl;
import com.meizu.media.camera.databinding.MzBarcodeBindingImpl;
import com.meizu.media.camera.databinding.MzCamAsdLayoutBindingImpl;
import com.meizu.media.camera.databinding.MzCameraControlbarBindingImpl;
import com.meizu.media.camera.databinding.MzCameraSimplifySmartbarBindingImpl;
import com.meizu.media.camera.databinding.MzCameraSmartbarBindingImpl;
import com.meizu.media.camera.databinding.MzDocBindingImpl;
import com.meizu.media.camera.databinding.MzFilterControlBindingImpl;
import com.meizu.media.camera.databinding.MzFilterSwitchBindingImpl;
import com.meizu.media.camera.databinding.MzFunnySnapContainerBindingImpl;
import com.meizu.media.camera.databinding.MzFunnySnapNoFaceBindingImpl;
import com.meizu.media.camera.databinding.MzFunnysnapBindingImpl;
import com.meizu.media.camera.databinding.MzLutfilterControlBindingImpl;
import com.meizu.media.camera.databinding.MzMakeupControlBindingImpl;
import com.meizu.media.camera.databinding.MzManualControlBindingImpl;
import com.meizu.media.camera.databinding.MzModeGuideBindingImpl;
import com.meizu.media.camera.databinding.MzNightvisionBindingImpl;
import com.meizu.media.camera.databinding.MzRecordingLabelBindingImpl;
import com.meizu.media.camera.databinding.MzSettingControlBindingImpl;
import com.meizu.media.camera.databinding.MzSquareControlBindingImpl;
import com.meizu.media.camera.databinding.MzStereoCameraControlBindingImpl;
import com.meizu.media.camera.databinding.MzTopSettingControlBindingImpl;
import com.meizu.media.camera.databinding.MzVideoContainerBindingImpl;
import com.meizu.media.camera.databinding.MzVideoControlBindingImpl;
import com.meizu.media.camera.databinding.MzZoomControlBindingImpl;
import com.meizu.media.camera.databinding.MzZoomControlTwoBindingImpl;
import com.meizu.media.camera.databinding.StubCamPreviewLayoutBindingImpl;
import com.meizu.media.camera.databinding.StubCamPreviewV1LayoutBindingImpl;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a */
    public static ChangeQuickRedirect f6740a;

    /* renamed from: b */
    private static final SparseIntArray f6741b = new SparseIntArray(35);

    static {
        f6741b.put(R.layout.camera, 1);
        f6741b.put(R.layout.camera_simplify, 2);
        f6741b.put(R.layout.count_down_to_capture, 3);
        f6741b.put(R.layout.delay_inflate_one, 4);
        f6741b.put(R.layout.delay_inflate_two, 5);
        f6741b.put(R.layout.face_view, 6);
        f6741b.put(R.layout.mz_ar, 7);
        f6741b.put(R.layout.mz_ar_container, 8);
        f6741b.put(R.layout.mz_barcode, 9);
        f6741b.put(R.layout.mz_cam_asd_layout, 10);
        f6741b.put(R.layout.mz_camera_controlbar, 11);
        f6741b.put(R.layout.mz_camera_simplify_smartbar, 12);
        f6741b.put(R.layout.mz_camera_smartbar, 13);
        f6741b.put(R.layout.mz_doc, 14);
        f6741b.put(R.layout.mz_filter_control, 15);
        f6741b.put(R.layout.mz_filter_switch, 16);
        f6741b.put(R.layout.mz_funny_snap_container, 17);
        f6741b.put(R.layout.mz_funny_snap_no_face, 18);
        f6741b.put(R.layout.mz_funnysnap, 19);
        f6741b.put(R.layout.mz_lutfilter_control, 20);
        f6741b.put(R.layout.mz_makeup_control, 21);
        f6741b.put(R.layout.mz_manual_control, 22);
        f6741b.put(R.layout.mz_mode_guide, 23);
        f6741b.put(R.layout.mz_nightvision, 24);
        f6741b.put(R.layout.mz_recording_label, 25);
        f6741b.put(R.layout.mz_setting_control, 26);
        f6741b.put(R.layout.mz_square_control, 27);
        f6741b.put(R.layout.mz_stereo_camera_control, 28);
        f6741b.put(R.layout.mz_top_setting_control, 29);
        f6741b.put(R.layout.mz_video_container, 30);
        f6741b.put(R.layout.mz_video_control, 31);
        f6741b.put(R.layout.mz_zoom_control, 32);
        f6741b.put(R.layout.mz_zoom_control_two, 33);
        f6741b.put(R.layout.stub_cam_preview_layout, 34);
        f6741b.put(R.layout.stub_cam_preview_v1_layout, 35);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        Object[] objArr = {dataBindingComponent, view, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6740a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 981, new Class[]{DataBindingComponent.class, View.class, Integer.TYPE}, ViewDataBinding.class);
        if (proxy.isSupported) {
            return (ViewDataBinding) proxy.result;
        }
        int i2 = f6741b.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/camera_0".equals(tag)) {
                        return new CameraBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for camera is invalid. Received: " + tag);
                case 2:
                    if ("layout/camera_simplify_0".equals(tag)) {
                        return new CameraSimplifyBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for camera_simplify is invalid. Received: " + tag);
                case 3:
                    if ("layout/count_down_to_capture_0".equals(tag)) {
                        return new CountDownToCaptureBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for count_down_to_capture is invalid. Received: " + tag);
                case 4:
                    if ("layout/delay_inflate_one_0".equals(tag)) {
                        return new DelayInflateOneBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for delay_inflate_one is invalid. Received: " + tag);
                case 5:
                    if ("layout/delay_inflate_two_0".equals(tag)) {
                        return new DelayInflateTwoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for delay_inflate_two is invalid. Received: " + tag);
                case 6:
                    if ("layout/face_view_0".equals(tag)) {
                        return new FaceViewBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for face_view is invalid. Received: " + tag);
                case 7:
                    if ("layout/mz_ar_0".equals(tag)) {
                        return new MzArBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_ar is invalid. Received: " + tag);
                case 8:
                    if ("layout/mz_ar_container_0".equals(tag)) {
                        return new MzArContainerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_ar_container is invalid. Received: " + tag);
                case 9:
                    if ("layout/mz_barcode_0".equals(tag)) {
                        return new MzBarcodeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_barcode is invalid. Received: " + tag);
                case 10:
                    if ("layout/mz_cam_asd_layout_0".equals(tag)) {
                        return new MzCamAsdLayoutBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_cam_asd_layout is invalid. Received: " + tag);
                case 11:
                    if ("layout/mz_camera_controlbar_0".equals(tag)) {
                        return new MzCameraControlbarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_camera_controlbar is invalid. Received: " + tag);
                case 12:
                    if ("layout/mz_camera_simplify_smartbar_0".equals(tag)) {
                        return new MzCameraSimplifySmartbarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_camera_simplify_smartbar is invalid. Received: " + tag);
                case 13:
                    if ("layout/mz_camera_smartbar_0".equals(tag)) {
                        return new MzCameraSmartbarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_camera_smartbar is invalid. Received: " + tag);
                case 14:
                    if ("layout/mz_doc_0".equals(tag)) {
                        return new MzDocBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_doc is invalid. Received: " + tag);
                case 15:
                    if ("layout/mz_filter_control_0".equals(tag)) {
                        return new MzFilterControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_filter_control is invalid. Received: " + tag);
                case 16:
                    if ("layout/mz_filter_switch_0".equals(tag)) {
                        return new MzFilterSwitchBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_filter_switch is invalid. Received: " + tag);
                case 17:
                    if ("layout/mz_funny_snap_container_0".equals(tag)) {
                        return new MzFunnySnapContainerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_funny_snap_container is invalid. Received: " + tag);
                case 18:
                    if ("layout/mz_funny_snap_no_face_0".equals(tag)) {
                        return new MzFunnySnapNoFaceBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_funny_snap_no_face is invalid. Received: " + tag);
                case 19:
                    if ("layout/mz_funnysnap_0".equals(tag)) {
                        return new MzFunnysnapBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_funnysnap is invalid. Received: " + tag);
                case 20:
                    if ("layout/mz_lutfilter_control_0".equals(tag)) {
                        return new MzLutfilterControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_lutfilter_control is invalid. Received: " + tag);
                case 21:
                    if ("layout/mz_makeup_control_0".equals(tag)) {
                        return new MzMakeupControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_makeup_control is invalid. Received: " + tag);
                case 22:
                    if ("layout/mz_manual_control_0".equals(tag)) {
                        return new MzManualControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_manual_control is invalid. Received: " + tag);
                case 23:
                    if ("layout/mz_mode_guide_0".equals(tag)) {
                        return new MzModeGuideBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_mode_guide is invalid. Received: " + tag);
                case 24:
                    if ("layout/mz_nightvision_0".equals(tag)) {
                        return new MzNightvisionBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_nightvision is invalid. Received: " + tag);
                case 25:
                    if ("layout/mz_recording_label_0".equals(tag)) {
                        return new MzRecordingLabelBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_recording_label is invalid. Received: " + tag);
                case 26:
                    if ("layout/mz_setting_control_0".equals(tag)) {
                        return new MzSettingControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_setting_control is invalid. Received: " + tag);
                case 27:
                    if ("layout/mz_square_control_0".equals(tag)) {
                        return new MzSquareControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_square_control is invalid. Received: " + tag);
                case 28:
                    if ("layout/mz_stereo_camera_control_0".equals(tag)) {
                        return new MzStereoCameraControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_stereo_camera_control is invalid. Received: " + tag);
                case 29:
                    if ("layout/mz_top_setting_control_0".equals(tag)) {
                        return new MzTopSettingControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_top_setting_control is invalid. Received: " + tag);
                case 30:
                    if ("layout/mz_video_container_0".equals(tag)) {
                        return new MzVideoContainerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_video_container is invalid. Received: " + tag);
                case 31:
                    if ("layout/mz_video_control_0".equals(tag)) {
                        return new MzVideoControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_video_control is invalid. Received: " + tag);
                case 32:
                    if ("layout/mz_zoom_control_0".equals(tag)) {
                        return new MzZoomControlBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_zoom_control is invalid. Received: " + tag);
                case 33:
                    if ("layout/mz_zoom_control_two_0".equals(tag)) {
                        return new MzZoomControlTwoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for mz_zoom_control_two is invalid. Received: " + tag);
                case 34:
                    if ("layout/stub_cam_preview_layout_0".equals(tag)) {
                        return new StubCamPreviewLayoutBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for stub_cam_preview_layout is invalid. Received: " + tag);
                case 35:
                    if ("layout/stub_cam_preview_v1_layout_0".equals(tag)) {
                        return new StubCamPreviewV1LayoutBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for stub_cam_preview_v1_layout is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        Object[] objArr = {dataBindingComponent, viewArr, new Integer(i)};
        ChangeQuickRedirect changeQuickRedirect = f6740a;
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        PatchProxyResult proxy = PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 982, new Class[]{DataBindingComponent.class, View[].class, Integer.TYPE}, ViewDataBinding.class);
        if (proxy.isSupported) {
            return (ViewDataBinding) proxy.result;
        }
        if (viewArr == null || viewArr.length == 0 || f6741b.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, this, f6740a, false, 983, new Class[]{String.class}, Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        if (str == null || (num = C1629b.f6743a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, f6740a, false, 984, new Class[]{Integer.TYPE}, String.class);
        return proxy.isSupported ? (String) proxy.result : C1628a.f6742a.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f6740a, false, 985, new Class[0], List.class);
        if (proxy.isSupported) {
            return (List) proxy.result;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    /* renamed from: com.meizu.media.camera.DataBinderMapperImpl$a */
    private static class C1628a {

        /* renamed from: a */
        static final SparseArray<String> f6742a = new SparseArray<>(2);

        static {
            f6742a.put(0, "_all");
        }
    }

    /* renamed from: com.meizu.media.camera.DataBinderMapperImpl$b */
    private static class C1629b {

        /* renamed from: a */
        static final HashMap<String, Integer> f6743a = new HashMap<>(35);

        static {
            f6743a.put("layout/camera_0", Integer.valueOf(R.layout.camera));
            f6743a.put("layout/camera_simplify_0", Integer.valueOf(R.layout.camera_simplify));
            f6743a.put("layout/count_down_to_capture_0", Integer.valueOf(R.layout.count_down_to_capture));
            f6743a.put("layout/delay_inflate_one_0", Integer.valueOf(R.layout.delay_inflate_one));
            f6743a.put("layout/delay_inflate_two_0", Integer.valueOf(R.layout.delay_inflate_two));
            f6743a.put("layout/face_view_0", Integer.valueOf(R.layout.face_view));
            f6743a.put("layout/mz_ar_0", Integer.valueOf(R.layout.mz_ar));
            f6743a.put("layout/mz_ar_container_0", Integer.valueOf(R.layout.mz_ar_container));
            f6743a.put("layout/mz_barcode_0", Integer.valueOf(R.layout.mz_barcode));
            f6743a.put("layout/mz_cam_asd_layout_0", Integer.valueOf(R.layout.mz_cam_asd_layout));
            f6743a.put("layout/mz_camera_controlbar_0", Integer.valueOf(R.layout.mz_camera_controlbar));
            f6743a.put("layout/mz_camera_simplify_smartbar_0", Integer.valueOf(R.layout.mz_camera_simplify_smartbar));
            f6743a.put("layout/mz_camera_smartbar_0", Integer.valueOf(R.layout.mz_camera_smartbar));
            f6743a.put("layout/mz_doc_0", Integer.valueOf(R.layout.mz_doc));
            f6743a.put("layout/mz_filter_control_0", Integer.valueOf(R.layout.mz_filter_control));
            f6743a.put("layout/mz_filter_switch_0", Integer.valueOf(R.layout.mz_filter_switch));
            f6743a.put("layout/mz_funny_snap_container_0", Integer.valueOf(R.layout.mz_funny_snap_container));
            f6743a.put("layout/mz_funny_snap_no_face_0", Integer.valueOf(R.layout.mz_funny_snap_no_face));
            f6743a.put("layout/mz_funnysnap_0", Integer.valueOf(R.layout.mz_funnysnap));
            f6743a.put("layout/mz_lutfilter_control_0", Integer.valueOf(R.layout.mz_lutfilter_control));
            f6743a.put("layout/mz_makeup_control_0", Integer.valueOf(R.layout.mz_makeup_control));
            f6743a.put("layout/mz_manual_control_0", Integer.valueOf(R.layout.mz_manual_control));
            f6743a.put("layout/mz_mode_guide_0", Integer.valueOf(R.layout.mz_mode_guide));
            f6743a.put("layout/mz_nightvision_0", Integer.valueOf(R.layout.mz_nightvision));
            f6743a.put("layout/mz_recording_label_0", Integer.valueOf(R.layout.mz_recording_label));
            f6743a.put("layout/mz_setting_control_0", Integer.valueOf(R.layout.mz_setting_control));
            f6743a.put("layout/mz_square_control_0", Integer.valueOf(R.layout.mz_square_control));
            f6743a.put("layout/mz_stereo_camera_control_0", Integer.valueOf(R.layout.mz_stereo_camera_control));
            f6743a.put("layout/mz_top_setting_control_0", Integer.valueOf(R.layout.mz_top_setting_control));
            f6743a.put("layout/mz_video_container_0", Integer.valueOf(R.layout.mz_video_container));
            f6743a.put("layout/mz_video_control_0", Integer.valueOf(R.layout.mz_video_control));
            f6743a.put("layout/mz_zoom_control_0", Integer.valueOf(R.layout.mz_zoom_control));
            f6743a.put("layout/mz_zoom_control_two_0", Integer.valueOf(R.layout.mz_zoom_control_two));
            f6743a.put("layout/stub_cam_preview_layout_0", Integer.valueOf(R.layout.stub_cam_preview_layout));
            f6743a.put("layout/stub_cam_preview_v1_layout_0", Integer.valueOf(R.layout.stub_cam_preview_v1_layout));
        }
    }
}
