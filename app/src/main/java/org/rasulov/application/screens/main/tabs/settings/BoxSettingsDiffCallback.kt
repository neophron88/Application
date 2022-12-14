package org.rasulov.application.screens.main.tabs.settings

import androidx.recyclerview.widget.DiffUtil
import org.rasulov.application.model.boxes.core.entities.BoxSetting

class BoxSettingsDiffCallback(
    private val oldList: List<BoxSetting>,
    private val newList: List<BoxSetting>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].box.id == newList[newItemPosition].box.id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}