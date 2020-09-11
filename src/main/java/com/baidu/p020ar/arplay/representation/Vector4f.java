package com.baidu.p020ar.arplay.representation;

import java.io.Serializable;

/* renamed from: com.baidu.ar.arplay.representation.Vector4f */
public class Vector4f extends Renderable implements Serializable {
    private static final long serialVersionUID = 1;
    protected float[] points = {0.0f, 0.0f, 0.0f, 0.0f};

    public Vector4f() {
        this.points[0] = 0.0f;
        this.points[1] = 0.0f;
        this.points[2] = 0.0f;
        this.points[3] = 0.0f;
    }

    public Vector4f(float f, float f2, float f3, float f4) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        this.points[3] = f4;
    }

    public Vector4f(Vector3f vector3f, float f) {
        this.points[0] = vector3f.mo9363x();
        this.points[1] = vector3f.mo9365y();
        this.points[2] = vector3f.mo9367z();
        this.points[3] = f;
    }

    public void add(Vector3f vector3f, float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.mo9363x();
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + vector3f.mo9365y();
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + vector3f.mo9367z();
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] + f;
    }

    public void add(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector4f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + vector4f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + vector4f.points[2];
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] + vector4f.points[3];
    }

    public boolean compareTo(Vector4f vector4f) {
        return this.points[0] == vector4f.points[0] && this.points[1] == vector4f.points[1] && this.points[2] == vector4f.points[2] && this.points[3] == vector4f.points[3];
    }

    public void copyFromV3f(Vector3f vector3f, float f) {
        this.points[0] = vector3f.mo9363x();
        this.points[1] = vector3f.mo9365y();
        this.points[2] = vector3f.mo9367z();
        this.points[3] = f;
    }

    public void copyVec4(Vector4f vector4f) {
        this.points[0] = vector4f.points[0];
        this.points[1] = vector4f.points[1];
        this.points[2] = vector4f.points[2];
        this.points[3] = vector4f.points[3];
    }

    public float dotProduct(Vector4f vector4f) {
        return (this.points[0] * vector4f.points[0]) + (this.points[1] * vector4f.points[1]) + (this.points[2] * vector4f.points[2]) + (this.points[3] * vector4f.points[3]);
    }

    public float getW() {
        return this.points[3];
    }

    public float getX() {
        return this.points[0];
    }

    public float getY() {
        return this.points[1];
    }

    public float getZ() {
        return this.points[2];
    }

    public void lerp(Vector4f vector4f, Vector4f vector4f2, float f) {
        float f2 = 1.0f * f;
        vector4f2.points[0] = (this.points[0] * f2) + (vector4f.points[0] * f);
        vector4f2.points[1] = (this.points[1] * f2) + (vector4f.points[1] * f);
        vector4f2.points[2] = (this.points[2] * f2) + (vector4f.points[2] * f);
        vector4f2.points[3] = (this.points[3] * f2) + (vector4f.points[3] * f);
    }

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] * f;
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] * f;
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] * f;
    }

    public void normalize() {
        if (this.points[3] != 0.0f) {
            float[] fArr = this.points;
            fArr[0] = fArr[0] / this.points[3];
            float[] fArr2 = this.points;
            fArr2[1] = fArr2[1] / this.points[3];
            float[] fArr3 = this.points;
            fArr3[2] = fArr3[2] / this.points[3];
            double sqrt = Math.sqrt((double) ((this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2])));
            this.points[0] = (float) (((double) this.points[0]) / sqrt);
            this.points[1] = (float) (((double) this.points[1]) / sqrt);
            this.points[2] = (float) (((double) this.points[2]) / sqrt);
        }
    }

    public void setW(float f) {
        this.points[3] = f;
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setXYZW(float f, float f2, float f3, float f4) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
        this.points[3] = f4;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public void subdivide(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] / vector4f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] / vector4f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] / vector4f.points[2];
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] / vector4f.points[3];
    }

    public void subtract(Vector4f vector4f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] - vector4f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] - vector4f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] - vector4f.points[2];
        float[] fArr4 = this.points;
        fArr4[3] = fArr4[3] - vector4f.points[3];
    }

    public void subtract(Vector4f vector4f, Vector4f vector4f2) {
        vector4f2.setXYZW(this.points[0] - vector4f.points[0], this.points[1] - vector4f.points[1], this.points[2] - vector4f.points[2], this.points[3] - vector4f.points[3]);
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2] + " W:" + this.points[3];
    }

    /* renamed from: w */
    public float mo9390w() {
        return this.points[3];
    }

    /* renamed from: w */
    public void mo9391w(float f) {
        this.points[3] = f;
    }

    /* renamed from: x */
    public float mo9392x() {
        return this.points[0];
    }

    /* renamed from: x */
    public void mo9393x(float f) {
        this.points[0] = f;
    }

    /* renamed from: y */
    public float mo9394y() {
        return this.points[1];
    }

    /* renamed from: y */
    public void mo9395y(float f) {
        this.points[1] = f;
    }

    /* renamed from: z */
    public float mo9396z() {
        return this.points[2];
    }

    /* renamed from: z */
    public void mo9397z(float f) {
        this.points[2] = f;
    }
}
