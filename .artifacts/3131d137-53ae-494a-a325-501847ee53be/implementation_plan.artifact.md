# Implementation Plan - Redesign Album List Screen

The goal is to redesign the `AlbumListScreen` to match the provided SoundCloud-like UI, which features a custom top bar and horizontally scrollable album categories.

## Proposed Changes

### [Component Name]

#### [MODIFY] [MusicData.kt](file:///D:/ĐH_MỞ/lap_trinh_thiet_bi_di_dong/ung_dung_nghe_nhac_de04/app/src/main/java/com/de04/ung_dung_nghe_nhac/MusicData.kt)
- Update `Album` data class to include `imageUrl`.
- Add `Category` data class: `id: String`, `name: String`, `albums: List<Album>`.
- Update `MockData` to include categories and sample image URLs.

#### [MODIFY] [MusicScreens.kt](file:///D:/ĐH_MỞ/lap_trinh_thiet_bi_di_dong/ung_dung_nghe_nhac_de04/app/src/main/java/com/de04/ung_dung_nghe_nhac/MusicScreens.kt)
- Implement `SoundCloudTopBar` with menu icon, title, and profile/search icons.
- Create `AlbumItem` component:
    - Square image using `AsyncImage` (Coil).
    - Title text (truncated if too long).
    - Artist text.
- Create `CategoryRow` component:
    - Section header with "Title >>".
    - Horizontal `LazyRow` of `AlbumItem`s.
- Update `AlbumListScreen` to use a `LazyColumn` to display multiple `CategoryRow`s.

## Verification Plan

### Automated Tests
- Build and run the app to verify the UI.

### Manual Verification
- Check the layout of `AlbumListScreen` against the provided image.
- Verify that horizontal scrolling works within categories.
- Verify that clicking an album still navigates to the song list.
