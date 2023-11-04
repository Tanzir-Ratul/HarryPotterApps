package com.example.harrypotterapps.api.model


import com.google.gson.annotations.SerializedName


data class MovieCharDetails(
    @SerializedName("actor")
    var actor: String?, // Emma Watson
    @SerializedName("alive")
    var alive: Boolean?, // true
    @SerializedName("alternate_actors")
    var alternateActors: List<Any?>?,
    @SerializedName("alternate_names")
    var alternateNames: List<Any?>?,
    @SerializedName("ancestry")
    var ancestry: String?, // muggleborn
    @SerializedName("dateOfBirth")
    var dateOfBirth: String?, // 19-09-1979
    @SerializedName("eyeColour")
    var eyeColour: String?, // brown
    @SerializedName("gender")
    var gender: String?, // female
    @SerializedName("hairColour")
    var hairColour: String?, // brown
    @SerializedName("hogwartsStaff")
    var hogwartsStaff: Boolean?, // false
    @SerializedName("hogwartsStudent")
    var hogwartsStudent: Boolean?, // true
    @SerializedName("house")
    var house: String?, // Gryffindor
    @SerializedName("id")
    var id: String?, // 4c7e6819-a91a-45b2-a454-f931e4a7cce3
    @SerializedName("image")
    var image: String?, // https://ik.imagekit.io/hpapi/hermione.jpeg
    @SerializedName("name")
    var name: String?, // Hermione Granger
    @SerializedName("patronus")
    var patronus: String?, // otter
    @SerializedName("species")
    var species: String?, // human
    @SerializedName("wand")
    var wand: Wand?,
    @SerializedName("wizard")
    var wizard: Boolean?, // true
    @SerializedName("yearOfBirth")
    var yearOfBirth: Int? // 1979
) {
    data class Wand(
        @SerializedName("core")
        var core: String?, // dragon heartstring
        @SerializedName("length")
        var length: Double?, // 10.75
        @SerializedName("wood")
        var wood: String? // vine
    )
}
