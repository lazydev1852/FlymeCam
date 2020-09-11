package com.baidu.p020ar.arplay.representation;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.baidu.ar.arplay.representation.Renderable */
public class Renderable implements Serializable {
    private static final long serialVersionUID = 6701586807666461858L;
    protected boolean dirty = true;
    protected ReentrantLock lock = new ReentrantLock();

    public boolean dirty() {
        return this.dirty;
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    public void setClean() {
        this.dirty = false;
    }

    public void setDirty() {
        this.dirty = true;
    }
}
