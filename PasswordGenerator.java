import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Method to generate a random password
    public static String generatePassword(int length, boolean includeUppercase, boolean includeNumbers, boolean includeSpecialChars) {
        // Build character set based on user options
        StringBuilder characterSet = new StringBuilder(LOWERCASE);
        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        if (includeNumbers) {
            characterSet.append(NUMBERS);
        }
        if (includeSpecialChars) {
            characterSet.append(SPECIAL_CHARS);
        }

        // Ensure at least one character set is included
        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        // Generate the password
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 16; // Desired password length
        boolean includeUppercase = true;
        boolean includeNumbers = true;
        boolean includeSpecialChars = true;

        String password = generatePassword(passwordLength, includeUppercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }
}
