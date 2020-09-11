package com.baidu.p020ar.arplay.representation;

import android.util.Log;

/* renamed from: com.baidu.ar.arplay.representation.Number3D */
public class Number3D {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    private static Number3D _temp = new Number3D();

    /* renamed from: x */
    public float f895x;

    /* renamed from: y */
    public float f896y;

    /* renamed from: z */
    public float f897z;

    /* renamed from: com.baidu.ar.arplay.representation.Number3D$Axis */
    public enum Axis {
        X,
        Y,
        Z
    }

    public Number3D() {
        this.f895x = 0.0f;
        this.f896y = 0.0f;
        this.f897z = 0.0f;
    }

    public Number3D(double d, double d2, double d3) {
        this.f895x = (float) d;
        this.f896y = (float) d2;
        this.f897z = (float) d3;
    }

    public Number3D(float f, float f2, float f3) {
        this.f895x = f;
        this.f896y = f2;
        this.f897z = f3;
    }

    public Number3D(Number3D number3D) {
        this.f895x = number3D.f895x;
        this.f896y = number3D.f896y;
        this.f897z = number3D.f897z;
    }

    public Number3D(String[] strArr) {
        if (strArr.length != 3) {
            Log.e(Number3D.class.getSimpleName(), "Number3D should be initialized with 3 values");
        }
        try {
            this.f895x = Float.parseFloat(strArr[0]);
            this.f896y = Float.parseFloat(strArr[1]);
            this.f897z = Float.parseFloat(strArr[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static Number3D add(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.f895x + number3D2.f895x, number3D.f896y + number3D2.f896y, number3D.f897z + number3D2.f897z);
    }

    public static Number3D cross(Number3D number3D, Number3D number3D2) {
        return new Number3D((number3D2.f896y * number3D.f897z) - (number3D2.f897z * number3D.f896y), (number3D2.f897z * number3D.f895x) - (number3D2.f895x * number3D.f897z), (number3D2.f895x * number3D.f896y) - (number3D2.f896y * number3D.f895x));
    }

    public static float dot(Number3D number3D, Number3D number3D2) {
        return (number3D.f895x * number3D2.f895x) + (number3D.f896y * number3D2.f896y) + (number3D.f897z * number3D2.f897z);
    }

    public static Number3D getAxisVector(Axis axis) {
        Number3D number3D = new Number3D();
        switch (axis) {
            case X:
                number3D.setAll(1.0f, 0.0f, 0.0f);
                break;
            case Y:
                number3D.setAll(0.0f, 1.0f, 0.0f);
                break;
            case Z:
                number3D.setAll(0.0f, 0.0f, 1.0f);
                break;
        }
        return number3D;
    }

    public static Number3D getUpVector() {
        return new Number3D(0.0f, 1.0f, 0.0f);
    }

    public static Number3D lerp(Number3D number3D, Number3D number3D2, float f) {
        Number3D number3D3 = new Number3D();
        number3D3.f895x = number3D.f895x + ((number3D2.f895x - number3D.f895x) * f);
        number3D3.f896y = number3D.f896y + ((number3D2.f896y - number3D.f896y) * f);
        number3D3.f897z = number3D.f897z + ((number3D2.f897z - number3D.f897z) * f);
        return number3D3;
    }

    public static Number3D multiply(Number3D number3D, float f) {
        return new Number3D(number3D.f895x * f, number3D.f896y * f, number3D.f897z * f);
    }

    public static Number3D multiply(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.f895x * number3D2.f895x, number3D.f896y * number3D2.f896y, number3D.f897z * number3D2.f897z);
    }

    public static Number3D subtract(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.f895x - number3D2.f895x, number3D.f896y - number3D2.f896y, number3D.f897z - number3D2.f897z);
    }

    public Number3D add(float f, float f2, float f3) {
        this.f895x += f;
        this.f896y += f2;
        this.f897z += f3;
        return this;
    }

    public Number3D add(Number3D number3D) {
        this.f895x += number3D.f895x;
        this.f896y += number3D.f896y;
        this.f897z += number3D.f897z;
        return this;
    }

    public Number3D clone() {
        return new Number3D(this.f895x, this.f896y, this.f897z);
    }

    public Number3D cross(Number3D number3D) {
        _temp.setAllFrom(this);
        this.f895x = (number3D.f896y * _temp.f897z) - (number3D.f897z * _temp.f896y);
        this.f896y = (number3D.f897z * _temp.f895x) - (number3D.f895x * _temp.f897z);
        this.f897z = (number3D.f895x * _temp.f896y) - (number3D.f896y * _temp.f895x);
        return this;
    }

    public float distanceTo(Number3D number3D) {
        return (float) Math.sqrt((double) (((this.f895x - number3D.f895x) * (this.f895x - number3D.f895x)) + ((this.f896y - number3D.f896y) * (this.f896y - number3D.f896y)) + ((this.f897z - number3D.f897z) * (this.f897z - number3D.f897z))));
    }

    public float dot(Number3D number3D) {
        return (this.f895x * number3D.f895x) + (this.f896y * number3D.f896y) + (this.f897z * number3D.f897z);
    }

    public boolean equals(Object obj) {
        Number3D number3D = obj instanceof Number3D ? (Number3D) obj : null;
        return number3D != null && number3D.f895x == this.f895x && number3D.f896y == this.f896y && number3D.f897z == this.f897z;
    }

    public String formatIntToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) this.f895x);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.f896y);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.f897z);
        return stringBuffer.toString();
    }

    public Quaternion getRotationTo(Number3D number3D) {
        Quaternion quaternion = new Quaternion();
        normalize();
        number3D.normalize();
        float dot = dot(this, number3D);
        if (dot >= 1.0f) {
            quaternion.loadIdentityQuat();
        }
        if (dot < -0.999999f) {
            Number3D cross = cross(getAxisVector(Axis.X), this);
            if (cross.length() == 0.0f) {
                cross = cross(getAxisVector(Axis.Y), this);
            }
            cross.normalize();
            quaternion.setAxisAngle(new Vector3f(cross.f895x, cross.f896y, cross.f897z), (float) Math.toDegrees(3.141592653589793d));
        } else {
            double sqrt = Math.sqrt((double) ((dot + 1.0f) * 2.0f));
            double d = 1.0d / sqrt;
            Number3D cross2 = cross(this, number3D);
            quaternion.points[0] = (float) (((double) cross2.f895x) * d);
            quaternion.points[1] = (float) (((double) cross2.f896y) * d);
            quaternion.points[2] = (float) (((double) cross2.f897z) * d);
            quaternion.points[3] = (float) (sqrt * 0.5d);
            quaternion.normalize();
        }
        return quaternion;
    }

    public Number3D inverse() {
        return new Number3D(-this.f895x, -this.f896y, -this.f897z);
    }

    public float length() {
        return (float) Math.sqrt((double) ((this.f895x * this.f895x) + (this.f896y * this.f896y) + (this.f897z * this.f897z)));
    }

    public void lerpSelf(Number3D number3D, Number3D number3D2, float f) {
        this.f895x = number3D.f895x + ((number3D2.f895x - number3D.f895x) * f);
        this.f896y = number3D.f896y + ((number3D2.f896y - number3D.f896y) * f);
        this.f897z = number3D.f897z + ((number3D2.f897z - number3D.f897z) * f);
    }

    public Number3D multiply(float f) {
        this.f895x *= f;
        this.f896y *= f;
        this.f897z *= f;
        return this;
    }

    public void multiply(Number3D number3D) {
        this.f895x *= number3D.f895x;
        this.f896y *= number3D.f896y;
        this.f897z *= number3D.f897z;
    }

    public void multiply(float[] fArr) {
        float f = this.f895x;
        float f2 = this.f896y;
        float f3 = this.f897z;
        this.f895x = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        this.f896y = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        this.f897z = (f * fArr[2]) + (f2 * fArr[6]) + (f3 * fArr[10]) + fArr[14];
    }

    public float normalize() {
        double sqrt = Math.sqrt((double) ((this.f895x * this.f895x) + (this.f896y * this.f896y) + (this.f897z * this.f897z)));
        if (!(sqrt == 0.0d || sqrt == 1.0d)) {
            sqrt = 1.0d / sqrt;
            this.f895x = (float) (((double) this.f895x) * sqrt);
            this.f896y = (float) (((double) this.f896y) * sqrt);
            this.f897z = (float) (((double) this.f897z) * sqrt);
        }
        return (float) sqrt;
    }

    public void project(float[] fArr) {
        if (fArr != null && fArr.length > 15) {
            float f = (this.f895x * fArr[3]) + (this.f896y * fArr[7]) + (this.f897z * fArr[11]) + fArr[15];
            setAll(((((this.f895x * fArr[0]) + (this.f896y * fArr[4])) + (this.f897z * fArr[8])) + fArr[12]) / f, ((((this.f895x * fArr[1]) + (this.f896y * fArr[5])) + (this.f897z * fArr[9])) + fArr[13]) / f, ((((this.f895x * fArr[2]) + (this.f896y * fArr[6])) + (this.f897z * fArr[10])) + fArr[14]) / f);
        }
    }

    public void rotateX(float f) {
        double d = (double) f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.f895x, this.f896y, this.f897z);
        this.f896y = (float) ((((double) _temp.f896y) * cos) - (((double) _temp.f897z) * sin));
        this.f897z = (float) ((((double) _temp.f896y) * sin) + (((double) _temp.f897z) * cos));
    }

    public void rotateY(float f) {
        double d = (double) f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.f895x, this.f896y, this.f897z);
        this.f895x = (float) ((((double) _temp.f895x) * cos) + (((double) _temp.f897z) * sin));
        this.f897z = (float) ((((double) _temp.f895x) * (-sin)) + (((double) _temp.f897z) * cos));
    }

    public void rotateZ(float f) {
        double d = (double) f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.f895x, this.f896y, this.f897z);
        this.f895x = (float) ((((double) _temp.f895x) * cos) - (((double) _temp.f896y) * sin));
        this.f896y = (float) ((((double) _temp.f895x) * sin) + (((double) _temp.f896y) * cos));
    }

    public void setAll(double d, double d2, double d3) {
        this.f895x = (float) d;
        this.f896y = (float) d2;
        this.f897z = (float) d3;
    }

    public void setAll(float f, float f2, float f3) {
        this.f895x = f;
        this.f896y = f2;
        this.f897z = f3;
    }

    public void setAllFrom(Number3D number3D) {
        this.f895x = number3D.f895x;
        this.f896y = number3D.f896y;
        this.f897z = number3D.f897z;
    }

    public Number3D subtract(Number3D number3D) {
        this.f895x -= number3D.f895x;
        this.f896y -= number3D.f896y;
        this.f897z -= number3D.f897z;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f895x);
        stringBuffer.append(", ");
        stringBuffer.append(this.f896y);
        stringBuffer.append(", ");
        stringBuffer.append(this.f897z);
        return stringBuffer.toString();
    }
}
