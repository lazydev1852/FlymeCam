package com.meizu.savior;

import java.io.File;

public class Patch implements Cloneable {
    private String appHash;
    private boolean isAppliedSuccess;
    private String localPath;
    private String md5;
    private String name;
    private int patchVerCode;
    private String patchesInfoImplClassFullName;
    private String url;

    public Patch clone() {
        try {
            return (Patch) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void delete(String str) {
        new File(str).delete();
    }

    public String getAppHash() {
        return this.appHash;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getName() {
        return this.name;
    }

    public int getPatchVerCode() {
        return this.patchVerCode;
    }

    public String getPatchesInfoImplClassFullName() {
        return this.patchesInfoImplClassFullName;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAppliedSuccess() {
        return this.isAppliedSuccess;
    }

    public void setAppHash(String str) {
        this.appHash = str;
    }

    public void setAppliedSuccess(boolean z) {
        this.isAppliedSuccess = z;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPatchVerCode(int i) {
        this.patchVerCode = i;
    }

    public void setPatchesInfoImplClassFullName(String str) {
        this.patchesInfoImplClassFullName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
