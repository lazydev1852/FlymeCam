package com.baidu.p020ar.arplay.representation;

/* renamed from: com.baidu.ar.arplay.representation.Quaternion */
public class Quaternion extends Vector4f {
    private static final long serialVersionUID = -7148812599404359073L;
    Quaternion bufferQuaternion;
    private boolean dirty = false;
    private Matrixf4x4 matrix = new Matrixf4x4();

    public Quaternion() {
        loadIdentityQuat();
    }

    private void convertQuatToMatrix() {
        float f = this.points[0];
        float f2 = this.points[1];
        float f3 = this.points[2];
        float f4 = this.points[3];
        float f5 = f2 * f2 * 2.0f;
        float f6 = f3 * f3 * 2.0f;
        this.matrix.setX0((1.0f - f5) - f6);
        float f7 = f * f2 * 2.0f;
        float f8 = f4 * f3 * 2.0f;
        this.matrix.setX1(f7 + f8);
        float f9 = f * f3 * 2.0f;
        float f10 = f4 * f2 * 2.0f;
        this.matrix.setX2(f9 - f10);
        this.matrix.setX3(0.0f);
        this.matrix.setY0(f7 - f8);
        float f11 = 1.0f - ((f * f) * 2.0f);
        this.matrix.setY1(f11 - f6);
        float f12 = f2 * f3 * 2.0f;
        float f13 = f4 * f * 2.0f;
        this.matrix.setY2(f12 + f13);
        this.matrix.setY3(0.0f);
        this.matrix.setZ0(f9 + f10);
        this.matrix.setZ1(f12 - f13);
        this.matrix.setZ2(f11 - f5);
        this.matrix.setZ3(0.0f);
        this.matrix.setW0(0.0f);
        this.matrix.setW1(0.0f);
        this.matrix.setW2(0.0f);
        this.matrix.setW3(1.0f);
    }

    private void generateQuaternionFromMatrix() {
        float f;
        float f2;
        float f3;
        float f4;
        float sqrt;
        float f5;
        float f6;
        float[] matrix2 = this.matrix.getMatrix();
        int[] iArr = this.matrix.size() == 16 ? this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN16_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN16_WITH3X3 : this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN9_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN9_WITH3X3;
        boolean z = false;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        if (this.matrix.size() >= 9) {
            float f7 = matrix2[i] + matrix2[i5] + matrix2[i9];
            if (f7 > 0.0f) {
                float sqrt2 = ((float) Math.sqrt(((double) f7) + 1.0d)) * 2.0f;
                f4 = (matrix2[i4] - matrix2[i2]) / sqrt2;
                f = (matrix2[i3] - matrix2[i7]) / sqrt2;
                f2 = (matrix2[i8] - matrix2[i6]) / sqrt2;
                f3 = 0.25f * sqrt2;
            } else {
                boolean z2 = matrix2[i] > matrix2[i5];
                if (matrix2[i] > matrix2[i9]) {
                    z = true;
                }
                if (z && z2) {
                    sqrt = ((float) Math.sqrt(((((double) matrix2[i]) + 1.0d) - ((double) matrix2[i5])) - ((double) matrix2[i9]))) * 2.0f;
                    f3 = (matrix2[i8] - matrix2[i6]) / sqrt;
                    f2 = sqrt * 0.25f;
                    f = (matrix2[i2] + matrix2[i4]) / sqrt;
                    f5 = matrix2[i3];
                    f6 = matrix2[i7];
                } else if (matrix2[i5] > matrix2[i9]) {
                    sqrt = ((float) Math.sqrt(((((double) matrix2[i5]) + 1.0d) - ((double) matrix2[i])) - ((double) matrix2[i9]))) * 2.0f;
                    f3 = (matrix2[i3] - matrix2[i7]) / sqrt;
                    f2 = (matrix2[i2] + matrix2[i4]) / sqrt;
                    f = sqrt * 0.25f;
                    f5 = matrix2[i6];
                    f6 = matrix2[i8];
                } else {
                    float sqrt3 = ((float) Math.sqrt(((((double) matrix2[i9]) + 1.0d) - ((double) matrix2[i])) - ((double) matrix2[i5]))) * 2.0f;
                    f3 = (matrix2[i4] - matrix2[i2]) / sqrt3;
                    f2 = (matrix2[i3] + matrix2[i7]) / sqrt3;
                    f = (matrix2[i6] + matrix2[i8]) / sqrt3;
                    f4 = sqrt3 * 0.25f;
                }
                f4 = (f5 + f6) / sqrt;
            }
            setX(f2);
            setY(f);
            setZ(f4);
            setW(f3);
        }
    }

    public void addQuat(Quaternion quaternion) {
        this.dirty = true;
        addQuat(quaternion, this);
    }

    public void addQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() + quaternion.getX());
        quaternion2.setY(getY() + quaternion.getY());
        quaternion2.setZ(getZ() + quaternion.getZ());
        quaternion2.setW(getW() + quaternion.getW());
    }

    public Quaternion clone() {
        Quaternion quaternion = new Quaternion();
        quaternion.copyVec4(this);
        return quaternion;
    }

    public void copyFromVec3(Vector3f vector3f, float f) {
        copyFromV3f(vector3f, f);
    }

    public Matrixf4x4 getMatrix4x4() {
        if (this.dirty) {
            convertQuatToMatrix();
            this.dirty = false;
        }
        return this.matrix;
    }

    public void loadIdentityQuat() {
        this.dirty = true;
        setX(0.0f);
        setY(0.0f);
        setZ(0.0f);
        setW(1.0f);
    }

    public void multiplyByQuat(Quaternion quaternion) {
        if (this.bufferQuaternion == null) {
            this.bufferQuaternion = new Quaternion();
        }
        this.dirty = true;
        this.bufferQuaternion.copyVec4(this);
        multiplyByQuat(quaternion, this.bufferQuaternion);
        copyVec4(this.bufferQuaternion);
    }

    public void multiplyByQuat(Quaternion quaternion, Quaternion quaternion2) {
        Vector4f vector4f = new Vector4f();
        if (quaternion != quaternion2) {
            quaternion2.points[3] = (((this.points[3] * quaternion.points[3]) - (this.points[0] * quaternion.points[0])) - (this.points[1] * quaternion.points[1])) - (this.points[2] * quaternion.points[2]);
            quaternion2.points[0] = (((this.points[3] * quaternion.points[0]) + (this.points[0] * quaternion.points[3])) + (this.points[1] * quaternion.points[2])) - (this.points[2] * quaternion.points[1]);
            quaternion2.points[1] = (((this.points[3] * quaternion.points[1]) + (this.points[1] * quaternion.points[3])) + (this.points[2] * quaternion.points[0])) - (this.points[0] * quaternion.points[2]);
            quaternion2.points[2] = (((this.points[3] * quaternion.points[2]) + (this.points[2] * quaternion.points[3])) + (this.points[0] * quaternion.points[1])) - (this.points[1] * quaternion.points[0]);
            return;
        }
        vector4f.points[0] = quaternion.points[0];
        vector4f.points[1] = quaternion.points[1];
        vector4f.points[2] = quaternion.points[2];
        vector4f.points[3] = quaternion.points[3];
        quaternion2.points[3] = (((this.points[3] * vector4f.points[3]) - (this.points[0] * vector4f.points[0])) - (this.points[1] * vector4f.points[1])) - (this.points[2] * vector4f.points[2]);
        quaternion2.points[0] = (((this.points[3] * vector4f.points[0]) + (this.points[0] * vector4f.points[3])) + (this.points[1] * vector4f.points[2])) - (this.points[2] * vector4f.points[1]);
        quaternion2.points[1] = (((this.points[3] * vector4f.points[1]) + (this.points[1] * vector4f.points[3])) + (this.points[2] * vector4f.points[0])) - (this.points[0] * vector4f.points[2]);
        quaternion2.points[2] = (((this.points[3] * vector4f.points[2]) + (this.points[2] * vector4f.points[3])) + (this.points[0] * vector4f.points[1])) - (this.points[1] * vector4f.points[0]);
    }

    public void normalise() {
        this.dirty = true;
        float sqrt = (float) Math.sqrt((double) ((this.points[3] * this.points[3]) + (this.points[0] * this.points[0]) + (this.points[1] * this.points[1]) + (this.points[2] * this.points[2])));
        this.points[3] = this.points[3] / sqrt;
        this.points[0] = this.points[0] / sqrt;
        this.points[1] = this.points[1] / sqrt;
        this.points[2] = this.points[2] / sqrt;
    }

    public void normalize() {
        normalise();
    }

    public void set(Quaternion quaternion) {
        this.dirty = true;
        copyVec4(quaternion);
    }

    public void setAxisAngle(Vector3f vector3f, float f) {
        double d = (double) (f / 2.0f);
        float sin = (float) Math.sin(Math.toRadians(d));
        setX(vector3f.getX() * sin);
        setY(vector3f.getY() * sin);
        setZ(vector3f.getZ() * sin);
        setW((float) Math.cos(Math.toRadians(d)));
        this.dirty = true;
    }

    public void setAxisAngleRad(Vector3f vector3f, double d) {
        setAxisAngle(vector3f, (float) Math.toDegrees(d));
    }

    public void setColumnMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(true);
        generateQuaternionFromMatrix();
    }

    public void setEulerAngle(float f, float f2, float f3) {
        double radians = Math.toRadians((double) f3);
        double radians2 = Math.toRadians((double) f2);
        double radians3 = Math.toRadians((double) f);
        double d = radians / 2.0d;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        double d2 = radians2 / 2.0d;
        double cos2 = Math.cos(d2);
        double sin2 = Math.sin(d2);
        double d3 = radians3 / 2.0d;
        double cos3 = Math.cos(d3);
        double sin3 = Math.sin(d3);
        double d4 = cos * cos2;
        double d5 = sin * sin2;
        setW((float) ((d4 * cos3) - (d5 * sin3)));
        setX((float) ((d4 * sin3) + (d5 * cos3)));
        double d6 = sin * cos2;
        double d7 = cos * sin2;
        setY((float) ((d6 * cos3) + (d7 * sin3)));
        setZ((float) ((d7 * cos3) - (d6 * sin3)));
        this.dirty = true;
    }

    public void setRowMajor(float[] fArr) {
        this.matrix.setMatrix(fArr);
        this.matrix.setColumnMajor(false);
        generateQuaternionFromMatrix();
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f) {
        float dotProduct = dotProduct(quaternion);
        if (dotProduct < 0.0f) {
            Quaternion quaternion3 = new Quaternion();
            dotProduct = -dotProduct;
            quaternion3.points[0] = -quaternion.points[0];
            quaternion3.points[1] = -quaternion.points[1];
            quaternion3.points[2] = -quaternion.points[2];
            quaternion3.points[3] = -quaternion.points[3];
            quaternion = quaternion3;
        }
        if (((double) Math.abs(dotProduct)) >= 1.0d) {
            quaternion2.points[0] = this.points[0];
            quaternion2.points[1] = this.points[1];
            quaternion2.points[2] = this.points[2];
            quaternion2.points[3] = this.points[3];
            return;
        }
        double sqrt = Math.sqrt(1.0d - ((double) (dotProduct * dotProduct)));
        double acos = Math.acos((double) dotProduct);
        double sin = Math.sin(((double) (1.0f - f)) * acos) / sqrt;
        double sin2 = Math.sin(((double) f) * acos) / sqrt;
        quaternion2.points[3] = (float) ((((double) this.points[3]) * sin) + (((double) quaternion.points[3]) * sin2));
        quaternion2.points[0] = (float) ((((double) this.points[0]) * sin) + (((double) quaternion.points[0]) * sin2));
        quaternion2.points[1] = (float) ((((double) this.points[1]) * sin) + (((double) quaternion.points[1]) * sin2));
        quaternion2.points[2] = (float) ((((double) this.points[2]) * sin) + (((double) quaternion.points[2]) * sin2));
    }

    public void subQuat(Quaternion quaternion) {
        this.dirty = true;
        subQuat(quaternion, this);
    }

    public void subQuat(Quaternion quaternion, Quaternion quaternion2) {
        quaternion2.setX(getX() - quaternion.getX());
        quaternion2.setY(getY() - quaternion.getY());
        quaternion2.setZ(getZ() - quaternion.getZ());
        quaternion2.setW(getW() - quaternion.getW());
    }

    public void toAxisAngle(Vector4f vector4f) {
        float f;
        float f2;
        float f3;
        if (getW() > 1.0f) {
            normalise();
        }
        float degrees = ((float) Math.toDegrees(Math.acos((double) getW()))) * 2.0f;
        float sqrt = (float) Math.sqrt((double) (1.0f - (getW() * getW())));
        if (((double) sqrt) < 0.001d) {
            f3 = this.points[0];
            f2 = this.points[1];
            f = this.points[2];
        } else {
            float f4 = this.points[0] / sqrt;
            float f5 = this.points[1] / sqrt;
            f = this.points[2] / sqrt;
            f3 = f4;
            f2 = f5;
        }
        vector4f.points[0] = f3;
        vector4f.points[1] = f2;
        vector4f.points[2] = f;
        vector4f.points[3] = degrees;
    }

    public double[] toEulerAngles() {
        return new double[]{Math.atan2((double) (((this.points[1] * 2.0f) * getW()) - ((this.points[0] * 2.0f) * this.points[2])), (double) ((1.0f - ((this.points[1] * this.points[1]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f))), Math.asin((double) ((this.points[0] * 2.0f * this.points[1]) + (this.points[2] * 2.0f * getW()))), Math.atan2((double) (((this.points[0] * 2.0f) * getW()) - ((this.points[1] * 2.0f) * this.points[2])), (double) ((1.0f - ((this.points[0] * this.points[0]) * 2.0f)) - ((this.points[2] * this.points[2]) * 2.0f)))};
    }

    public String toString() {
        return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
    }
}
