import java.util.Random;
import java.util.Scanner;

public class Travel {
    private final String code = codeGenerator();
    private String fromDestination;
    private String toDestination;
    private float distanceKm;
    private float weightKg;
    public String travelName;

    private final Scanner scanner = new Scanner(System.in);

    public Travel(short TravelName) {
        System.out.println("Enter from destination: ");
        String FromDestination = scanner.nextLine();
        if (FromDestination.isEmpty()) {
            System.out.println("You can't leave from destination blank.");
            FromDestination = scanner.nextLine();
        }
        this.fromDestination = FromDestination;


        System.out.println("Enter to destination: ");
        String ToDestination = scanner.nextLine();
        if (ToDestination.isEmpty()) {
            System.out.println("You can't leave to destination blank.");
            ToDestination = scanner.nextLine();
        }
        this.toDestination = ToDestination;

        System.out.println("Enter distance km: ");
        float DistanceKm = Float.parseFloat(scanner.nextLine());
        if (DistanceKm < 10) {
            System.out.println("Small distance, please enter a bigger one.");
            DistanceKm = Float.parseFloat(scanner.nextLine());
        }
        this.distanceKm = DistanceKm;

        System.out.println("Enter weight in kg: ");
        float WeightKg = Float.parseFloat(scanner.nextLine());
        if (WeightKg < 0 || weightKg > 2000) {
            System.out.println((weightKg > 2000) ? "The weight should be smaller than 2000kg" : "Weight can't be 0");
            WeightKg = Float.parseFloat(scanner.nextLine());
        }
        this.weightKg = WeightKg;

        this.travelName = "Package " + TravelName+1;
        System.out.printf("Created %s successfully \n", this);


    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public float getDistanceKm() {
        return distanceKm;
    }

    public float getWeightKg() {
        return weightKg;
    }


    // Setters

    public void setFromDestination() {
        System.out.println("Enter new \"from destination\", previous one was " + this.fromDestination);
        String newFromDestination = scanner.nextLine();
        while (newFromDestination.isEmpty() || this.fromDestination.equalsIgnoreCase(newFromDestination)) {
            System.out.println((newFromDestination.isEmpty()) ? "From Destination can't be empty please enter it again"
                    : "The destination you entered is the same as the one you have registered, please change it or exit by entering 0");
            newFromDestination = scanner.nextLine();
            if (newFromDestination.equals("0")) return;
        }

        this.fromDestination = newFromDestination;
        System.out.println("From destination updated successfully to " + this.fromDestination + "\n");

    }

    public void setToDestination() {
        System.out.println("Enter new \"to destination\",previous one was " + this.distanceKm);
        String newToDestination = scanner.nextLine();
        while (newToDestination.isEmpty() || this.fromDestination.equalsIgnoreCase(newToDestination)) {
            System.out.println((newToDestination.isEmpty()) ? "To Destination can't be empty please enter it again"
                    : "The destination you entered is the same as the one you have registered, please change it or exit by entering 0");
            newToDestination = scanner.nextLine();
            if (newToDestination.equals("0")) return;

        }

        this.toDestination = newToDestination;
        System.out.println("To destination updated successfully to " + this.toDestination + "\n");
    }

    public void setDistanceKm() {
        System.out.println("Enter new \"distance km\", previous one was " + this.distanceKm);
        float newDistanceKm = Float.parseFloat(scanner.nextLine());
        while (newDistanceKm < 10) {
            System.out.println("The distance should be bigger than 10, enter a bigger distance or exit by entering 0");
            newDistanceKm = Float.parseFloat(scanner.nextLine());
            if (newDistanceKm == 0) return;

        }
        this.distanceKm = newDistanceKm;
        System.out.println("Distance in km updated successfully to " + this.distanceKm + "\n");
    }

    public void setWeightKg() {
        System.out.println("Enter new \"weight kg\", previous one was " + this.weightKg);
        float newWeightKg = Float.parseFloat(scanner.nextLine());
        while (newWeightKg < 0 || newWeightKg > 2000) {
            System.out.println((newWeightKg < 0) ? "The weight should be bigger than 0, please enter a bigger one or type 0 again to exit" :
                    "The weight should be smaller than 2000kg, please enter a smaller weight or type 0 to exit");
            newWeightKg = Float.parseFloat(scanner.nextLine());
            if (newWeightKg == 0) return;

        }
        this.weightKg = newWeightKg;
        System.out.println("Distance in km updated successfully to " + this.weightKg + "\n");
    }


    private String codeGenerator() {
        String chars = "abcdefghijklmnopqrstuvxyz";
        String nums = "0123456789";
        String symbols = "@$%&!?#§";
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

    @Override
    public String toString() {
        return this.travelName;
    }
}
