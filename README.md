#🎵 Spotify KMP App (Kotlin Multiplatform)

A modern Spotify-inspired music streaming application built using Kotlin Multiplatform (KMP).
The app provides cross-platform support for Android and Web, featuring online streaming, smart sorting, offline detection, and a smooth mini-player experience.

---

## 🎧 App Preview

<p align="center">
  <img src="Screenshots/mockup.jpg" width="300" alt="App Mockup"/>
</p>

---

## Features

🎶 Online music streaming via Jamendo API
🔀 Sort tracks by Name or Duration
▶️ Mini player with play/pause controls
⚡ Smooth UI with Material Design on Android and Compose UI on Web
🧠 Clean architecture using MVVM/MVI
🌐 Cross-platform support using Kotlin Multiplatform

---

## Tech Stack

| Category       | Technology Used                         |
| -------------- | --------------------------------------- |
| Language       | Kotlin Multiplatform (KMP)              |
| UI             | Jetpack Compose (Android), Compose Web  |
| Architecture   | MVVM / MVI                              |
| Networking     | Ktor HTTP Client                        |
| Media Playback | Android MediaPlayer / Web Audio API     |
| Image Loading  | Glide (Android) / KMP-compatible loader |
| State Handling | Kotlin Flow / LiveData                  |
| Connectivity   | ConnectivityManager / Browser API       |

---

## How to Run the Project

1. **Clone the repository**
   ```bash
   git clone https://github.com/vivek84835V/Spotify-KMP-App.git

2. Sync **Gradle** files
3. Run the app on an **Emulator** or **Physical Device**

> ⚠️ **Note:** Active internet connection is required for streaming music.


**Web**

Navigate to the web module

Build the project using Gradle:

./gradlew :web:browserProductionWebpack


Open web/build/distributions/index.html in your browser

⚠️ Note: Active internet connection is required for streaming music.
---

## Developer

**Vivek Shimpi**  
Android Developer | Kotlin | MVVM  

- GitHub: [@vivek84835V](https://github.com/vivek84835V)
- LinkedIn: *https://www.linkedin.com/in/vivek-shimpi-/*

## ⭐ Support
Enjoyed this project?  
Give it a ⭐ on GitHub — it really helps and motivates me to keep creating awesome Android applications 🚀

