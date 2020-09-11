package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogManager {

    /* renamed from: a */
    public static ErrorDialogFragmentFactory<?> f19102a;

    public static class SupportManagerFragment extends Fragment {

        /* renamed from: a */
        private EventBus f19104a;

        /* renamed from: b */
        private boolean f19105b;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f19104a = ErrorDialogManager.f19102a.f19107a.mo28003a();
            this.f19104a.mo27974a((Object) this);
            this.f19105b = true;
        }

        public void onResume() {
            super.onResume();
            if (this.f19105b) {
                this.f19105b = false;
                return;
            }
            this.f19104a = ErrorDialogManager.f19102a.f19107a.mo28003a();
            this.f19104a.mo27974a((Object) this);
        }

        public void onPause() {
            this.f19104a.mo27979c(this);
            super.onPause();
        }
    }

    @TargetApi(11)
    public static class HoneycombManagerFragment extends android.app.Fragment {

        /* renamed from: a */
        private EventBus f19103a;

        public void onResume() {
            super.onResume();
            this.f19103a = ErrorDialogManager.f19102a.f19107a.mo28003a();
            this.f19103a.mo27974a((Object) this);
        }

        public void onPause() {
            this.f19103a.mo27979c(this);
            super.onPause();
        }
    }
}
