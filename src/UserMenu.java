public class UserMenu {

    DatabaseUserIO databaseUserIO = new DatabaseUserIO();
    TextUI textUI = new TextUI(databaseUserIO);
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
        textUI.pickLevel();
    }
}