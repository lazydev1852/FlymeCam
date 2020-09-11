package com.android.volley;

import android.content.Intent;

/* renamed from: com.android.volley.a */
public class AuthFailureError extends VolleyError {

    /* renamed from: b */
    private Intent f288b;

    public AuthFailureError() {
    }

    public AuthFailureError(NetworkResponse kVar) {
        super(kVar);
    }

    public String getMessage() {
        if (this.f288b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
