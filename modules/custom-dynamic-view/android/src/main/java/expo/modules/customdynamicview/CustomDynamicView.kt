package expo.modules.customdynamicview

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.views.ExpoView

class CustomDynamicView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private val root: LinearLayout

    init {
        root = LinearLayout(context)
        root.layoutParams =
            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(root)
    }

    fun addView() {
        this.post {
            val view = View(context)
            view.layoutParams = ViewGroup.LayoutParams(400, 400)
            view.setBackgroundColor(Color.RED)
            root.addView(view)
        }
    }
}

