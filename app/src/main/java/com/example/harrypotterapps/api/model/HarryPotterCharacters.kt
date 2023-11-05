package com.example.harrypotterapps.api.model


import com.google.gson.annotations.SerializedName

class MovieCharacters : ArrayList<MovieCharacters.HarryPotterCharacters>(){
    data class HarryPotterCharacters(
        @SerializedName("actor")
        var actor: String?, // Daniel Radcliffe
        @SerializedName("alive")
        var alive: Boolean?, // true
        @SerializedName("alternate_actors")
        var alternateActors: List<String?>?,
        @SerializedName("alternate_names")
        var alternateNames: List<String?>?,
        @SerializedName("ancestry")
        var ancestry: String?, // half-blood
        @SerializedName("dateOfBirth")
        var dateOfBirth: String?, // 31-07-1980
        @SerializedName("eyeColour")
        var eyeColour: String?, // green
        @SerializedName("gender")
        var gender: String?, // male
        @SerializedName("hairColour")
        var hairColour: String?, // black
        @SerializedName("hogwartsStaff")
        var hogwartsStaff: Boolean?, // false
        @SerializedName("hogwartsStudent")
        var hogwartsStudent: Boolean?, // true
        @SerializedName("house")
        var house: String?, // Gryffindor
        @SerializedName("id")
        var id: String?, // 9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8
        @SerializedName("image")
        var image: String?, // https://ik.imagekit.io/hpapi/harry.jpg
        @SerializedName("name")
        var name: String?, // Harry Potter
        @SerializedName("patronus")
        var patronus: String?, // stag
        @SerializedName("species")
        var species: String?, // human
        @SerializedName("wand")
        var wand: Wand?,
        @SerializedName("wizard")
        var wizard: Boolean?, // true
        @SerializedName("yearOfBirth")
        var yearOfBirth: Int? // 1980
    ) {
        data class Wand(
            @SerializedName("core")
            var core: String?, // phoenix feather
            @SerializedName("length")
            var length: Double?, // 10.75
            @SerializedName("wood")
            var wood: String? // holly
        )
    }
}