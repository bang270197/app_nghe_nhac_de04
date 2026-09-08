# Fix Gradle Sync Error: "Cannot add extension with name 'kotlin'"

The error indicates a conflict when applying the Kotlin Android plugin, likely caused by redundant or conflicting plugin registrations. Additionally, the project is using experimental/future versions of AGP (9.4.0) and Gradle (9.6.0) which may be unstable or contain typos.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///D:/ĐH_MỞ/lap_trinh_thiet_bi_di_dong/ung_dung_nghe_nhac_de04/gradle/libs.versions.toml)
- Downgrade `agp` from `9.4.0` to a stable version (e.g., `8.7.2`).

#### [MODIFY] [gradle-wrapper.properties](file:///D:/ĐH_MỞ/lap_trinh_thiet_bi_di_dong/ung_dung_nghe_nhac_de04/gradle/wrapper/gradle-wrapper.properties)
- Downgrade Gradle from `9.6.0` to a stable version (e.g., `8.10.2`).

#### [MODIFY] [app/build.gradle.kts](file:///D:/ĐH_MỞ/lap_trinh_thiet_bi_di_dong/ung_dung_nghe_nhac_de04/app/build.gradle.kts)
- Ensure the `plugins` block is correctly ordered.
- If the error persists, I will try to apply the Kotlin plugins without the `alias` syntax to rule out version resolution issues, or adjust the `compose-compiler` application.

## Verification Plan

### Automated Tests
- Run `gradle_sync` to verify the project syncs successfully.
- Run `gradle_build("app:assembleDebug")` to ensure the project compiles.
