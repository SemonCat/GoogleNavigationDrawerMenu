package org.arasthel.googlenavdrawermenu.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.TextView;

/**
 * Created by Arasthel on 15/04/14.
 */
public class CheckedTextView extends TextView implements Checkable {

    private boolean checked = false;

    private int text_color_selected = 0xff3f51b5;

    private int src_text_color = Color.BLACK;

    public CheckedTextView(Context context) {
        super(context);
        src_text_color = getCurrentTextColor();
    }

    public CheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        src_text_color = getCurrentTextColor();

    }

    public CheckedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        src_text_color = getCurrentTextColor();
    }


    @Override
    public void setChecked(boolean b) {
        checked = b;

        if (isChecked()){
            setTextColor(text_color_selected);
        }else{
            setTextColor(src_text_color);
        }

    }

    public int getCheckedTextColor() {
        return text_color_selected;
    }

    public void setCheckedTextColor(int text_color_selected) {
        this.text_color_selected = text_color_selected;
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
