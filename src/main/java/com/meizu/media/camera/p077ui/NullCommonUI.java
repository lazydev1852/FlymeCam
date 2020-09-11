package com.meizu.media.camera.p077ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.animation.PathInterpolator;
import androidx.core.app.NotificationCompat;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.media.camera.CameraActivity;
import com.meizu.media.camera.ComboPreferences;
import com.meizu.media.camera.MzCamController;
import com.meizu.media.camera.MzUIController;
import com.meizu.media.camera.PreviewGestures;
import com.meizu.media.camera.camcontroller.CameraController;
import com.meizu.media.camera.databinding.CameraBinding;
import com.meizu.media.camera.databinding.DelayInflateOneBinding;
import com.meizu.media.camera.databinding.DelayInflateTwoBinding;
import com.meizu.media.camera.databinding.MzCameraControlbarBinding;
import com.meizu.media.camera.p077ui.MzCommonUI;
import com.meizu.media.camera.p077ui.SettingController;
import com.meizu.media.camera.util.Contants;
import com.meizu.media.camera.views.MzSlideModeRenderer;
import com.meizu.media.camera.views.RenderOverlay;
import com.meizu.media.gallery.IThumbnailCallback;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import flyme.support.p093v7.widget.MzRecyclerView;
import flyme.support.p093v7.widget.RecyclerView;
import java.lang.ref.WeakReference;
import kotlin.C3403f;
import kotlin.C3410g;
import kotlin.Metadata;
import kotlin.jvm.p107a.Functions;
import kotlin.jvm.p108b.C3443i;
import kotlin.jvm.p108b.C3447o;
import kotlin.jvm.p108b.Lambda;
import kotlin.jvm.p108b.PropertyReference1;
import kotlin.jvm.p108b.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b&\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0002ü\u0002B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010O\u001a\u00020PH\u0016J\u0012\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020%H\u0016J\b\u0010V\u001a\u00020PH\u0016J\u0010\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u00020+H\u0016J\u0010\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020%H\u0016J \u0010[\u001a\u00020P2\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%H\u0016J\b\u0010_\u001a\u00020PH\u0016J\b\u0010`\u001a\u00020PH\u0016J\u0010\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020%H\u0016J\b\u0010c\u001a\u00020%H\u0016J\b\u0010d\u001a\u00020%H\u0016J\b\u0010e\u001a\u00020%H\u0016JV\u0010f\u001a\u00020P2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010m\u001a\u00020+2\u0006\u0010n\u001a\u00020+2\u0006\u0010o\u001a\u00020%2\u0006\u0010p\u001a\u00020+2\u0006\u0010q\u001a\u00020+2\u0006\u0010r\u001a\u00020%H\u0016J*\u0010s\u001a\u00020P2\b\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010n\u001a\u00020+2\u0006\u0010o\u001a\u00020%2\u0006\u0010r\u001a\u00020%H\u0016J\b\u0010t\u001a\u00020PH\u0016J\u0010\u0010u\u001a\u00020P2\u0006\u0010v\u001a\u00020%H\u0016J\u0010\u0010w\u001a\u00020P2\u0006\u0010Z\u001a\u00020%H\u0016J\u0010\u0010x\u001a\u00020P2\u0006\u0010Z\u001a\u00020%H\u0016J\n\u0010y\u001a\u0004\u0018\u00010zH\u0016J\b\u0010{\u001a\u00020+H\u0016J\n\u0010|\u001a\u0004\u0018\u00010}H\u0016J\n\u0010~\u001a\u0004\u0018\u00010H\u0016J\t\u0010\u0001\u001a\u00020%H\u0016J$\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020%H\u0016J\f\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020PH\u0016J\u0011\u0010\u0001\u001a\u00020P2\u0006\u0010Z\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020zH\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J$\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0012\u0010\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0012\u0010 \u0001\u001a\u00020P2\u0007\u0010¡\u0001\u001a\u00020+H\u0016J\u0012\u0010¢\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0015\u0010£\u0001\u001a\u00020P2\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H&J\u001b\u0010¦\u0001\u001a\u00020P2\u0007\u0010§\u0001\u001a\u00020%2\u0007\u0010¨\u0001\u001a\u00020%H\u0016J\u0012\u0010©\u0001\u001a\u00020P2\u0007\u0010ª\u0001\u001a\u00020%H\u0016J\u0012\u0010«\u0001\u001a\u00020P2\u0007\u0010¬\u0001\u001a\u00020%H\u0016J\u0011\u0010­\u0001\u001a\u00020P2\u0006\u0010Z\u001a\u00020%H\u0016J\u001b\u0010®\u0001\u001a\u00020P2\u0007\u0010¯\u0001\u001a\u00020%2\u0007\u0010°\u0001\u001a\u00020%H\u0016J\u0012\u0010±\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+H\u0016J\t\u0010²\u0001\u001a\u00020PH\u0016J\t\u0010³\u0001\u001a\u00020PH\u0016J\u0012\u0010´\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u0012\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+H\u0016J\u001a\u0010µ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0006\u0010Z\u001a\u00020%H\u0016J\t\u0010·\u0001\u001a\u00020PH\u0016J\u001b\u0010¸\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0007\u0010¹\u0001\u001a\u00020%H\u0016J\u0012\u0010º\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+H\u0016J\u001a\u0010º\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0006\u0010Z\u001a\u00020%H\u0016J\u0012\u0010»\u0001\u001a\u00020P2\u0007\u0010¼\u0001\u001a\u00020%H\u0016J\u001b\u0010½\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010¾\u0001\u001a\u00020+H\u0016J\t\u0010¿\u0001\u001a\u00020PH\u0016J\u001b\u0010À\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0007\u0010Á\u0001\u001a\u00020%H\u0016J\u001b\u0010Â\u0001\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020+H\u0016J\u001b\u0010Ã\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0007\u0010Ä\u0001\u001a\u00020+H\u0016J\u001a\u0010Å\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0006\u0010Z\u001a\u00020%H\u0016J\u001b\u0010Æ\u0001\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0007\u0010Á\u0001\u001a\u00020%H\u0016J\t\u0010Ç\u0001\u001a\u00020PH\u0016J#\u0010È\u0001\u001a\u00020P2\u0007\u0010É\u0001\u001a\u00020+2\u0007\u0010Ê\u0001\u001a\u00020%2\u0006\u0010]\u001a\u00020%H\u0016J\u001b\u0010Ë\u0001\u001a\u00020P2\u0007\u0010É\u0001\u001a\u00020+2\u0007\u0010Ì\u0001\u001a\u00020%H\u0016J\u0012\u0010Í\u0001\u001a\u00020P2\u0007\u0010Î\u0001\u001a\u00020+H\u0016J\t\u0010Ï\u0001\u001a\u00020PH\u0016J\t\u0010Ð\u0001\u001a\u00020PH\u0016J\t\u0010Ñ\u0001\u001a\u00020PH\u0016J\t\u0010Ò\u0001\u001a\u00020PH\u0016J\u001f\u0010Ó\u0001\u001a\u00020P2\b\u0010Ô\u0001\u001a\u00030Õ\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001H\u0016J\t\u0010Ø\u0001\u001a\u00020PH\u0016J\t\u0010Ù\u0001\u001a\u00020PH\u0016J\t\u0010Ú\u0001\u001a\u00020%H\u0016J\t\u0010Û\u0001\u001a\u00020%H\u0016J\u0016\u0010U\u001a\u00020%2\f\u0010Ü\u0001\u001a\u00030Ý\u0001\"\u00020%H\u0016J\t\u0010Þ\u0001\u001a\u00020%H\u0016J\t\u0010ß\u0001\u001a\u00020%H\u0016J\t\u0010à\u0001\u001a\u00020%H\u0016J\t\u0010á\u0001\u001a\u00020%H\u0016J\t\u0010â\u0001\u001a\u00020%H\u0016J\t\u0010ã\u0001\u001a\u00020%H\u0016J\t\u0010ä\u0001\u001a\u00020%H\u0016J\t\u0010å\u0001\u001a\u00020%H\u0016J\t\u0010æ\u0001\u001a\u00020%H\u0016J\t\u0010Ü\u0001\u001a\u00020%H\u0016J\t\u0010ç\u0001\u001a\u00020%H\u0016J\t\u0010è\u0001\u001a\u00020%H\u0016J\t\u0010é\u0001\u001a\u00020%H\u0016J\t\u0010ê\u0001\u001a\u00020%H$J\t\u0010ë\u0001\u001a\u00020%H\u0016J\t\u0010ì\u0001\u001a\u00020%H\u0016J\t\u0010í\u0001\u001a\u00020%H\u0016J\t\u0010î\u0001\u001a\u00020%H\u0016J\t\u0010ï\u0001\u001a\u00020%H\u0016J\t\u0010ð\u0001\u001a\u00020%H\u0016J\u001b\u0010ñ\u0001\u001a\u00020P2\u0007\u0010ò\u0001\u001a\u00020+2\u0007\u0010ó\u0001\u001a\u00020%H\u0016J\t\u0010ô\u0001\u001a\u00020%H\u0016J\t\u0010õ\u0001\u001a\u00020%H\u0016J\u0012\u0010ö\u0001\u001a\u00020P2\u0007\u0010÷\u0001\u001a\u00020%H\u0016J\t\u0010ø\u0001\u001a\u00020PH\u0016J\u0012\u0010ù\u0001\u001a\u00020P2\u0007\u0010É\u0001\u001a\u00020+H\u0016J\t\u0010ú\u0001\u001a\u00020PH\u0016J\t\u0010û\u0001\u001a\u00020PH\u0016J\u001b\u0010ü\u0001\u001a\u00020P2\u0007\u0010ý\u0001\u001a\u00020+2\u0007\u0010þ\u0001\u001a\u00020+H\u0016J\t\u0010ÿ\u0001\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\u0013\u0010\u0002\u001a\u00020P2\b\u0010\u0002\u001a\u00030\u0002H\u0016J\u001c\u0010\u0002\u001a\u00020P2\b\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020%H\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\u0015\u0010\u0002\u001a\u00020P2\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\u001b\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020+2\u0007\u0010\u0002\u001a\u00020+H\u0016J\u001b\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020+2\u0007\u0010\u0002\u001a\u00020+H\u0016J\u001b\u0010\u0002\u001a\u00020%2\u0007\u0010\u0002\u001a\u00020+2\u0007\u0010\u0002\u001a\u00020+H\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\"\u0010\u0002\u001a\u00020P2\u0007\u0010\u0002\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%H\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\u0012\u0010\u0002\u001a\u00020P2\u0007\u0010\u0002\u001a\u00020+H\u0016J\t\u0010\u0002\u001a\u00020PH\u0016J\t\u0010 \u0002\u001a\u00020PH\u0016J\t\u0010¡\u0002\u001a\u00020PH\u0016J\t\u0010¢\u0002\u001a\u00020PH\u0016J\t\u0010£\u0002\u001a\u00020PH\u0016J\t\u0010¤\u0002\u001a\u00020PH\u0016J\t\u0010¥\u0002\u001a\u00020PH\u0016J\t\u0010¦\u0002\u001a\u00020PH\u0016J\u0012\u0010§\u0002\u001a\u00020P2\u0007\u0010¨\u0002\u001a\u00020+H\u0016J\u0012\u0010©\u0002\u001a\u00020P2\u0007\u0010¨\u0002\u001a\u00020+H\u0016J\u0014\u0010ª\u0002\u001a\u00020P2\t\u0010«\u0002\u001a\u0004\u0018\u00010hH\u0016J\u0012\u0010¬\u0002\u001a\u00020P2\u0007\u0010É\u0001\u001a\u00020+H\u0016J\u0012\u0010­\u0002\u001a\u00020P2\u0007\u0010®\u0002\u001a\u00020+H\u0016J\u0013\u0010¯\u0002\u001a\u00020P2\b\u0010°\u0002\u001a\u00030\u0002H\u0016J\u0019\u0010±\u0002\u001a\u00020P2\u000e\u0010²\u0002\u001a\t\u0012\u0002\b\u0003\u0018\u00010³\u0002H\u0016J\u0012\u0010´\u0002\u001a\u00020P2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010µ\u0002\u001a\u00020P2\u0007\u0010¶\u0002\u001a\u00020%H\u0016J\u001b\u0010·\u0002\u001a\u00020P2\u0007\u0010¸\u0002\u001a\u00020%2\u0007\u0010¹\u0002\u001a\u00020%H\u0016J*\u0010º\u0002\u001a\u00020P2\u0013\u0010»\u0002\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010½\u0002\u0018\u00010¼\u00022\n\u0010¾\u0002\u001a\u0005\u0018\u00010½\u0002H\u0016J\u0012\u0010¿\u0002\u001a\u00020P2\u0007\u0010À\u0002\u001a\u00020%H\u0016J\u0012\u0010Á\u0002\u001a\u00020P2\u0007\u0010À\u0002\u001a\u00020%H\u0016J\u0015\u0010Â\u0002\u001a\u00020P2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ä\u0002H\u0016J\u0015\u0010Å\u0002\u001a\u00020P2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Æ\u0002H\u0016J\u0012\u0010Ç\u0002\u001a\u00020P2\u0007\u0010È\u0002\u001a\u00020+H\u0016J\u0012\u0010É\u0002\u001a\u00020P2\u0007\u0010Ê\u0002\u001a\u00020%H\u0016J#\u0010Ë\u0002\u001a\u00020P2\u0006\u0010p\u001a\u00020+2\u0006\u0010q\u001a\u00020+2\b\u0010Ì\u0002\u001a\u00030Í\u0002H\u0016J\u0014\u0010Î\u0002\u001a\u00020P2\t\u0010«\u0002\u001a\u0004\u0018\u00010hH\u0016J\u001b\u0010Ï\u0002\u001a\u00020P2\u0007\u0010¶\u0001\u001a\u00020+2\u0007\u0010Ð\u0002\u001a\u00020%H\u0016J\u0015\u0010Ñ\u0002\u001a\u00020P2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ò\u0002H\u0016J \u0010Ñ\u0002\u001a\u00020P2\t\u0010Ó\u0002\u001a\u0004\u0018\u00010l2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ô\u0002H\u0016J\u0013\u0010Õ\u0002\u001a\u00020P2\b\u0010Ö\u0002\u001a\u00030×\u0002H\u0016J\u0015\u0010Ø\u0002\u001a\u00020P2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ù\u0002H\u0016J\u0012\u0010Ú\u0002\u001a\u00020P2\u0007\u0010Û\u0002\u001a\u00020%H\u0016J\u0015\u0010Ü\u0002\u001a\u00020P2\n\u0010Ý\u0002\u001a\u0005\u0018\u00010Þ\u0002H\u0016J\t\u0010ß\u0002\u001a\u00020PH\u0016J\t\u0010à\u0002\u001a\u00020PH\u0016J\u0011\u0010á\u0002\u001a\u00020P2\u0006\u0010R\u001a\u00020%H\u0016J\u0012\u0010â\u0002\u001a\u00020P2\u0007\u0010ò\u0001\u001a\u00020+H\u0016J\u001b\u0010â\u0002\u001a\u00020P2\u0007\u0010ò\u0001\u001a\u00020+2\u0007\u0010ã\u0002\u001a\u00020%H\u0016J\u0012\u0010ä\u0002\u001a\u00020P2\u0007\u0010\u0002\u001a\u00020+H\u0016J\t\u0010å\u0002\u001a\u00020PH\u0016J\t\u0010æ\u0002\u001a\u00020PH\u0016J\u0014\u0010ç\u0002\u001a\u00020P2\t\u0010è\u0002\u001a\u0004\u0018\u00010lH\u0016J\u0015\u0010é\u0002\u001a\u00020P2\n\u0010ê\u0002\u001a\u0005\u0018\u00010ë\u0002H\u0016J\u0015\u0010ì\u0002\u001a\u00020P2\n\u0010í\u0002\u001a\u0005\u0018\u00010î\u0002H\u0016J,\u0010ï\u0002\u001a\u00020P2\t\u0010Ý\u0002\u001a\u0004\u0018\u00010l2\u0007\u0010ð\u0002\u001a\u00020%2\r\u0010ñ\u0002\u001a\u00030ò\u0002\"\u00030\u0002H\u0016J\u0012\u0010ó\u0002\u001a\u00020P2\u0007\u0010ô\u0002\u001a\u00020%H\u0016J/\u0010õ\u0002\u001a\u00020P2\u0007\u0010ö\u0002\u001a\u00020%2\u0007\u0010÷\u0002\u001a\u00020+2\b\u0010ø\u0002\u001a\u00030ù\u00022\b\u0010ú\u0002\u001a\u00030û\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001b\u00103\u001a\u0002048DX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u000e\u0010<\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R\u001a\u0010I\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010/R\u001a\u0010L\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010-\"\u0004\bN\u0010/¨\u0006ý\u0002"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/NullCommonUI;", "Lcom/meizu/media/camera/MzUIController;", "activity", "Lcom/meizu/media/camera/CameraActivity;", "controller", "Lcom/meizu/media/camera/MzCamController;", "cameraBinding", "Lcom/meizu/media/camera/databinding/CameraBinding;", "(Lcom/meizu/media/camera/CameraActivity;Lcom/meizu/media/camera/MzCamController;Lcom/meizu/media/camera/databinding/CameraBinding;)V", "mActivity", "getMActivity", "()Lcom/meizu/media/camera/CameraActivity;", "setMActivity", "(Lcom/meizu/media/camera/CameraActivity;)V", "mCameraBinding", "getMCameraBinding", "()Lcom/meizu/media/camera/databinding/CameraBinding;", "setMCameraBinding", "(Lcom/meizu/media/camera/databinding/CameraBinding;)V", "mController", "getMController", "()Lcom/meizu/media/camera/MzCamController;", "setMController", "(Lcom/meizu/media/camera/MzCamController;)V", "mDelayInflateOneBinding", "Lcom/meizu/media/camera/databinding/DelayInflateOneBinding;", "getMDelayInflateOneBinding", "()Lcom/meizu/media/camera/databinding/DelayInflateOneBinding;", "setMDelayInflateOneBinding", "(Lcom/meizu/media/camera/databinding/DelayInflateOneBinding;)V", "mDelayInflateTwoBinding", "Lcom/meizu/media/camera/databinding/DelayInflateTwoBinding;", "getMDelayInflateTwoBinding", "()Lcom/meizu/media/camera/databinding/DelayInflateTwoBinding;", "setMDelayInflateTwoBinding", "(Lcom/meizu/media/camera/databinding/DelayInflateTwoBinding;)V", "mForbidUseFlash", "", "getMForbidUseFlash", "()Z", "setMForbidUseFlash", "(Z)V", "mForbidUseRecordTipResId", "", "getMForbidUseRecordTipResId", "()I", "setMForbidUseRecordTipResId", "(I)V", "mForbidUseStereoTipResId", "getMForbidUseStereoTipResId", "setMForbidUseStereoTipResId", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "mIsFlashTorch", "getMIsFlashTorch", "setMIsFlashTorch", "mIsInflateDelayFinish", "mIsVideoRecording", "getMIsVideoRecording", "setMIsVideoRecording", "mMzCameraControlbarBinding", "Lcom/meizu/media/camera/databinding/MzCameraControlbarBinding;", "getMMzCameraControlbarBinding", "()Lcom/meizu/media/camera/databinding/MzCameraControlbarBinding;", "setMMzCameraControlbarBinding", "(Lcom/meizu/media/camera/databinding/MzCameraControlbarBinding;)V", "mTemperatureForbidUseRecord", "getMTemperatureForbidUseRecord", "setMTemperatureForbidUseRecord", "mTemperatureStatus", "getMTemperatureStatus", "setMTemperatureStatus", "mUSBStatus", "getMUSBStatus", "setMUSBStatus", "afterCameraResume", "", "animImageCaptureOut", "anim", "Landroid/view/animation/Animation;", "animateAfterShutter", "isCaptureLoading", "animateBeforeShutter", "changeIconDirectlyOnForceTouch", "modeTypeIndex", "checkStorageSettingUI", "enable", "cleanModeFlash", "isModeNotSupportAuto", "updateParams", "updateImage", "cleanModeManual20M", "cleanStoredFlashState", "collapseFilter", "isNeedAnim", "collapseGuideUI", "collapseMenuAndGuide", "collapseSmartBar", "createPictureThumbnail", "thumbnail", "Landroid/graphics/Bitmap;", "jpegData", "", "filePath", "", "inSampleSize", "orientation", "mirror", "width", "height", "activityPause", "createPictureThumbnailFromPreview", "doFlashClick", "enableShutter", "enabled", "enableStorageSettingUI", "enableThumbnailBtn", "getAsdSceneType", "Lcom/meizu/media/camera/util/Contants$AsdSceneType;", "getCameraState", "getFilterUI", "Lcom/meizu/media/camera/ui/MzFilterUI;", "getHdrMode", "Lcom/meizu/media/camera/camcontroller/CameraController$HdrMode;", "getIsInflateDelayFinishStatus", "getLastThumbnail", "fromCache", "isNeedPreviewThumbGone", "needUpdateThumbnail", "getLutFilterUI", "Lcom/meizu/media/camera/ui/MzLutFilterUI;", "getNeedGetThumbnailFromData", "getThumbnailCallbackBinder", "Lcom/meizu/media/gallery/IThumbnailCallback;", "gotoLutManager", "handleARRecordingButtonStatus", "handleAsdDetection", "type", "handleAutoFlashDetection", "fire", "handleAutoModeScanState", "showHint", "handleBatteryLevel", "batteryLevel", "batteryStatus", "usbStatus", "handleCountDownStatus", "iscountdown", "handleFrontFlash", "isNeedFrontFlash", "handleFunnyRecording", "isRecording", "handleGifStatus", "status", "handleHdrDetection", "tips", "handleISODetection", "value", "handleImageCaptureStatus", "handleMyMessage", "msg", "Landroid/os/Message;", "handlePanoStatus", "startStop", "activityPaused", "handleRecordModeUI", "enterExit", "handleRecordPauseStatus", "pause", "handleRecordingButtonStatus", "handleRecordingStatus", "recording", "supportFilter", "handleRefocusStatus", "handleSceneModeHide", "handleSceneModeStatus", "handleSceneModes", "handleSettingStatus", "updateSet", "handleSlowMotionSize", "handleSmarbarStatusBlock", "block", "handleSmartbarStatus", "handleSquareStatus", "isSquare", "handleTemperatureStatus", "temperature", "handleThumbnailGone", "handleTopbarStatus", "show", "handleUSBStatus", "handleViewBackground", "resId", "handleViewEnable", "handleViewVisible", "handleWatch", "handleWideAngleAndFlash", "cameraId", "needSetFlash", "handleWideAngleIcon", "forceHide", "handleWifiDisplay", "wifiDisplayStatus", "hideCaptureLoading", "hideModeButtons", "hideSlideNotice", "inflateDelay", "initRenderOverlay", "renderOverlay", "Lcom/meizu/media/camera/views/RenderOverlay;", "gestures", "Lcom/meizu/media/camera/PreviewGestures;", "initializeFirstTime", "initializeSecondTime", "isCameraIdle", "isCaptureHdrOn", "isMFLLOn", "", "isCaptureNightOn", "isDestroy", "isFilterShowing", "isFlashOff", "isFlashTorch", "isFrontCamMirrorOn", "isFrontFlashSupported", "isHdrOn", "isLutFilterMode", "isManualHighPicSizeOn", "isMeterSeparateOn", "isModeMoveDragging", "isNeedNoticeFlash", "isSettingAndFilterShow", "isSettingShowing", "isSettingVisible", "isShowBackBtn", "isShutterButtonEnabled", "isShutterPressed", "needSlideNotice", "strId", "condition", "needUpdateThumbnailInActivityResult", "onBackPressed", "onBurstFinish", "isCancel", "onBurstStarted", "onCameraOpened", "onDestroy", "onFingerUp", "onOrientationChange", "leanAngle", "rotateAngle", "onPause", "onPauseStopRecordingUI", "onResume", "onSensorChanged", "orientationValue", "", "onShutterButtonDown", "captureTime", "", "isKeyDown", "onShutterButtonUp", "onSizeChoose", "data", "Landroid/content/Intent;", "onStart", "onStop", "pointInControlBar", "x", "y", "pointInSettingView", "pointInShutterButton", "refreshFBMode", "refreshFlashMode", "isTorch", "releaseThumbnailBinder", "rememberThumbnailEnableState", "resetFlashSettting", "resetFlashState", "resetIconY", "resetLastUri", "resetModeIndex", "modeIndex", "resetModeTypesInSlideBar", "resetPortraitRecordStatus", "resetSwitchUI", "resetTripodState", "restoreFlashState", "restoreSwitchUI", "restoreThumbnailEnableState", "saveLastThumbnail", "scrollToSelectFilter", "index", "selectedIndexUpdated", "setARRecordThumbnail", "recordThumbnail", "setCameraId", "setCameraState", "cameraState", "setCaptureTime", "time", "setDynamicFilterListAdapter", "adapter", "Lflyme/support/v7/widget/RecyclerView$Adapter;", "setIsInflateDelayFinish", "setIsSlowVideoRecording", "record", "setIsVideoRecording", "isRecorderRecording", "is4kRecording", "setModeTypesInSlideBar", "types", "Ljava/util/ArrayList;", "Lcom/meizu/media/camera/mode/CameraModeType$ModeType;", "defaultType", "setNeedGetThumbnailFromData", "isNeed", "setNeedTurnOnWatch", "setOnFilterItemClickListener", "listener", "Lflyme/support/v7/widget/MzRecyclerView$OnItemClickListener;", "setOtherUiListener", "Lcom/meizu/media/camera/ui/MzCommonUI$OtherUiListener;", "setOutsideIntentModeType", "outsideIntentModeType", "setPauseFling", "pauseFling", "setPreviewSize", "previewRect", "Landroid/graphics/RectF;", "setRecordThumbnail", "setSettingItemChecked", "checked", "setSettingsListener", "Lcom/meizu/media/camera/ui/SettingController$OnPreferenceChangedListener;", "key", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "setSlideModeRenderer", "slideModeRenderer", "Lcom/meizu/media/camera/views/MzSlideModeRenderer;", "setSmartBarListener", "Lcom/meizu/media/camera/ui/MzCommonUI$SmartBarUIListener;", "setStoragePreference", "sdcard", "setToastText", "text", "", "showCaptureLoading", "showModeButtons", "showModeMenu", "showSlideNotice", "disableAnim", "simulateModeChange", "stopAnimBeforeShutter", "turnOffVoiceAssist", "updateFilterName", "name", "updateLastestPicUri", "uri", "Landroid/net/Uri;", "updateOnScreenIndicators", "pref", "Lcom/meizu/media/camera/ComboPreferences;", "updateSmartbarHintText", "autoDisappear", "delayMillis", "", "updateSquareUI", "visible", "zoomSliderAnimStart", "isShow", "duration", "translateY", "", "interpolator", "Landroid/view/animation/PathInterpolator;", "SimHandler", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
/* renamed from: com.meizu.media.camera.ui.ae */
public abstract class NullCommonUI implements MzUIController {

    /* renamed from: I */
    public static ChangeQuickRedirect f12706I;

    /* renamed from: J */
    static final /* synthetic */ KProperty[] f12707J = {C3447o.m21171a((PropertyReference1) new PropertyReference1Impl(C3447o.m21170a(NullCommonUI.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};
    @NotNull

    /* renamed from: G */
    private CameraActivity f12708G;
    @NotNull

    /* renamed from: H */
    private MzCamController f12709H;
    @NotNull

    /* renamed from: K */
    private CameraBinding f12710K;
    @Nullable

    /* renamed from: L */
    private DelayInflateTwoBinding f12711L;
    @Nullable

    /* renamed from: M */
    private DelayInflateOneBinding f12712M;
    @Nullable

    /* renamed from: N */
    private MzCameraControlbarBinding f12713N;

    /* renamed from: O */
    private int f12714O;

    /* renamed from: P */
    private boolean f12715P;

    /* renamed from: Q */
    private boolean f12716Q;

    /* renamed from: R */
    private boolean f12717R;

    /* renamed from: S */
    private int f12718S = 201;

    /* renamed from: T */
    private boolean f12719T;

    /* renamed from: U */
    private int f12720U = -1;

    /* renamed from: V */
    private int f12721V = -1;
    @NotNull

    /* renamed from: W */
    private final C3403f f12722W = C3410g.m21119a(new C2434b(this));

    /* renamed from: X */
    private boolean f12723X;

    /* renamed from: A */
    public void mo21476A(boolean z) {
    }

    /* renamed from: A */
    public boolean mo21477A() {
        return false;
    }

    /* renamed from: B */
    public void mo21478B(boolean z) {
    }

    /* renamed from: B */
    public boolean mo21479B() {
        return false;
    }

    /* renamed from: C */
    public void mo21480C() {
    }

    /* renamed from: D */
    public boolean mo21481D() {
        return false;
    }

    /* renamed from: E */
    public boolean mo21482E() {
        return false;
    }

    /* renamed from: F */
    public void mo21483F() {
    }

    /* renamed from: G */
    public void mo21484G() {
    }

    @Nullable
    /* renamed from: H */
    public MzFilterUI mo21485H() {
        return null;
    }

    @Nullable
    /* renamed from: I */
    public MzLutFilterUI mo21486I() {
        return null;
    }

    /* renamed from: J */
    public void mo21487J() {
    }

    /* renamed from: K */
    public void mo21488K() {
    }

    /* renamed from: L */
    public void mo21489L() {
    }

    /* renamed from: M */
    public void mo21490M() {
    }

    /* renamed from: N */
    public void mo21491N() {
    }

    /* renamed from: O */
    public boolean mo21492O() {
        return false;
    }

    /* renamed from: P */
    public boolean mo21493P() {
        return false;
    }

    /* renamed from: Q */
    public boolean mo21494Q() {
        return false;
    }

    /* renamed from: R */
    public boolean mo21495R() {
        return false;
    }

    /* renamed from: S */
    public void mo21496S() {
    }

    /* renamed from: T */
    public void mo21497T() {
    }

    /* renamed from: U */
    public void mo21498U() {
    }

    /* renamed from: V */
    public boolean mo21499V() {
        return false;
    }

    /* renamed from: W */
    public boolean mo21500W() {
        return false;
    }

    /* renamed from: X */
    public void mo21501X() {
    }

    /* renamed from: Z */
    public boolean mo21503Z() {
        return false;
    }

    /* renamed from: a */
    public void mo21506a(int i) {
    }

    /* renamed from: a */
    public void mo21508a(int i, int i2, int i3) {
    }

    /* renamed from: a */
    public void mo21509a(int i, int i2, @NotNull RectF rectF) {
        if (!PatchProxy.proxy(new Object[]{new Integer(i), new Integer(i2), rectF}, this, f12706I, false, 7675, new Class[]{Integer.TYPE, Integer.TYPE, RectF.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(rectF, "previewRect");
        }
    }

    /* renamed from: a */
    public void mo21510a(int i, boolean z) {
    }

    /* renamed from: a */
    public void mo21511a(int i, boolean z, boolean z2) {
    }

    /* renamed from: a */
    public void mo21512a(long j) {
    }

    /* renamed from: a */
    public void mo21513a(long j, boolean z) {
    }

    /* renamed from: a */
    public void mo21514a(@Nullable Intent intent) {
    }

    /* renamed from: a */
    public void mo21515a(@Nullable Bitmap bitmap) {
    }

    /* renamed from: a */
    public void mo21516a(@Nullable Bitmap bitmap, int i, boolean z, boolean z2) {
    }

    /* renamed from: a */
    public void mo21517a(@Nullable Bitmap bitmap, @Nullable byte[] bArr, @Nullable String str, int i, int i2, boolean z, int i3, int i4, boolean z2) {
    }

    /* renamed from: a */
    public void mo21518a(@Nullable Uri uri) {
    }

    /* renamed from: a */
    public abstract void mo21687a(@Nullable Message message);

    /* renamed from: a */
    public void mo21519a(@Nullable ComboPreferences eVar) {
    }

    /* renamed from: a */
    public void mo21520a(@Nullable MzCommonUI.C2403f fVar) {
    }

    /* renamed from: a */
    public void mo21521a(@Nullable SettingController.C2436a aVar) {
    }

    /* renamed from: a */
    public void mo21522a(@NotNull Contants.AsdSceneType asdSceneType) {
        if (!PatchProxy.proxy(new Object[]{asdSceneType}, this, f12706I, false, 7671, new Class[]{Contants.AsdSceneType.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(asdSceneType, "type");
        }
    }

    /* renamed from: a */
    public void mo21523a(@NotNull RenderOverlay renderOverlay, @Nullable PreviewGestures yVar) {
        Class[] clsArr = {RenderOverlay.class, PreviewGestures.class};
        if (!PatchProxy.proxy(new Object[]{renderOverlay, yVar}, this, f12706I, false, 7673, clsArr, Void.TYPE).isSupported) {
            C3443i.m21155b(renderOverlay, "renderOverlay");
        }
    }

    /* renamed from: a */
    public void mo21524a(@NotNull MzSlideModeRenderer jVar) {
        if (!PatchProxy.proxy(new Object[]{jVar}, this, f12706I, false, 7676, new Class[]{MzSlideModeRenderer.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(jVar, "slideModeRenderer");
        }
    }

    /* renamed from: a */
    public void mo21525a(@Nullable MzRecyclerView.C3227j jVar) {
    }

    /* renamed from: a */
    public void mo21526a(@Nullable RecyclerView.C3260a<?> aVar) {
    }

    /* renamed from: a */
    public void mo21527a(@Nullable CharSequence charSequence) {
    }

    /* renamed from: a */
    public void mo21528a(@Nullable String str) {
    }

    /* renamed from: a */
    public void mo21529a(@Nullable String str, boolean z, @NotNull long... jArr) {
        if (!PatchProxy.proxy(new Object[]{str, new Byte(z ? (byte) 1 : 0), jArr}, this, f12706I, false, 7677, new Class[]{String.class, Boolean.TYPE, long[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(jArr, "delayMillis");
        }
    }

    /* renamed from: a */
    public void mo21530a(boolean z) {
    }

    /* renamed from: a */
    public void mo21531a(boolean z, int i, float f, @NotNull PathInterpolator pathInterpolator) {
        if (!PatchProxy.proxy(new Object[]{new Byte(z ? (byte) 1 : 0), new Integer(i), new Float(f), pathInterpolator}, this, f12706I, false, 7672, new Class[]{Boolean.TYPE, Integer.TYPE, Float.TYPE, PathInterpolator.class}, Void.TYPE).isSupported) {
            C3443i.m21155b(pathInterpolator, "interpolator");
        }
    }

    /* renamed from: a */
    public void mo21532a(boolean z, boolean z2) {
    }

    /* renamed from: a */
    public void mo21533a(boolean z, boolean z2, boolean z3) {
    }

    /* renamed from: a */
    public void mo21534a(@NotNull float[] fArr) {
        if (!PatchProxy.proxy(new Object[]{fArr}, this, f12706I, false, 7678, new Class[]{float[].class}, Void.TYPE).isSupported) {
            C3443i.m21155b(fArr, "orientationValue");
        }
    }

    /* renamed from: a */
    public boolean mo21535a(@NotNull boolean... zArr) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{zArr}, this, f12706I, false, 7674, new Class[]{boolean[].class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        C3443i.m21155b(zArr, "isMFLLOn");
        return false;
    }

    /* renamed from: aD */
    public void mo21691aD() {
    }

    /* renamed from: aP */
    public int mo21703aP() {
        return 1;
    }

    /* renamed from: ab */
    public void mo21537ab() {
    }

    /* renamed from: ac */
    public void mo21538ac() {
    }

    /* renamed from: ad */
    public void mo21539ad() {
    }

    /* renamed from: ag */
    public void mo21542ag() {
    }

    /* renamed from: ah */
    public boolean mo21543ah() {
        return false;
    }

    /* renamed from: ai */
    public void mo21544ai() {
    }

    /* renamed from: ak */
    public void mo21546ak() {
    }

    @Nullable
    /* renamed from: an */
    public IThumbnailCallback mo21549an() {
        return null;
    }

    /* renamed from: ao */
    public void mo21550ao() {
    }

    /* renamed from: ap */
    public boolean mo21551ap() {
        return false;
    }

    /* renamed from: aq */
    public void mo21552aq() {
    }

    /* renamed from: ar */
    public void mo21553ar() {
    }

    /* renamed from: as */
    public void mo21554as() {
    }

    /* renamed from: at */
    public void mo21555at() {
    }

    /* renamed from: au */
    public boolean mo21556au() {
        return false;
    }

    /* renamed from: av */
    public boolean mo21557av() {
        return false;
    }

    /* renamed from: aw */
    public boolean mo21558aw() {
        return false;
    }

    /* renamed from: ax */
    public void mo21559ax() {
    }

    /* renamed from: ay */
    public boolean mo21560ay() {
        return false;
    }

    /* renamed from: az */
    public void mo21561az() {
    }

    /* renamed from: b */
    public void mo21563b() {
    }

    /* renamed from: b */
    public void mo21564b(int i) {
    }

    /* renamed from: b */
    public void mo21565b(int i, int i2) {
    }

    /* renamed from: b */
    public void mo21566b(int i, boolean z) {
    }

    /* renamed from: b */
    public void mo21567b(@Nullable Bitmap bitmap) {
    }

    /* renamed from: b */
    public void mo21568b(boolean z) {
    }

    /* renamed from: b */
    public void mo21569b(boolean z, boolean z2) {
    }

    /* renamed from: b */
    public void mo21570b(boolean z, boolean z2, boolean z3) {
    }

    @NotNull
    /* renamed from: bk */
    public final Handler mo21859bk() {
        Object a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12706I, false, 7670, new Class[0], Handler.class);
        if (proxy.isSupported) {
            a = proxy.result;
        } else {
            C3403f fVar = this.f12722W;
            KProperty eVar = f12707J[0];
            a = fVar.mo27448a();
        }
        return (Handler) a;
    }

    /* renamed from: c */
    public void mo21571c() {
    }

    /* renamed from: c */
    public void mo21573c(int i, int i2) {
    }

    /* renamed from: c */
    public void mo21574c(int i, boolean z) {
    }

    /* renamed from: c */
    public void mo21575c(boolean z) {
    }

    /* renamed from: c */
    public void mo21576c(boolean z, boolean z2) {
    }

    /* renamed from: c */
    public void mo21577c(boolean z, boolean z2, boolean z3) {
    }

    /* renamed from: d */
    public void mo21578d() {
    }

    /* renamed from: d */
    public void mo21579d(int i) {
    }

    /* renamed from: d */
    public void mo21580d(int i, int i2) {
    }

    /* renamed from: d */
    public void mo21581d(int i, boolean z) {
    }

    /* renamed from: d */
    public void mo21582d(boolean z) {
    }

    /* renamed from: e */
    public void mo21583e() {
    }

    /* renamed from: e */
    public void mo21584e(int i) {
    }

    /* renamed from: e */
    public void mo21585e(int i, boolean z) {
    }

    /* renamed from: e */
    public void mo21586e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo21587e(int i, int i2) {
        return false;
    }

    /* renamed from: f */
    public void mo21588f(int i) {
    }

    /* renamed from: f */
    public void mo21711f(int i, boolean z) {
    }

    /* renamed from: f */
    public void mo21589f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo21591f(int i, int i2) {
        return false;
    }

    /* renamed from: g */
    public void mo21592g(int i) {
    }

    /* renamed from: g */
    public void mo21712g(int i, boolean z) {
    }

    /* renamed from: g */
    public void mo21593g(boolean z) {
    }

    /* renamed from: g */
    public boolean mo21594g() {
        return false;
    }

    /* renamed from: g */
    public boolean mo21595g(int i, int i2) {
        return false;
    }

    /* renamed from: h */
    public void mo21596h() {
    }

    /* renamed from: h */
    public void mo21597h(int i) {
    }

    /* renamed from: h */
    public void mo21598h(int i, int i2) {
    }

    /* renamed from: h */
    public void mo21713h(int i, boolean z) {
    }

    /* renamed from: h */
    public void mo21599h(boolean z) {
    }

    /* renamed from: i */
    public void mo21600i(int i) {
    }

    /* renamed from: i */
    public void mo21601i(boolean z) {
    }

    /* renamed from: i */
    public boolean mo21602i() {
        return false;
    }

    /* renamed from: j */
    public void mo21605j(int i) {
    }

    /* renamed from: j */
    public void mo21606j(boolean z) {
    }

    /* renamed from: k */
    public void mo21607k(int i) {
    }

    /* renamed from: k */
    public boolean mo21608k() {
        return false;
    }

    /* renamed from: k */
    public boolean mo21609k(boolean z) {
        return false;
    }

    /* renamed from: l */
    public void mo21610l(int i) {
    }

    /* renamed from: l */
    public void mo21611l(boolean z) {
    }

    /* renamed from: l */
    public boolean mo21612l() {
        return false;
    }

    /* renamed from: m */
    public void mo21613m(int i) {
    }

    /* renamed from: m */
    public void mo21614m(boolean z) {
    }

    /* renamed from: m */
    public boolean mo21615m() {
        return false;
    }

    /* renamed from: n */
    public void mo21616n() {
    }

    /* renamed from: n */
    public void mo21617n(int i) {
    }

    /* renamed from: n */
    public void mo21618n(boolean z) {
    }

    /* renamed from: o */
    public void mo21619o() {
    }

    /* renamed from: o */
    public void mo21620o(int i) {
    }

    /* renamed from: o */
    public void mo21621o(boolean z) {
    }

    /* renamed from: p */
    public void mo21622p(int i) {
    }

    /* renamed from: p */
    public void mo21623p(boolean z) {
    }

    /* renamed from: p */
    public boolean mo21624p() {
        return false;
    }

    /* renamed from: q */
    public void mo21625q() {
    }

    /* renamed from: q */
    public void mo21627q(boolean z) {
    }

    /* renamed from: r */
    public void mo21628r() {
    }

    /* renamed from: r */
    public void mo21629r(int i) {
    }

    /* renamed from: s */
    public void mo21631s() {
    }

    /* renamed from: s */
    public void mo21632s(int i) {
    }

    /* renamed from: t */
    public void mo21634t() {
    }

    /* renamed from: t */
    public void mo21636t(boolean z) {
    }

    /* renamed from: u */
    public void mo21637u() {
    }

    /* renamed from: u */
    public void mo21638u(int i) {
    }

    /* renamed from: v */
    public void mo21640v() {
    }

    /* renamed from: w */
    public void mo21642w() {
    }

    /* renamed from: x */
    public void mo21644x() {
    }

    /* renamed from: y */
    public boolean mo21647y() {
        return false;
    }

    /* renamed from: z */
    public boolean mo21649z() {
        return false;
    }

    public NullCommonUI(@NotNull CameraActivity cameraActivity, @NotNull MzCamController mzCamController, @NotNull CameraBinding cameraBinding) {
        C3443i.m21155b(cameraActivity, PushConstants.INTENT_ACTIVITY_NAME);
        C3443i.m21155b(mzCamController, "controller");
        C3443i.m21155b(cameraBinding, "cameraBinding");
        this.f12708G = cameraActivity;
        this.f12709H = mzCamController;
        this.f12710K = cameraBinding;
    }

    @NotNull
    /* renamed from: aX */
    public final CameraActivity mo21846aX() {
        return this.f12708G;
    }

    @NotNull
    /* renamed from: aY */
    public final MzCamController mo21847aY() {
        return this.f12709H;
    }

    @NotNull
    /* renamed from: aZ */
    public final CameraBinding mo21848aZ() {
        return this.f12710K;
    }

    /* renamed from: a */
    public final void mo21844a(@Nullable DelayInflateTwoBinding delayInflateTwoBinding) {
        this.f12711L = delayInflateTwoBinding;
    }

    @Nullable
    /* renamed from: ba */
    public final DelayInflateTwoBinding mo21849ba() {
        return this.f12711L;
    }

    /* renamed from: a */
    public final void mo21843a(@Nullable DelayInflateOneBinding delayInflateOneBinding) {
        this.f12712M = delayInflateOneBinding;
    }

    @Nullable
    /* renamed from: bb */
    public final DelayInflateOneBinding mo21850bb() {
        return this.f12712M;
    }

    /* renamed from: a */
    public final void mo21845a(@Nullable MzCameraControlbarBinding mzCameraControlbarBinding) {
        this.f12713N = mzCameraControlbarBinding;
    }

    @Nullable
    /* renamed from: bc */
    public final MzCameraControlbarBinding mo21851bc() {
        return this.f12713N;
    }

    /* renamed from: bd */
    public final int mo21852bd() {
        return this.f12714O;
    }

    /* renamed from: w */
    public final void mo21860w(int i) {
        this.f12714O = i;
    }

    /* renamed from: E */
    public final void mo21839E(boolean z) {
        this.f12715P = z;
    }

    /* renamed from: be */
    public final boolean mo21853be() {
        return this.f12715P;
    }

    /* renamed from: F */
    public final void mo21840F(boolean z) {
        this.f12716Q = z;
    }

    /* renamed from: bf */
    public final boolean mo21854bf() {
        return this.f12716Q;
    }

    /* renamed from: G */
    public final void mo21841G(boolean z) {
        this.f12717R = z;
    }

    /* renamed from: bg */
    public final boolean mo21855bg() {
        return this.f12717R;
    }

    /* renamed from: bh */
    public final int mo21856bh() {
        return this.f12718S;
    }

    /* renamed from: x */
    public final void mo21861x(int i) {
        this.f12718S = i;
    }

    /* renamed from: H */
    public final void mo21842H(boolean z) {
        this.f12719T = z;
    }

    /* renamed from: bi */
    public final boolean mo21857bi() {
        return this.f12719T;
    }

    /* renamed from: bj */
    public final int mo21858bj() {
        return this.f12720U;
    }

    /* renamed from: y */
    public final void mo21862y(int i) {
        this.f12720U = i;
    }

    /* renamed from: z */
    public final void mo21863z(int i) {
        this.f12721V = i;
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo27294d2 = {"<anonymous>", "Lcom/meizu/media/camera/ui/NullCommonUI$SimHandler;", "invoke"}, mo27295k = 3, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.ae$b */
    /* compiled from: NullCommonUI.kt */
    static final class C2434b extends Lambda implements Functions<C2433a> {

        /* renamed from: a */
        public static ChangeQuickRedirect f12726a;

        /* renamed from: b */
        final /* synthetic */ NullCommonUI f12727b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2434b(NullCommonUI aeVar) {
            super(0);
            this.f12727b = aeVar;
        }

        @NotNull
        /* renamed from: b */
        public final C2433a mo18337a() {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, f12726a, false, 7681, new Class[0], C2433a.class);
            return proxy.isSupported ? (C2433a) proxy.result : new C2433a(this.f12727b);
        }
    }

    @Metadata(mo27292bv = {1, 0, 3}, mo27293d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R(\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, mo27294d2 = {"Lcom/meizu/media/camera/ui/NullCommonUI$SimHandler;", "Landroid/os/Handler;", "commonUI", "Lcom/meizu/media/camera/ui/NullCommonUI;", "(Lcom/meizu/media/camera/ui/NullCommonUI;)V", "mCommonUI", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getMCommonUI", "()Ljava/lang/ref/WeakReference;", "setMCommonUI", "(Ljava/lang/ref/WeakReference;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "Camera_release"}, mo27295k = 1, mo27296mv = {1, 1, 15})
    /* renamed from: com.meizu.media.camera.ui.ae$a */
    /* compiled from: NullCommonUI.kt */
    private static final class C2433a extends Handler {

        /* renamed from: a */
        public static ChangeQuickRedirect f12724a;
        @NotNull

        /* renamed from: b */
        private WeakReference<NullCommonUI> f12725b;

        public C2433a(@NotNull NullCommonUI aeVar) {
            C3443i.m21155b(aeVar, "commonUI");
            this.f12725b = new WeakReference<>(aeVar);
        }

        public void handleMessage(@NotNull Message message) {
            if (!PatchProxy.proxy(new Object[]{message}, this, f12724a, false, 7680, new Class[]{Message.class}, Void.TYPE).isSupported) {
                C3443i.m21155b(message, NotificationCompat.CATEGORY_MESSAGE);
                if (this.f12725b.get() != null) {
                    Object obj = this.f12725b.get();
                    if (obj == null) {
                        C3443i.m21151a();
                    }
                    ((NullCommonUI) obj).mo21687a(message);
                }
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public Contants.AsdSceneType mo21504a() {
        return Contants.AsdSceneType.AUTO;
    }

    @Nullable
    /* renamed from: j */
    public CameraController.HdrMode mo21604j() {
        return CameraController.HdrMode.OFF;
    }

    /* renamed from: y */
    public void mo21646y(boolean z) {
        this.f12723X = z;
    }

    /* renamed from: aj */
    public boolean mo21545aj() {
        return this.f12723X;
    }
}
