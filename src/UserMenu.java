public class UserMenu {

    DatabaseUserIO databaseUserIO = new DatabaseUserIO();
    TextUI textUI = new TextUI();
    public void setupUserMenu() {

        databaseUserIO.loadUsers();

        String userInput = textUI.getUserInput();

        switch (userInput) {
            case "1":
                textUI.loginMenu();
                break;
            case "2":
                textUI.createUserMenu();

                databaseUserIO.saveUsers();
                break;
            default:
                System.out.println("Goodbye");
        }
        //  userHandler.saveUsers();
    }
}