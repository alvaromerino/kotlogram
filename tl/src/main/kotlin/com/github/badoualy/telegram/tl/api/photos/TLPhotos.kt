package com.github.badoualy.telegram.tl.api.photos

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsPhoto
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photos.photos#8dca6aa5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhotos() : TLAbsPhotos() {
    override var photos: TLObjectVector<TLAbsPhoto> = TLObjectVector()

    override var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "photos.photos#8dca6aa5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(photos: TLObjectVector<TLAbsPhoto>, users: TLObjectVector<TLAbsUser>) : this() {
        this.photos = photos
        this.users = users
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(photos)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        photos = readTLVector<TLAbsPhoto>()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += photos.computeSerializedSize()
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhotos) return false
        if (other === this) return true

        return photos == other.photos
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8dca6aa5.toInt()
    }
}