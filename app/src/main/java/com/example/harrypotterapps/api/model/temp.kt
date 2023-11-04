package com.example.harrypotterapps.api.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

class temp : ArrayList<temp.tempItem>(){
    @Keep
    data class tempItem(
        @SerializedName("actor")
        var actor: String?, // Tom Felton
        @SerializedName("alive")
        var alive: Boolean?, // true
        @SerializedName("alternate_actors")
        var alternateActors: List<Any?>?,
        @SerializedName("alternate_names")
        var alternateNames: List<Any?>?,
        @SerializedName("ancestry")
        var ancestry: String?, // pure-blood
        @SerializedName("dateOfBirth")
        var dateOfBirth: String?, // 05-06-1980
        @SerializedName("eyeColour")
        var eyeColour: String?, // grey
        @SerializedName("gender")
        var gender: String?, // male
        @SerializedName("hairColour")
        var hairColour: String?, // blonde
        @SerializedName("hogwartsStaff")
        var hogwartsStaff: Boolean?, // false
        @SerializedName("hogwartsStudent")
        var hogwartsStudent: Boolean?, // true
        @SerializedName("house")
        var house: String?, // Slytherin
        @SerializedName("id")
        var id: String?, // af95bd8a-dfae-45bb-bc69-533860d34129
        @SerializedName("image")
        var image: String?, // https://ik.imagekit.io/hpapi/draco.jpg
        @SerializedName("name")
        var name: String?, // Draco Malfoy
        @SerializedName("patronus")
        var patronus: String?,
        @SerializedName("species")
        var species: String?, // human
        @SerializedName("wand")
        var wand: Wand?,
        @SerializedName("wizard")
        var wizard: Boolean?, // true
        @SerializedName("yearOfBirth")
        var yearOfBirth: Int? // 1980
    ) {
        @Keep
        data class Wand(
            @SerializedName("core")
            var core: String?, // unicorn tail-hair
            @SerializedName("length")
            var length: Int?, // 10
            @SerializedName("wood")
            var wood: String? // hawthorn
        )
    }
}