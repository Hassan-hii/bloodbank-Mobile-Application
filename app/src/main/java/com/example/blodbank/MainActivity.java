import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerTextView = findViewById(R.id.registerTextView);

        // Login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Perform login validation (replace with your own logic)
                if (isValidCredentials(username, password)) {
                    // Login successful, navigate to appropriate screen
                    if (isBanquetOwner(username)) {
                        navigateToBanquetOwnerDashboard();
                    } else {
                        navigateToUserDashboard();
                    }
                } else {
                    // Invalid credentials, display error message
                    showToast("Invalid username or password");
                }
            }
        });

        // Register text click listener
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegistration();
            }
        });
    }

    // Function to validate login credentials
    private boolean isValidCredentials(String username, String password) {
        // Add your own validation logic here (e.g., check against a database)
        // Return true if the credentials are valid, otherwise false
        return true;
    }

    // Function to check if the user is a banquet owner
    private boolean isBanquetOwner(String username) {
        // Add your own logic to determine if the user is a banquet owner
        // Return true if the user is a banquet owner, otherwise false
        return false;
    }

    // Function to navigate to the banquet owner dashboard
    private void navigateToBanquetOwnerDashboard() {
        // Start the banquet owner dashboard activity
        Intent intent = new Intent(MainActivity.this, BanquetOwnerDashboardActivity.class);
        startActivity(intent);
    }

    // Function to navigate to the user dashboard
    private void navigateToUserDashboard() {
        // Start the user dashboard activity
        Intent intent = new Intent(MainActivity.this, UserDashboardActivity.class);
        startActivity(intent);
    }

    // Function to navigate to the registration screen
    private void navigateToRegistration() {
        // Start the registration activity
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    // Function to display toast messages
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
