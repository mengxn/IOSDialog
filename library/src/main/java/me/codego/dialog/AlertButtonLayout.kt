package me.codego.dialog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.graphics.withTranslation
import androidx.core.view.isVisible
import splitties.dimensions.dip

/**
 *
 * @author mengxn
 * @date 2022/5/9
 */
class AlertButtonLayout(context: Context, attributeSet: AttributeSet? = null) : LinearLayout(context, attributeSet) {

    private val mPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            this.color = Color.parseColor("#C6C6C6")
            this.strokeWidth = dip(0.5f)
        }
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        if (canvas == null) {
            return
        }
        if (orientation == HORIZONTAL && childCount > 0) {
            canvas.withTranslation(y = mPaint.strokeWidth / 2) {
                drawLine(0f, 0f, measuredWidth.toFloat(), 0f, mPaint)
            }

            for (i in 1 until childCount) {
                val child = getChildAt(i)
                if (child.isVisible) {
                    canvas.withTranslation(x = child.left.toFloat()) {
                        drawLine(0f, 0f, 0f, measuredHeight.toFloat(), mPaint)
                    }
                }
            }
        }
    }
}