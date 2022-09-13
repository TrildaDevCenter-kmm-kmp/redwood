/*
 * Copyright (C) 2022 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package app.cash.redwood.treehouse

import app.cash.redwood.protocol.widget.DiffConsumingWidget
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.cValue
import platform.CoreGraphics.CGRectZero
import platform.UIKit.UIView
import platform.UIKit.setFrame
import platform.UIKit.subviews

public class TreehouseUIKitView<T : Any>(
  private val treehouseApp: TreehouseApp<T>,
) : TreehouseView<T> {
  public val view: UIView = RootUiView()
  private var content: TreehouseView.Content<T>? = null

  // TODO(jwilson): track when this view is detached from screen
  override val boundContent: TreehouseView.Content<T>? = content

  override val protocolDisplayRoot: DiffConsumingWidget<*> =
    ProtocolDisplayRoot(view)

  public fun setContent(content: TreehouseView.Content<T>) {
    treehouseApp.dispatchers.checkMain()
    this.content = content
    treehouseApp.onContentChanged(this)
  }
}

private class RootUiView() : UIView(cValue { CGRectZero }) {
  @ObjCAction fun layoutSubviews() {
    subviews.forEach {
      (it as UIView).setFrame(bounds)
    }
  }
}
