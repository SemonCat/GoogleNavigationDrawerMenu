package org.arasthel.googlenavdrawermenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

import org.arasthel.googlenavdrawermenu.R;

/**
 * Created by Arasthel on 15/04/14.
 */
public class CheckableImageView extends ImageView implements Checkable {

    private boolean checked = false;
    private static final int[] CHECKED_STATE_SET = { android.R.attr.state_checked };

    private int icon_tint = 0x00000000;

    private int icon_tint_selected = 0xff3f51b5;

    public CheckableImageView(Context context) {
        super(context);
    }

    public CheckableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckableImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked())
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        return drawableState;
    }

    @Override
    public void setChecked(boolean b) {
        checked = b;
        refreshDrawableState();

        setColorFilter(isChecked() ?
                icon_tint_selected :
                icon_tint);
    }

    public int getIconTintColor() {
        return icon_tint;
    }

    public void setIconTintColor(int icon_tint) {
        this.icon_tint = icon_tint;
    }

    public int getIconTintColorChecked() {
        return icon_tint_selected;
    }

    public void setIconTintColorChecked(int icon_tint_selected) {
        this.icon_tint_selected = icon_tint_selected;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}
