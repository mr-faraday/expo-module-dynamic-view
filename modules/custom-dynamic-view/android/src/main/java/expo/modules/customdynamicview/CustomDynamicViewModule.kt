package expo.modules.customdynamicview

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class CustomDynamicViewModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("CustomDynamicView")

    View(CustomDynamicView::class) {
      AsyncFunction("addView") { view: CustomDynamicView ->
        view.addView()
      }
    }
  }
}
