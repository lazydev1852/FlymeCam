package flyme.support.p093v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import flyme.support.p093v7.appcompat.R;

/* renamed from: flyme.support.v7.widget.MultiChoiceView */
public class MultiChoiceView extends ControlTitleBar {
    public MultiChoiceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MultiChoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzMultiChoiceViewStyle);
    }

    public MultiChoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTitle(getResources().getString(R.string.mz_action_bar_multi_choice_title, new Object[]{0}));
    }

    public void setOnSelectAllItemClickListener(View.OnClickListener onClickListener) {
        super.setOnPositiveItemClickListener(onClickListener);
    }

    public void setOnCloseItemClickListener(View.OnClickListener onClickListener) {
        super.setOnNegativeItemClickListener(onClickListener);
    }

    public View getCloseItemView() {
        return super.getNegativeItemView();
    }

    public View getSelectAllView() {
        return super.getPositiveItemView();
    }
}
