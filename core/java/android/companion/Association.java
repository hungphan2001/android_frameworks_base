/*
 * Copyright (C) 2019 The Android Open Source Project
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
package android.companion;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.annotation.UserIdInt;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.DataClass;

import java.util.Objects;

/**
 * A record indicating that a device with a given address was confirmed by the user to be
 * associated to a given companion app
 *
 * @hide
 */
@DataClass(genEqualsHashCode = true, genToString = true, genHiddenConstructor = true)
public final class Association implements Parcelable {

    private final @UserIdInt int mUserId;
    private final @NonNull String mDeviceMacAddress;
    private final @NonNull String mPackageName;
    private final @Nullable String mDeviceProfile;
    private final boolean mNotifyOnDeviceNearby;

    /** @hide */
    public int getUserId() {
        return mUserId;
    }



    // Code below generated by codegen v1.0.22.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/companion/Association.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new Association.
     *
     * @hide
     */
    @DataClass.Generated.Member
    public Association(
            @UserIdInt int userId,
            @NonNull String deviceMacAddress,
            @NonNull String packageName,
            @Nullable String deviceProfile,
            boolean notifyOnDeviceNearby) {
        this.mUserId = userId;
        com.android.internal.util.AnnotationValidations.validate(
                UserIdInt.class, null, mUserId);
        this.mDeviceMacAddress = deviceMacAddress;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mDeviceMacAddress);
        this.mPackageName = packageName;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mDeviceProfile = deviceProfile;
        this.mNotifyOnDeviceNearby = notifyOnDeviceNearby;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public @NonNull String getDeviceMacAddress() {
        return mDeviceMacAddress;
    }

    @DataClass.Generated.Member
    public @NonNull String getPackageName() {
        return mPackageName;
    }

    @DataClass.Generated.Member
    public @Nullable String getDeviceProfile() {
        return mDeviceProfile;
    }

    @DataClass.Generated.Member
    public boolean isNotifyOnDeviceNearby() {
        return mNotifyOnDeviceNearby;
    }

    @Override
    @DataClass.Generated.Member
    public String toString() {
        // You can override field toString logic by defining methods like:
        // String fieldNameToString() { ... }

        return "Association { " +
                "userId = " + mUserId + ", " +
                "deviceMacAddress = " + mDeviceMacAddress + ", " +
                "packageName = " + mPackageName + ", " +
                "deviceProfile = " + mDeviceProfile + ", " +
                "notifyOnDeviceNearby = " + mNotifyOnDeviceNearby +
        " }";
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(Association other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        Association that = (Association) o;
        //noinspection PointlessBooleanExpression
        return true
                && mUserId == that.mUserId
                && Objects.equals(mDeviceMacAddress, that.mDeviceMacAddress)
                && Objects.equals(mPackageName, that.mPackageName)
                && Objects.equals(mDeviceProfile, that.mDeviceProfile)
                && mNotifyOnDeviceNearby == that.mNotifyOnDeviceNearby;
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + mUserId;
        _hash = 31 * _hash + Objects.hashCode(mDeviceMacAddress);
        _hash = 31 * _hash + Objects.hashCode(mPackageName);
        _hash = 31 * _hash + Objects.hashCode(mDeviceProfile);
        _hash = 31 * _hash + Boolean.hashCode(mNotifyOnDeviceNearby);
        return _hash;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mNotifyOnDeviceNearby) flg |= 0x10;
        if (mDeviceProfile != null) flg |= 0x8;
        dest.writeByte(flg);
        dest.writeInt(mUserId);
        dest.writeString(mDeviceMacAddress);
        dest.writeString(mPackageName);
        if (mDeviceProfile != null) dest.writeString(mDeviceProfile);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ Association(@NonNull Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        boolean notifyOnDeviceNearby = (flg & 0x10) != 0;
        int userId = in.readInt();
        String deviceMacAddress = in.readString();
        String packageName = in.readString();
        String deviceProfile = (flg & 0x8) == 0 ? null : in.readString();

        this.mUserId = userId;
        com.android.internal.util.AnnotationValidations.validate(
                UserIdInt.class, null, mUserId);
        this.mDeviceMacAddress = deviceMacAddress;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mDeviceMacAddress);
        this.mPackageName = packageName;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mDeviceProfile = deviceProfile;
        this.mNotifyOnDeviceNearby = notifyOnDeviceNearby;

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<Association> CREATOR
            = new Parcelable.Creator<Association>() {
        @Override
        public Association[] newArray(int size) {
            return new Association[size];
        }

        @Override
        public Association createFromParcel(@NonNull Parcel in) {
            return new Association(in);
        }
    };

    @DataClass.Generated(
            time = 1610482674799L,
            codegenVersion = "1.0.22",
            sourceFile = "frameworks/base/core/java/android/companion/Association.java",
            inputSignatures = "private final @android.annotation.UserIdInt int mUserId\nprivate final @android.annotation.NonNull java.lang.String mDeviceMacAddress\nprivate final @android.annotation.NonNull java.lang.String mPackageName\nprivate final @android.annotation.Nullable java.lang.String mDeviceProfile\nprivate final  boolean mNotifyOnDeviceNearby\npublic  int getUserId()\nclass Association extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass(genEqualsHashCode=true, genToString=true, genHiddenConstructor=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
