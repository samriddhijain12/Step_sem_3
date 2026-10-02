import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class RenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<SubscriptionPlan> subscriptions = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr, formatter);

            switch (planType) {
                case "BASIC":
                    subscriptions.add(new BasicPlan(name, startDate));
                    break;
                case "STANDARD":
                    subscriptions.add(new StandardPlan(name, startDate));
                    break;
                case "PREMIUM":
                    subscriptions.add(new PremiumPlan(name, startDate));
                    break;
            }
        }

        for (SubscriptionPlan plan : subscriptions) {
            System.out.printf("%s: %s\n", plan.getName(), plan.calculateRenewalDate().format(formatter));
        }

        sc.close();
    }
}
