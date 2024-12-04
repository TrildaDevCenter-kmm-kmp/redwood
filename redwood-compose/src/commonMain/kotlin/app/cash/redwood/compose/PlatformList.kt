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
package app.cash.redwood.compose

internal expect class PlatformList<T>

internal expect inline fun <T> platformListOf(): PlatformList<T>

internal expect inline val <T> PlatformList<T>.size: Int

internal expect inline operator fun <T> PlatformList<T>.get(index: Int): T

internal expect inline fun <T> PlatformList<T>.add(index: Int, element: T)

internal expect inline fun <T> PlatformList<T>.remove(index: Int, count: Int)

internal expect fun <T> PlatformList<T>.move(from: Int, to: Int, count: Int)