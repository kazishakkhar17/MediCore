//package medi.core;
//
//public class UpdatePassword {
//
//    public static void main(String[] args) {
//        try {
//            // Hash the new password
//            String hashedPassword = Hasher.hashPassword("123456");
//
//            // Prepare the SQL UPDATE query
//            String updateQuery = "UPDATE login SET password = '" + hashedPassword + "' WHERE id = 'kazi'";
//
//            // Create a database connection object
//            conn c = new conn();
//
//            // Execute the update query
//            int rowsAffected = c.statement.executeUpdate(updateQuery);
//
//            // Check if the update was successful
//            if (rowsAffected > 0) {
//                System.out.println("Password updated successfully for user 'kazi'.");
//            } else {
//                System.out.println("Failed to update password for user 'kazi'.");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
