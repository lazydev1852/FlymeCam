package com.meizu.media.mzfunnysnapsdk.Filter;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;
import com.mediatek.accessor.packer.PackUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.EasyGlUtils;
import com.meizu.media.mzfunnysnapsdk.Utils.MatrixUtils;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GroupFilter extends BaseFilter {
    public static ChangeQuickRedirect changeQuickRedirect;
    private int[] fFrame = new int[1];
    private int[] fRender = new int[1];
    private int[] fTexture = new int[this.fTextureSize];
    private int fTextureSize = 2;
    private int height = 0;
    private boolean isOutputByTexture = true;
    private Queue<BaseFilter> mFilterQueue = new ConcurrentLinkedQueue();
    private List<BaseFilter> mFilters = new ArrayList();
    private int size = 0;
    private int textureIndex = 0;
    private int width = 0;

    public void initBuffer() {
    }

    public void onCreate() {
    }

    public GroupFilter(Resources resources, boolean z) {
        super(resources, z);
    }

    public GroupFilter(Resources resources) {
        super(resources);
    }

    public void addFilter(BaseFilter baseFilter) {
        if (!PatchProxy.proxy(new Object[]{baseFilter}, this, changeQuickRedirect, false, 9089, new Class[]{BaseFilter.class}, Void.TYPE).isSupported) {
            if (!baseFilter.is_Sticker) {
                MatrixUtils.flip(baseFilter.getMatrix(), false, true);
            } else {
                MatrixUtils.flip(baseFilter.getMatrix(), false, true);
            }
            this.mFilterQueue.add(baseFilter);
            this.mFilterQueue.size();
        }
    }

    public boolean removeFilter(BaseFilter baseFilter) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{baseFilter}, this, changeQuickRedirect, false, 9090, new Class[]{BaseFilter.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        boolean remove = this.mFilters.remove(baseFilter);
        if (remove) {
            this.size--;
            this.mFilterQueue.size();
        }
        return remove;
    }

    public BaseFilter removeFilter(int i) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{new Integer(i)}, this, changeQuickRedirect, false, 9091, new Class[]{Integer.TYPE}, BaseFilter.class);
        if (proxy.isSupported) {
            return (BaseFilter) proxy.result;
        }
        BaseFilter remove = this.mFilters.remove(i);
        if (remove != null) {
            this.size--;
        }
        return remove;
    }

    public void clearAll() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9092, new Class[0], Void.TYPE).isSupported) {
            this.mFilterQueue.clear();
            this.mFilters.clear();
            this.size = 0;
        }
    }

    public void draw() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9093, new Class[0], Void.TYPE).isSupported) {
            updateFilter();
            this.textureIndex = 0;
            if (this.size > 0) {
                for (int i = 0; i < this.size - 1; i++) {
                    BaseFilter baseFilter = this.mFilters.get(i);
                    GLES20.glBindFramebuffer(36160, this.fFrame[0]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.fTexture[this.textureIndex % 2], 0);
                    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.fRender[0]);
                    GLES20.glViewport(0, 0, this.width, this.height);
                    if (this.textureIndex == 0) {
                        baseFilter.setTextureId(getTextureId());
                    } else {
                        baseFilter.setTextureId(this.fTexture[(this.textureIndex - 1) % 2]);
                    }
                    baseFilter.draw();
                    unBindFrame();
                    this.textureIndex++;
                }
                if (this.isOutputByTexture) {
                    GLES20.glBindFramebuffer(36160, this.fFrame[0]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.fTexture[this.textureIndex % 2], 0);
                    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.fRender[0]);
                    GLES20.glViewport(0, 0, this.width, this.height);
                }
                BaseFilter baseFilter2 = this.mFilters.get(this.size - 1);
                if (this.textureIndex == 0) {
                    baseFilter2.setTextureId(getTextureId());
                } else {
                    baseFilter2.setTextureId(this.fTexture[(this.textureIndex - 1) % 2]);
                }
                baseFilter2.draw();
                if (this.isOutputByTexture) {
                    unBindFrame();
                    this.textureIndex++;
                }
            }
        }
    }

    public void updateFilter() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9094, new Class[0], Void.TYPE).isSupported) {
            while (true) {
                BaseFilter poll = this.mFilterQueue.poll();
                if (poll != null) {
                    poll.create();
                    poll.setSize(this.width, this.height);
                    this.mFilters.add(poll);
                    this.size++;
                } else {
                    return;
                }
            }
        }
    }

    public void setOutputByTexture(boolean z) {
        this.isOutputByTexture = z;
    }

    public int getOutputTexture() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9095, new Class[0], Integer.TYPE);
        if (proxy.isSupported) {
            return ((Integer) proxy.result).intValue();
        }
        return this.size == 0 ? getTextureId() : this.fTexture[(this.textureIndex - 1) % 2];
    }

    public void onSizeChanged(int i, int i2) {
        Object[] objArr = {new Integer(i), new Integer(i2)};
        ChangeQuickRedirect changeQuickRedirect2 = changeQuickRedirect;
        if (!PatchProxy.proxy(objArr, this, changeQuickRedirect2, false, 9096, new Class[]{Integer.TYPE, Integer.TYPE}, Void.TYPE).isSupported) {
            this.width = i;
            this.height = i2;
            updateFilter();
            deleteFrameBuffer();
            createFrameBuffer();
        }
    }

    private boolean createFrameBuffer() {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9097, new Class[0], Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        GLES20.glGenFramebuffers(1, this.fFrame, 0);
        GLES20.glGenRenderbuffers(1, this.fRender, 0);
        genTextures();
        GLES20.glBindFramebuffer(36160, this.fFrame[0]);
        GLES20.glBindRenderbuffer(36161, this.fRender[0]);
        GLES20.glRenderbufferStorage(36161, 33189, this.width, this.height);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.fTexture[0], 0);
        unBindFrame();
        return false;
    }

    private void genTextures() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9098, new Class[0], Void.TYPE).isSupported) {
            GLES20.glGenTextures(this.fTextureSize, this.fTexture, 0);
            for (int i = 0; i < this.fTextureSize; i++) {
                GLES20.glBindTexture(3553, this.fTexture[i]);
                GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glTexParameteri(3553, PackUtils.FIXED_BUFFER_SIZE, 9729);
                GLES20.glTexParameteri(3553, 10241, 9729);
            }
        }
    }

    private void unBindFrame() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9099, new Class[0], Void.TYPE).isSupported) {
            GLES20.glBindRenderbuffer(36161, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    private void deleteFrameBuffer() {
        if (!PatchProxy.proxy(new Object[0], this, changeQuickRedirect, false, 9100, new Class[0], Void.TYPE).isSupported) {
            Log.i("FunnySnapFlow", "GroupFilter deleteFrameBuffer");
            GLES20.glDeleteRenderbuffers(1, this.fRender, 0);
            GLES20.glDeleteFramebuffers(1, this.fFrame, 0);
            GLES20.glDeleteTextures(this.fTextureSize, this.fTexture, 0);
            EasyGlUtils.checkEglError("deleteFrameBuffer");
        }
    }
}
