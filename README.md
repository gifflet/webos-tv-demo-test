# WebOS TV Demo Test Automation

## Getting Started

To get started with this project, follow these steps:

### Prerequisites

- Java 11 or higher
- Maven
- Appium server
- Appium WebOS driver from [appium-lg-webos-driver](https://github.com/headspinio/appium-lg-webos-driver)
- An LG WebOS TV device or emulator
- The WebOS demo app from [WebOS User App Demo](https://github.com/gifflet/webos-user-app-demo)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/gifflet/webos-tv-demo-test
   ```
2. Navigate to the project directory:
   ```bash
   cd webos-tv-demo-test
   ```
3. Compile the project:
   ```bash
   mvn compile
   ```

### Configuration

4. Create a `.env` file from the template:
   ```bash
   cp .env.sample .env
   ```
5. Edit the `.env` file and set the required values:
   ```
   APPIUM_URL=<appium-server-url>
   WEBOS_DEVICE_HOST=<your-tv-ip-address>
   WEBOS_CHROMEDRIVER_PATH=<path-to-chromedriver>
   ```
   
   **Environment variables:**
   - `APPIUM_URL`: URL of the Appium server (e.g., http://localhost:4723)
   - `WEBOS_DEVICE_HOST`: IP address of your WebOS TV device
   - `WEBOS_CHROMEDRIVER_PATH`: Full path to the chromedriver executable
   
   **Note:** All three variables are mandatory. The tests will fail if any of them is missing.

## Running Tests

To run the tests, ensure that the Appium server is running and execute the following command:

```bash
mvn test
```

This will run all the tests defined in the `LoginTest.java` file.
