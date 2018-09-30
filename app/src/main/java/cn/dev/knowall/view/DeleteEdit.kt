package cn.dev.knowall.view

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText


class DeleteEdit : AppCompatEditText {
    private var unable: Drawable? = null
    private var enable: Drawable? = null
    private var mContext: Context? = null

    constructor(context: Context) : super(context) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        init()
    }


    private fun init() {
        unable = mContext!!.resources
                .getDrawable(android.R.drawable.screen_background_light_transparent)
        enable = mContext!!.resources.getDrawable(android.R.drawable.ic_delete)
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                setDrawable()
            }
        })
        setDrawable()
    }

    private fun setDrawable() {
        if (length() < 1) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, unable, null)
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, enable, null)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (enable != null && event.action == MotionEvent.ACTION_UP) {
            val eventX = event.rawX.toInt()
            val eventY = event.rawY.toInt()
            Log.e(TAG, "X坐标:$eventX\tY坐标:$eventY")
            val rect = Rect()
            getGlobalVisibleRect(rect)
            rect.left = rect.right - 50
            if (rect.contains(eventX, eventY)) {
                setText("")
            }
        }
        return super.onTouchEvent(event)
    }
}
