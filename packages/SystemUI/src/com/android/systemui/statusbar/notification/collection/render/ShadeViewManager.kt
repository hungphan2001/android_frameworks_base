/*
 * Copyright (C) 2020 The Android Open Source Project
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

package com.android.systemui.statusbar.notification.collection.render

import com.android.systemui.statusbar.notification.collection.GroupEntry
import com.android.systemui.statusbar.notification.collection.ListEntry
import com.android.systemui.statusbar.notification.collection.NotificationEntry
import com.android.systemui.statusbar.notification.collection.ShadeListBuilder
import com.android.systemui.statusbar.notification.stack.NotificationListContainer
import java.lang.RuntimeException
import javax.inject.Inject

/**
 * Responsible for building and applying the "shade node spec": the list (tree) of things that
 * currently populate the notification shade.
 */
class ShadeViewManager constructor(
    listContainer: NotificationListContainer,
    logger: ShadeViewDifferLogger,
    private val viewBarn: NotifViewBarn
) {
    private val rootController = RootNodeController(listContainer)
    private val viewDiffer = ShadeViewDiffer(rootController, logger)

    fun attach(listBuilder: ShadeListBuilder) {
        listBuilder.setOnRenderListListener(::onNewNotifTree)
    }

    private fun onNewNotifTree(tree: List<ListEntry>) {
        viewDiffer.applySpec(buildTree(tree))
    }

    private fun buildTree(notifList: List<ListEntry>): NodeSpec {
        val root = NodeSpecImpl(null, rootController)

        for (entry in notifList) {
            // TODO: Add section header logic here
            root.children.add(buildNotifNode(entry, root))
        }

        return root
    }

    private fun buildNotifNode(entry: ListEntry, parent: NodeSpec): NodeSpec {
        return when (entry) {
            is NotificationEntry -> {
                NodeSpecImpl(parent, viewBarn.requireView(entry))
            }
            is GroupEntry -> {
                val groupNode = NodeSpecImpl(
                        parent,
                        viewBarn.requireView(checkNotNull(entry.summary)))

                for (childEntry in entry.children) {
                    groupNode.children.add(buildNotifNode(childEntry, groupNode))
                }

                groupNode
            }
            else -> {
                throw RuntimeException("Unexpected entry: $entry")
            }
        }
    }
}

class ShadeViewManagerFactory @Inject constructor(
    private val logger: ShadeViewDifferLogger,
    private val viewBarn: NotifViewBarn
) {
    fun create(listContainer: NotificationListContainer): ShadeViewManager {
        return ShadeViewManager(listContainer, logger, viewBarn)
    }
}
