package com.gsixacademy.android.personrevisited.adapters

import com.gsixacademy.android.personrevisited.models.CastModel

sealed class CastOnClickEvent {
    data class onCastClickEvet(val cast:CastModel):CastOnClickEvent()

}
