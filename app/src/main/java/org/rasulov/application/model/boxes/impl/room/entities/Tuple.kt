package org.rasulov.application.model.boxes.impl.room.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import org.rasulov.application.model.accounts.impl.room.entities.AccountDBEntity


data class SettingsTuple(
    @ColumnInfo(name = "is_active") val isActive: Boolean
)

data class BoxAndSettingsTuple(
    @Embedded val boxDBEntity: BoxDBEntity,
    @Embedded val settingDBEntity: AccountBoxSettingsEntity?
)



data class SettingWithEntitiesTuple(

    @Embedded val settingDBEntity: AccountBoxSettingsEntity,

    @Relation(
        parentColumn = "account_id",
        entityColumn = "id"
    )
    val accountDBEntity: AccountDBEntity,

    @Relation(
        parentColumn = "box_id",
        entityColumn = "id"
    )
    val boxDBEntity: BoxDBEntity
)


data class AccountAndEditedBoxesTuple(

    @Embedded val accountDBEntity: AccountDBEntity,

    @Relation(

        parentColumn = "id",
        entityColumn = "id",

        associateBy = Junction(
            value = AccountBoxSettingsEntity::class,
            parentColumn = "account_id",
            entityColumn = "box_id"
        )
    )
    val boxes: List<BoxDBEntity>

)
