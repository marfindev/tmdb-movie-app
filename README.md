
# TMDB Movie App

A feature-rich Android application for browsing movies and TV shows using data from **The Movie Database (TMDB)** API. The app supports viewing movie and TV details, trailers, favorites, and notifications for new content.

---

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Dependencies](#dependencies)
- [File Structure](#file-structure)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

---

## Introduction

The **TMDB Movie App** is designed to let users explore movies and TV shows from **The Movie Database (TMDB)**. Users can view trending content, search for movies/TV shows, and save their favorites for quick access. The app also supports notifications for upcoming releases.

---

## Features

- Browse popular and trending **movies** and **TV shows**.
- View detailed information, including trailers.
- Search for movies and TV shows.
- Add movies and TV shows to a **favorites** list.
- Receive **release notifications** and daily reminders.
- Supports **offline access** to saved favorites using **Realm Database**.
- Designed with **fragments** for intuitive navigation.

---

## Installation

1. Clone this repository or download the project ZIP.
    ```bash
    git clone <repository-url>
    ```
2. Open the project in **Android Studio**.
3. Sync Gradle files.
4. Obtain an API Key from [TMDB](https://www.themoviedb.org/documentation/api).
5. Add your TMDB API Key to the appropriate configuration file (see **Configuration** section).
6. Run the project on an emulator or physical device.

---

## Usage

- Launch the app to see trending content.
- Use the **bottom navigation bar** to switch between movies, TV shows, and favorites.
- Search for content using the search bar.
- Tap on a movie or TV show to view detailed information.
- Add content to your **favorites** for quick access later.
- Set up daily notifications for recommendations.

---

## Configuration

To use this project, you need an **API Key** from TMDB.

1. Visit [TMDB API](https://www.themoviedb.org/documentation/api) to generate a key.
2. In your project, create a file (if it doesn’t already exist) in:
    ```
    app/src/main/java/com/marfin/movietmdbapp/networking/ApiEndpoint.java
    ```
3. Add your API key like so:
    ```java
    public static final String API_KEY = "your_tmdb_api_key_here";
    ```

---

## Dependencies

This project relies on the following libraries:

- **Retrofit** - For network requests.
- **Gson** - For JSON parsing.
- **Glide** - For image loading.
- **Realm** - For offline storage of favorites.
- **AndroidX** - Core Android libraries.
- **Material Components** - UI design.
- **WorkManager** - For scheduling notifications.

Dependencies are declared in:

```
app/build.gradle
```

---

## File Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/marfin/movietmdbapp/
│   │   │   ├── activity/          # Activities (Main, Detail)
│   │   │   ├── adapter/           # Adapters for RecyclerViews
│   │   │   ├── fragment/          # Fragments for each section
│   │   │   ├── model/             # Data models
│   │   │   ├── networking/        # API interface
│   │   │   ├── notification/      # Notification receivers
│   │   │   ├── preference/        # Shared preferences handling
│   │   │   ├── realm/             # Realm database helpers
│   │   │   ├── utils/             # Utility classes
│   │   ├── res/                    # Layouts, Drawables, Values
│   │   ├── AndroidManifest.xml    # Application manifest
│   ├── test/                       # Unit tests
│   ├── androidTest/                # Instrumented tests
├── build.gradle                    # Project-level Gradle config
└── settings.gradle                 # Project settings
```

---

## Examples

### Sample Main Screen
- Movie posters shown in a vertical list.
- TV shows in horizontal carousels.
- Search bar for finding content.
- Bottom navigation for switching tabs.

### Detailed Movie View
- Poster, description, rating, release date.
- List of available trailers.
- Favorite button to save the movie locally.

---

## Troubleshooting

### Common Issues

- **API Key Missing**: Ensure you have added your TMDB API Key correctly.
- **Gradle Sync Errors**: Run `File > Sync Project with Gradle Files`.
- **Images Not Loading**: Ensure device has internet access and image URLs are correct.

### Debugging Tips

- Use **Logcat** to check for API errors.
- Verify that the TMDB API key has sufficient permissions.
- Check **AndroidManifest.xml** for necessary permissions (INTERNET, etc.).

---

## Contributors

- **Marfin (Project Author)**

Contributions are welcome! Feel free to fork the repository and submit pull requests.

---

## License

This project is licensed under the MIT License.

```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so.
```

---

## Notes

- This app requires **Android 5.0 (Lollipop)** or newer.
- Ensure proper API quota when using TMDB API.

