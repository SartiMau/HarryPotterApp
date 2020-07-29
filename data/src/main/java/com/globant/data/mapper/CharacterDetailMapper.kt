package com.globant.data.mapper

import com.globant.data.service.response.CharacterDetailResponse
import com.globant.domain.entity.CharacterDetail

class CharacterDetailMapper : BaseMapper<CharacterDetailResponse, CharacterDetail> {
    override fun transform(type: CharacterDetailResponse): CharacterDetail = type.run {
        CharacterDetail(
            id,
            name,
            role?.let { it } ?: UNKNOWN,
            house,
            ministryOfMagic?.let { getStringValueForDetail(it) } ?: UNKNOWN,
            orderOfThePhoenix?.let { getStringValueForDetail(it) } ?: UNKNOWN,
            dumbledoresArmy?.let { getStringValueForDetail(dumbledoresArmy) } ?: UNKNOWN,
            deathEater?.let { getStringValueForDetail(it) } ?: UNKNOWN,
            bloodStatus?.let { it } ?: UNKNOWN,
            species?.let { it } ?: UNKNOWN
        )
    }

    private fun getStringValueForDetail(detail: Boolean): String = if (detail?.let { it }) YES else NO

    companion object {
        private const val YES = "Yes"
        private const val NO = "No"
        private const val UNKNOWN = "Unknown"
    }
}
