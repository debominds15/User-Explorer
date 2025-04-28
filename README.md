# UserList App

A simple Android application built with modern Android development practices.  
This project demonstrates a layered **Multi-Module Clean Architecture** approach using **Jetpack Compose**, **Hilt for Dependency Injection**, **Kotlin Coroutines** for asynchronous operations, and unit tests.

---

## Features

- List Screen: Displays a list of users fetched from a remote API.
- Detail Screen: Shows details of a selected user.
- Modularized Architecture: Features, Domain, Data, and Core modules.
- Network call integration using Retrofit.
- Dependency Injection with Hilt.
- Asynchronous programming using Kotlin Coroutines.
- Unit testing for repository and view model layers.

---

## Technologies Used

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern UI Toolkit
- **Hilt** - Dependency Injection
- **Kotlin Coroutines** - For asynchronous operations
- **Retrofit** - Networking library
- **Multi-Module Clean Architecture** - For scalable, maintainable codebase
- **JUnit & Mockito** - For unit testing

---

## Architecture

I have followed a **Layered Modular Clean Architecture**, where the code is divided into distinct modules:

| Layer | Responsibility |
| :--- | :--- |
| `:feature` | UI (Jetpack Compose screens, ViewModels) |
| `:domain` | Business logic (Use Cases, Repository Interfaces, Models) |
| `:data` | Data sources (Repository Implementations, API services) |
| `:core` | Common/shared dependencies (Networking setup, Hilt modules, Utilities) |

This separation ensures:
- Clear boundaries between layers
- Improved maintainability
- Easier unit testing
- Production-like project structure without overcomplication for a small app

---

## Assumptions

- The API endpoint `https://fake-json-api.mock.beeceptor.com/users` is available and returns a list of users.
- Basic user information is sufficient for the detail screen in this sample app.
- No local database (Room) has been added as per the requirement; data is fetched directly from the network.

---

## Testing Strategy

- Unit tests are written for:
  - `UserRepositoryImpl` (in `data` module)
  - `GetUsersUseCase` (in `domain` module)
  - `UserListViewModel` (in `presentation` module)
- Used **JUnit5**, **Mockito**, and **Kotlinx Coroutines Test** for testing.

---

## Project Structure
app/ // Entry point of the app (MainActivity, Hilt setup) ├── core/ // Core module for common utilities (Networking, Hilt modules, constants) ├── domain/ // Domain layer: Business logic (UseCases, Repository Interfaces, Models) ├── data/ // Data layer: Handles data sources (Repository implementations, API services) ├── feature_list/ // Feature module for User List screen (Compose UI, ViewModel) ├── feature_detail/ // Feature module for User Detail screen (Compose UI)

### Module Responsibilities

- **app**: Contains `MainActivity`, sets up Hilt and navigation between features.
- **core**: Contains shared components like Retrofit setup, Network constants, Hilt modules.
- **domain**: Defines pure business logic: Models, Repository Interfaces, and UseCases.
- **data**: Implements Repository interfaces, fetches data from API.
- **feature_list**: UI for displaying a list of users, corresponding ViewModel.
- **feature_detail**: UI for showing user details, corresponding ViewModel.

---
## API Used

**Primary API**:  
https://fake-json-api.mock.beeceptor.com/users
