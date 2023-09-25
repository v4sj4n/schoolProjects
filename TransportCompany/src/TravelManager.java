import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TravelManager {

    private final ArrayList<Travel> travels = new ArrayList<>();
    private final ArrayList<String> travelCodes = new ArrayList<>();

    public void mainProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a choice");

        while (true) {
            String[] choicesGeneral = {"0) Exit", "1) List", "2) See/Change data", "3) Delete Travel", "4) Add travel"};

            for (String choiceGeneral : choicesGeneral) System.out.printf("%s   ", choiceGeneral);
            System.out.println();

            byte userChoiceGeneral = Byte.parseByte(scanner.nextLine());
            if (userChoiceGeneral == 0) break;

            switch (userChoiceGeneral) {
                case 1 -> {
                    if (travels.isEmpty()) {
                        System.out.println("There are no packages create one :)");
                    } else {
                        for (Travel t : travels) System.out.println(t);
                    }
                }

                case 2 -> {
                    if (travels.isEmpty()) {
                        System.out.println("Can't do actions with no travel packages, please add one!");

                    } else {
                        System.out.println("Pick one of the packages below or type 0 to exit");
                        for (Travel t : travels) System.out.println(t);
                        short packageIndex = Short.parseShort(scanner.nextLine());
                        if (packageIndex == 0) break;
                        while (packageIndex - 1 > travels.size() || packageIndex - 1 < 0) {
                            System.out.println("Please enter a value between 1 and " + travels.size());
                            packageIndex = Short.parseShort(scanner.nextLine());
                        }
                        System.out.println("\nWhich option do you want to explore");
                        String[] choicesEdit = {"0) Exit", "1) Code", "2) From Destination", "3) To Destination", "4) Distance km", "5) Weight km"};
                        for (String choice : choicesEdit) System.out.printf("%s  ", choice);
                        byte actionToBeDone = Byte.parseByte(scanner.nextLine());
                        if (actionToBeDone == (byte) 0) break;
                        switch (actionToBeDone) {
                            case 1 -> codeHandler(travels.get(packageIndex - 1));
                            case 2 -> fromDestinationHandler(travels.get(packageIndex - 1));
                            case 3 -> toDestinationHandler(travels.get(packageIndex - 1));
                            case 4 -> distanceKMHandler(travels.get(packageIndex - 1));
                            case 5 -> weightKGHandler(travels.get(packageIndex - 1));
                            default -> System.out.println("Please enter 1-5");
                        }
                    }

                }

                case 3 -> {
                    if (travels.isEmpty()) {
                        System.out.println("Can't do deletion with no travel packages, please add one!");
                    } else {
                        for (Travel t : travels) System.out.println(t);
                        System.out.println("Pick one of the packages to remove, or type 0 to exit");
                        short packageIndex = Short.parseShort(scanner.nextLine());
                        if (packageIndex == 0) break;
                        while (packageIndex - 1 > travels.size() || packageIndex - 1 < travels.size()) {
                            System.out.println("Please enter a value between 1 and " + travels.size());
                            packageIndex = Short.parseShort(scanner.nextLine());
                        }
                        travels.remove(packageIndex - 1);
                        System.out.println("Package removed successfully");
                    }

                }

                case 4 -> {
                    short packageNo = (short) (travels.size() + 1);
                    String packageCode = codeGenerator();
                    while (travelCodes.contains(packageCode)) packageCode = codeGenerator();
                    travels.add(new Travel(packageNo, packageCode));
                    travelCodes.add(packageCode);
                }
            }
        }

    }

    public void codeHandler(Travel t) {
        System.out.println("You can only get the code of the travel which is " + t.getCode());
    }

    public void fromDestinationHandler(Travel t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to get or set the value of From Destination: ");
        String userChoice = sc.nextLine();
        while (!(userChoice.equalsIgnoreCase("get") || userChoice.equalsIgnoreCase("set"))) {
            System.out.println("Please enter get/set or 0 to exit");
            userChoice = sc.nextLine();
            if (userChoice.equalsIgnoreCase("0")) return;
        }
        if (userChoice.equalsIgnoreCase("get")) {
            System.out.println(t.getFromDestination());
        } else {
            t.setFromDestination();
        }
    }

    public void toDestinationHandler(Travel t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to get or set the value of To Destination: ");
        String userChoice = sc.nextLine();
        while (!(userChoice.equalsIgnoreCase("get") || userChoice.equalsIgnoreCase("set"))) {
            System.out.println("Please enter get/set or 0 to exit");
            userChoice = sc.nextLine();
            if (userChoice.equalsIgnoreCase("0")) return;
        }
        if (userChoice.equalsIgnoreCase("get")) {
            System.out.println(t.getToDestination());
        } else {
            t.setToDestination();
        }

    }

    public void distanceKMHandler(Travel t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to get or set the value of Destination km: ");
        String userChoice = sc.nextLine();
        while (!(userChoice.equalsIgnoreCase("get") || userChoice.equalsIgnoreCase("set"))) {
            System.out.println("Please enter get/set or 0 to exit");
            userChoice = sc.nextLine();
            if (userChoice.equalsIgnoreCase("0")) return;
        }
        if (userChoice.equalsIgnoreCase("get")) {
            System.out.println(t.getDistanceKm());
        } else {
            t.setDistanceKm();
        }

    }

    public void weightKGHandler(Travel t) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to get or set the value of Weight km: ");
        String userChoice = sc.nextLine();
        while (!(userChoice.equalsIgnoreCase("get") || userChoice.equalsIgnoreCase("set"))) {
            System.out.println("Please enter get/set or 0 to exit");
            userChoice = sc.nextLine();
            if (userChoice.equalsIgnoreCase("0")) return;
        }
        if (userChoice.equalsIgnoreCase("get")) {
            System.out.println(t.getWeightKg());
        } else {
            t.setWeightKg();
        }
    }

    private String codeGenerator() {
        String chars = "abcdefghijklmnopqrstuvxyz";
        String nums = "0123456789";
        String symbols = "@$%&!?#";
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                code.append(chars.charAt(random.nextInt(chars.length())));
            } else if (i % 3 == 1) {
                code.append(nums.charAt(random.nextInt(nums.length())));
            } else {
                code.append(symbols.charAt(random.nextInt(symbols.length())));
            }

        }
        return code.toString();

    }

}
