/*
 * Copyright (C) 2021 Square, Inc.
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
package example.schema

import app.cash.treehouse.schema.Children
import app.cash.treehouse.schema.Property
import app.cash.treehouse.schema.Schema
import app.cash.treehouse.schema.Widget

@Schema(
  [
    Toolbar::class,
    ScrollableColumn::class,
    Item::class,
    Column::class,
  ]
)
interface Todo

@Widget(1)
data class Toolbar(
  @Property(1) val title: String,
)

@Widget(2)
data class ScrollableColumn(
  @Children(1) val children: List<Any>,
)

@Widget(3)
data class Item(
  @Property(1) val content: String,
  @Property(2) val onComplete: () -> Unit,
)

@Widget(4)
data class Column(
  @Children(1) val children: List<Any>,
)