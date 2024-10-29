package expo.modules.customdynamicview

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

class CustomDynamicView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private val root: LinearLayout

    init {
        root = LinearLayout(context)
        root.orientation = VERTICAL
        root.layoutParams =
            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(root)

        val button = Button(context)
        button.layoutParams = ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        button.setOnClickListener {
            addCustomView()
        }

        button.text = "native button"

        root.addView(button)
    }

    fun addCustomView() {
        this.post {
            val view = CustomView(context)
            root.addView(view)
        }
    }
}

class CustomView(context: Context) : View(context) {
    init {
        this.layoutParams = ViewGroup.LayoutParams(200, 200)
        this.setBackgroundColor(Color.RED)
    }
}
