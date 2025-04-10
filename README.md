# Nutri-Score Based Nutrient Assessment and Recommendation Application

<div align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Nutri-score-A.svg/1200px-Nutri-score-A.svg.png" width="120px" alt="NutriScore Logo">
  <br>
  <p>
    <a href="#overview">Overview</a> •
    <a href="#key-features">Key Features</a> •
    <a href="#system-architecture">Architecture</a> •
    <a href="#technology-stack">Tech Stack</a> •
    <a href="#installation">Installation</a> •
    <a href="#usage">Usage</a> •
    <a href="#project-status">Status</a>
  </p>
</div>

## Overview

The Nutri-Score Based Nutrient Assessment and Recommendation Application is designed to empower users to make healthier food choices by transforming complex nutritional information into an intuitive health score. The application integrates advanced barcode scanning and Optical Character Recognition (OCR) technologies to capture nutritional data from food products, retrieves detailed product information from the Open Food Facts API, and processes this data using a Nutri-Score–like algorithm.

The result is a clear, color-coded health score along with personalized recommendations for healthier alternatives, enabling users to quickly understand and compare the nutritional quality of food products while shopping.

## Key Features

- **Multiple Authentication Methods**
  - Secure user registration and login via Firebase Authentication
  - Guest mode for users who prefer to browse without an account

- **Advanced Data Acquisition**
  - Barcode scanning using Google ML Kit for quick product identification
  - OCR technology to extract nutritional information directly from packaging when barcodes aren't available
  - Manual input option as a fallback

- **Comprehensive Nutritional Evaluation**
  - Nutri-Score calculation based on European standards
  - Detailed breakdown of nutritional values (calories, fats, sugars, salt, etc.)
  - Historical tracking of scanned products

- **Smart Recommendations**
  - Personalized suggestions for healthier alternatives
  - Category-based product comparisons
  - Offline access to previously scanned product information

- **User-Friendly Interface**
  - Intuitive, clean design with color-coded indicators
  - Clear visual representation of nutritional quality
  - Seamless navigation between scanning, evaluation, and recommendations

## System Architecture

The application follows a clean, modular architecture designed for scalability, maintainability, and robust performance:

<div align="center">
  <img src="https://github.com/username/Nutri-Score-App/raw/main/docs/component_diagram.png" alt="Component Architecture Diagram" width="700px">
</div>

### Key Components:

1. **UI Layer (Activities & Fragments)**
   - Handles user interactions and visual presentation
   - Implements Material Design principles for a consistent experience

2. **Presentation Layer (ViewModels)**
   - Manages UI-related data and state
   - Implements the MVVM architectural pattern

3. **Domain Layer**
   - **Business Logic**: Core algorithms including Nutri-Score calculation
   - **Authentication**: User identity management via Firebase
   - **Scanning**: Barcode and OCR processing components

4. **Data Layer**
   - Manages data persistence and retrieval
   - Implements Repository pattern for data access abstraction

5. **External Services**
   - Open Food Facts API integration
   - Firebase services (Authentication, Firestore)
   - Google ML Kit for barcode scanning and OCR

### Data Flow

The application implements an event-driven architecture where components communicate through a central event bus, ensuring loose coupling and improved testability. When a user scans a product:

1. The scanning component captures the barcode or nutritional information
2. Data is sent to the appropriate repository
3. The repository accesses the Open Food Facts API if needed
4. The Nutri-Score calculator processes the nutritional data
5. The recommendation engine identifies healthier alternatives
6. Results are displayed to the user via the UI layer

## Technology Stack

- **Development Language**: Kotlin
- **Minimum SDK**: Android 8.0 (API 26)
- **Target SDK**: Android 15 (API 35)
- **Architecture**: MVVM with Repository pattern
- **UI Framework**: Android Jetpack Components
  - Navigation Component
  - Data Binding
  - ViewModel
  - LiveData
- **Database**:
  - SQLite (local storage)
  - Firebase Firestore (cloud storage)
- **Authentication**: Firebase Authentication
- **Networking**: Retrofit with OkHttp
- **Image Processing**:
  - Google ML Kit for barcode scanning
  - Google ML Kit Text Recognition for OCR
- **JSON Parsing**: Kotlinx Serialization
- **Testing**: JUnit, Espresso

## Package Structure

```
com.nutriscore
├── MainActivity
├── AppController
├── ui
│   ├── fragments
│   │   ├── LoginFragment
│   │   ├── RegistrationFragment
│   │   ├── HomeFragment
│   │   ├── ProductDetailFragment
│   │   └── ScanFragment
│   └── navigation
│       └── NavigationController
├── presentation
│   ├── ProductViewModel
│   ├── ScanViewModel
│   └── AuthViewModel
├── auth
│   ├── FirebaseAuthHandler
│   └── AuthRepository
├── scanner
│   ├── BarcodeScanner
│   └── OCRProcessor
├── api
│   ├── OpenFoodFactsService
│   └── APIClient
├── model
│   ├── Product
│   ├── NutritionalData
│   └── User
├── algorithm
│   └── NutriScoreCalculator
├── recommendation
│   ├── RecommendationEngine
│   └── RecommendationRepository
├── data
│   ├── RepositoryManager
│   └── repository
│       ├── ProductRepository
│       └── UserRepository
├── database
│   ├── SQLiteHelper
│   └── FirebaseDatabaseHandler
└── utils
    ├── Constants
    ├── UtilityMethods
    └── EventBus
```

## Installation

### Prerequisites
- Android Studio Iguana | 2023.2.1 or higher
- JDK 11 or higher
- An Android device or emulator running Android 8.0+
- Firebase account for authentication features

### For Developers

1. Clone the repository:
   ```bash
   git clone https://github.com/username/Nutri-Score-Based-Nutrient-Assessment-and-Recommendation-Application.git
   ```

2. Open the project in Android Studio

3. Configure Firebase:
   - Create a Firebase project in the [Firebase Console](https://console.firebase.google.com/)
   - Add an Android app to your Firebase project
   - Download the `google-services.json` file and place it in the app/ directory
   - Enable Authentication (Email/Password) in Firebase Console

4. Build the project:
   ```bash
   ./gradlew build
   ```

5. Run the application on an emulator or physical device.

### For Users

1. Download the APK from the [Releases](https://github.com/username/Nutri-Score-Based-Nutrient-Assessment-and-Recommendation-Application/releases) page
2. Enable installation from unknown sources in your device settings
3. Install and launch the application

## Usage

### User Registration and Authentication

1. Launch the application
2. Choose to sign up, sign in, or continue as a guest
3. For account creation, provide email, password, and user information

### Scanning Products

1. Navigate to the scan screen
2. Point your camera at a product barcode
3. If barcode scanning fails, use OCR mode to capture nutritional information
4. View the retrieved product information and calculated Nutri-Score

### Viewing Recommendations

1. After scanning a product, navigate to the recommendations tab
2. Browse through suggested healthier alternatives
3. Compare nutritional information between products

### Offline Access

- Previously scanned products are available offline
- History of scanned items can be accessed anytime

## Screenshots

<div align="center">
  <div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 10px;">
    <img src="https://github.com/username/Nutri-Score-App/raw/main/docs/screenshots/welcome.png" width="200px" alt="Welcome Screen">
    <img src="https://github.com/username/Nutri-Score-App/raw/main/docs/screenshots/login.png" width="200px" alt="Login Screen">
    <img src="https://github.com/username/Nutri-Score-App/raw/main/docs/screenshots/scanning.png" width="200px" alt="Scanning Interface">
    <img src="https://github.com/username/Nutri-Score-App/raw/main/docs/screenshots/result.png" width="200px" alt="Results Screen">
  </div>
</div>

## API Integration

The application integrates with the Open Food Facts API to retrieve comprehensive nutritional information for food products:

- **Endpoint**: `https://world.openfoodfacts.org/data`
- **Documentation**: [Open Food Facts API Documentation](https://world.openfoodfacts.org/data)
- **Authentication**: Not required (public API)
- **Rate Limiting**: Please refer to the official API documentation

### API Usage Example

```kotlin
// Sample code for retrieving product data by barcode
val retrofit = Retrofit.Builder()
    .baseUrl("https://world.openfoodfacts.org/api/v0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(OpenFoodFactsService::class.java)
val call = service.getProductByBarcode(barcode)
```

## Database Schema

The application utilizes both SQLite (local) and Firebase (cloud) databases with the following schema:

### Local Database (SQLite)

```
Product
├── barcode (PRIMARY KEY): TEXT
├── product_name: TEXT
└── nutri_score: TEXT

Recommendation
├── id (PRIMARY KEY): INTEGER
├── original_product_barcode (FOREIGN KEY): TEXT
├── recommended_product_barcode (FOREIGN KEY): TEXT
├── recommendation_reason: TEXT
└── similarity_score: REAL
```

### Cloud Database (Firebase)

- **Users Collection**: Stores user profiles and preferences
- **ScanHistory Collection**: Records user scan history for analytics and personalization

## Project Status

Current Version: 1.0.0 (Development)

The project is currently in active development with core features implemented. The following components are fully functional:

- ✅ User Authentication (Sign Up, Sign In, Guest Mode)
- ✅ UI Framework and Navigation
- ✅ Basic Application Structure

In-progress features:
- 🔄 Barcode Scanning Implementation
- 🔄 OCR Integration
- 🔄 Nutri-Score Algorithm
- 🔄 Product Recommendation Engine

## Future Enhancements

- **Advanced Personalization**: Adapt recommendations based on user dietary preferences and restrictions
- **Multi-Language Support**: Expand beyond Turkish to support multiple languages
- **iOS Version**: Develop an equivalent iOS application
- **Wearable Integration**: Add smartwatch compatibility for quick scanning
- **Enhanced Offline Mode**: More robust offline functionality
- **Social Features**: Allow users to share findings and recommendations
- **Diet Tracking**: Integration with health and fitness applications

## Contributing

We welcome contributions to improve the Nutri-Score application! Here's how you can contribute:

1. **Fork the Repository**: Create your own fork of the project
2. **Create a Feature Branch**: `git checkout -b feature/YourFeature`
3. **Commit Your Changes**: `git commit -m 'Add some feature'`
4. **Push to the Branch**: `git push origin feature/YourFeature`
5. **Open a Pull Request**: Submit your changes for review

### Development Guidelines

- Follow the Kotlin style guide and MVVM architecture pattern
- Ensure all new features include appropriate tests
- Update documentation for any changes to public APIs
- Respect existing code structure and architectural decisions

### Issues and Bugs

If you find a bug or have a suggestion, please [open an issue](https://github.com/username/Nutri-Score-Based-Nutrient-Assessment-and-Recommendation-Application/issues) with a detailed description.

## Development Team

- **Enes Kanbur** ([GitHub](https://github.com/eneskanbur)) - Project Lead & Backend Developer
- **Talha Güneş** ([GitHub](https://github.com/talhagunes)) - UI/UX Design & Frontend Developer

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Open Food Facts](https://world.openfoodfacts.org/) for providing the comprehensive food product database
- [Google ML Kit](https://developers.google.com/ml-kit) for barcode scanning and OCR capabilities
- [Firebase](https://firebase.google.com/) for authentication and cloud storage solutions
- The Nutri-Score initiative for establishing the nutritional scoring system
- Our project supervisor for guidance and support throughout development

---

© 2025 Nutri-Score Application Team | COMP4902 Graduation Design Project
