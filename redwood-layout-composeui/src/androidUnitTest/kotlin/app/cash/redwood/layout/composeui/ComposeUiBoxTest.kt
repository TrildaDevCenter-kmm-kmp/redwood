/*
 * Copyright (C) 2024 Square, Inc.
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
package app.cash.redwood.layout.composeui

import androidx.compose.runtime.Composable
import app.cash.burst.Burst
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import app.cash.redwood.layout.AbstractBoxTest
import app.cash.redwood.layout.widget.Box
import app.cash.redwood.snapshot.testing.ComposeSnapshotter
import app.cash.redwood.snapshot.testing.ComposeUiTestWidgetFactory
import com.android.resources.LayoutDirection
import org.junit.Rule

@Burst
class ComposeUiBoxTest(
  layoutDirection: LayoutDirection = LayoutDirection.LTR,
) : AbstractBoxTest<@Composable () -> Unit>() {

  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = DeviceConfig.PIXEL_6.copy(layoutDirection = layoutDirection),
    theme = "android:Theme.Material.Light.NoActionBar",
    supportsRtl = true,
  )

  override val widgetFactory = ComposeUiTestWidgetFactory

  override fun box(): Box<@Composable () -> Unit> = ComposeUiBox(0x88000000.toInt())
    .apply { applyDefaults() }

  override fun snapshotter(widget: @Composable () -> Unit) = ComposeSnapshotter(paparazzi, widget)
}
