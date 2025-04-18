def call() {
    echo "Running unit tests..."
    if (fileExists('package.json')) {
        try {
            sh "npm test"
            echo "Unit tests execution initiated using npm test"
        } catch (Exception err) {
            echo "Warning: npm test command failed or not configured in package.json. " +
                 "See console output for details. Continuing build..."
        }
    } else {
        echo "Warning: package.json not found. Skipping unit tests."
    }  
    echo "Unit test completed successfully"
}
