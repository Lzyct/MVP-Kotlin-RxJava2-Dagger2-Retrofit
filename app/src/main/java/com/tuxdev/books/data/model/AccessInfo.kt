package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class AccessInfo(
        val accessViewStatus: String? = null,
        val country: String? = null,
        val viewability: String? = null,
        val pdf: Pdf? = null,
        val webReaderLink: String? = null,
        val epub: Epub? = null,
        val publicDomain: Boolean? = null,
        val quoteSharingAllowed: Boolean? = null,
        val embeddable: Boolean? = null,
        val textToSpeechPermission: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readParcelable<Pdf>(Pdf::class.java.classLoader),
            source.readString(),
            source.readParcelable<Epub>(Epub::class.java.classLoader),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(accessViewStatus)
        writeString(country)
        writeString(viewability)
        writeParcelable(pdf, 0)
        writeString(webReaderLink)
        writeParcelable(epub, 0)
        writeValue(publicDomain)
        writeValue(quoteSharingAllowed)
        writeValue(embeddable)
        writeString(textToSpeechPermission)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AccessInfo> = object : Parcelable.Creator<AccessInfo> {
            override fun createFromParcel(source: Parcel): AccessInfo = AccessInfo(source)
            override fun newArray(size: Int): Array<AccessInfo?> = arrayOfNulls(size)
        }
    }
}
