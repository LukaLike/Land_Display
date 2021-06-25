# Land Display - Google Maps 

## Features
- Gets feature data (list of features with points) from the provided API
- Displays feature data on Google Maps as Polygons
- Displays every point as a marker with specific color according to accuracy:
  - 0…1.5 → good accuracy (green); 
  - 1.5…2.0 → average accuracy (yellow); 
  - 2.0… and up → poor accuracy (orange). 
  
**Feature** - a plot of land that has a list of points, which can be displayed on a map. 

## Used technologies
- Android Studio IDE
- Kotlin programming language
- MVVM architecture
- REST client Retrofit
- Android Jetpack

## Design

| Home Screen  | Initial Display | Zoomed In Display  | 
| -----------  | --------------- | ------------------ | 
| ![alt text](https://github.com/LukaLike/demo/blob/master/land_display_1.png?raw=true)   | ![alt text](https://github.com/LukaLike/demo/blob/master/land_display_2.png?raw=true)  |  ![alt text](https://github.com/LukaLike/demo/blob/master/land_display_3.png?raw=true)  |
