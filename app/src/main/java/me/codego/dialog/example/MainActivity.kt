package me.codego.dialog.example

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import me.codego.dialog.iOSStyle
import splitties.alertdialog.appcompat.alertDialog
import splitties.toast.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMessageDialog(view: View) {
        alertDialog {
            iOSStyle()
            setCancelable(false)
            setMessage("App recommends that you update to the latest version.")
            positiveButton("Update") {}
        }.show()
    }

    fun showTitleDialog(view: View) {
        val inputView = EditText(this).apply {
            setHint("please input your name")
        }
        alertDialog {
            iOSStyle(inputView)
            setCancelable(false)
            setTitle("Update Available")
            positiveButton("Update") {
                toast(inputView.text.toString())
            }
        }.show()
    }

    fun showTitleMessageDialog(view: View) {
        alertDialog {
            iOSStyle()
            setCancelable(false)
            setTitle("Update Available")
            setMessage("App recommends that you update to the latest version.")
            positiveButton("Update") {}
        }.show()
    }

    fun showTipDialog(view: View) {
        alertDialog {
            iOSStyle()
            setCancelable(false)
            setTitle("Update Available")
            setMessage("App recommends that you update to the latest version.")
            positiveButton("Update") {}
        }.show()
    }

    fun showConfirmDialog(view: View) {
        alertDialog {
            iOSStyle()
            setCancelable(false)
            setTitle("Update Available")
            setMessage("App recommends that you update to the latest version.")
            positiveButton("Update") {}
            negativeButton("Not Now") {}
        }.show()
    }
}

inline fun AlertDialog.Builder.positiveButton(
    text: CharSequence,
    crossinline handler: (dialog: DialogInterface) -> Unit,
) {
    setPositiveButton(text) { dialog: DialogInterface, _: Int -> handler(dialog) }
}

inline fun AlertDialog.Builder.negativeButton(
    text: CharSequence,
    crossinline handler: (dialog: DialogInterface) -> Unit,
) {
    setNegativeButton(text) { dialog: DialogInterface, _: Int -> handler(dialog) }
}