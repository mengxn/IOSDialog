package me.codego.dialog

import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.cardview.widget.CardView
import splitties.views.inflate

/**
 * 启用iOS样式
 *
 * @param customView 附加自定义内容
 */
fun AlertDialog.Builder.iOSStyle(customView: View? = null) {
    val field = AlertDialog.Builder::class.java.getDeclaredField("mTheme")
    field.isAccessible = true
    field.setInt(this, R.style.DialogStyle)

    if (customView != null) {
        val contentView = ContextThemeWrapper(context, R.style.DialogStyle).inflate<CardView>(R.layout.dialog_ios)
        contentView.findViewById<FrameLayout>(R.id.slotLayout)?.addView(customView)
        setView(contentView)
    } else {
        setView(R.layout.dialog_ios)
    }
}