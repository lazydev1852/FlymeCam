package com.baidu.p020ar.arplay.representation;

/* renamed from: com.baidu.ar.arplay.representation.Vector3f */
public class Vector3f extends Renderable {
    private static final long serialVersionUID = -4565578579900616220L;
    protected float[] points = new float[3];

    public Vector3f() {
    }

    public Vector3f(float f) {
        this.points[0] = f;
        this.points[1] = f;
        this.points[2] = f;
    }

    public Vector3f(float f, float f2, float f3) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
    }

    public Vector3f(Vector3f vector3f) {
        this.points[0] = vector3f.points[0];
        this.points[1] = vector3f.points[1];
        this.points[2] = vector3f.points[2];
    }

    public Vector3f(Vector4f vector4f) {
        if (vector4f.mo9390w() != 0.0f) {
            this.points[0] = vector4f.mo9392x() / vector4f.mo9390w();
            this.points[1] = vector4f.mo9394y() / vector4f.mo9390w();
            this.points[2] = vector4f.mo9396z() / vector4f.mo9390w();
            return;
        }
        this.points[0] = vector4f.mo9392x();
        this.points[1] = vector4f.mo9394y();
        this.points[2] = vector4f.mo9396z();
    }

    public void add(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + f;
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + f;
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + f;
    }

    public void add(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] + vector3f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] + vector3f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] + vector3f.points[2];
    }

    public void clone(Vector3f vector3f) {
        System.arraycopy(vector3f.points, 0, this.points, 0, 3);
    }

    public void clone(float[] fArr) {
        System.arraycopy(fArr, 0, this.points, 0, 3);
    }

    public Vector3f crossProduct(Vector3f vector3f) {
        Vector3f vector3f2 = new Vector3f();
        crossProduct(vector3f, vector3f2);
        return vector3f2;
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        vector3f2.setX((this.points[1] * vector3f.points[2]) - (this.points[2] * vector3f.points[1]));
        vector3f2.setY((this.points[2] * vector3f.points[0]) - (this.points[0] * vector3f.points[2]));
        vector3f2.setZ((this.points[0] * vector3f.points[1]) - (this.points[1] * vector3f.points[0]));
    }

    public float dotProduct(Vector3f vector3f) {
        return (this.points[0] * vector3f.points[0]) + (this.points[1] * vector3f.points[1]) + (this.points[2] * vector3f.points[2]);
    }

    public float getLength() {
        return (float) Math.sqrt((double) ((this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2])));
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

    public void multiplyByScalar(float f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] * f;
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] * f;
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] * f;
    }

    public void normalize() {
        double sqrt = Math.sqrt((double) ((this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2])));
        this.points[0] = (float) (((double) this.points[0]) / sqrt);
        this.points[1] = (float) (((double) this.points[1]) / sqrt);
        this.points[2] = (float) (((double) this.points[2]) / sqrt);
    }

    public void setX(float f) {
        this.points[0] = f;
    }

    public void setXYZ(float f, float f2, float f3) {
        this.points[0] = f;
        this.points[1] = f2;
        this.points[2] = f3;
    }

    public void setY(float f) {
        this.points[1] = f;
    }

    public void setZ(float f) {
        this.points[2] = f;
    }

    public void subtract(Vector3f vector3f) {
        float[] fArr = this.points;
        fArr[0] = fArr[0] - vector3f.points[0];
        float[] fArr2 = this.points;
        fArr2[1] = fArr2[1] - vector3f.points[1];
        float[] fArr3 = this.points;
        fArr3[2] = fArr3[2] - vector3f.points[2];
    }

    public float[] toArray() {
        return this.points;
    }

    public String toString() {
        return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
    }

    /* renamed from: x */
    public float mo9363x() {
        return this.points[0];
    }

    /* renamed from: x */
    public void mo9364x(float f) {
        this.points[0] = f;
    }

    /* renamed from: y */
    public float mo9365y() {
        return this.points[1];
    }

    /* renamed from: y */
    public void mo9366y(float f) {
        this.points[1] = f;
    }

    /* renamed from: z */
    public float mo9367z() {
        return this.points[2];
    }

    /* renamed from: z */
    public void mo9368z(float f) {
        this.points[2] = f;
    }
}
